#!/usr/bin/env bash
# upgrade.sh — add a recipe for a new Tailscale release.
#
#   ./upgrade.sh 1.104.4   # create recipes-tailscale/tailscale_1.104.4.bb
#   ./upgrade.sh           # same, for the latest stable release
#
# Fetches the sha256 of the prebuilt tarball for every arch tailscale.inc
# supports and writes the recipe in the same format as the existing ones.
# Nothing pins the version, so BitBake picks the highest tailscale_*.bb.
set -euo pipefail

BASE_URL="https://pkgs.tailscale.com/stable"
ARCHES=(386 amd64 arm arm64)
SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
RECIPES_DIR="${RECIPES_DIR:-$SCRIPT_DIR/recipes-tailscale}"

die() { printf 'upgrade.sh: %s\n' "$*" >&2; exit 1; }

if [[ $# -gt 1 ]]; then
    printf 'Usage: %s [version]\n' "$(basename "$0")" >&2
    exit 1
fi

PV="${1:-}"
if [[ -z "$PV" ]]; then
    PV="$(curl -fsSL "$BASE_URL/?mode=json" \
        | sed -n 's/.*"TarballsVersion": *"\([^"]*\)".*/\1/p')" \
        || die "could not read the latest version from $BASE_URL/?mode=json"
    echo "Latest stable: $PV"
fi
[[ "$PV" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]] || die "invalid version '$PV' (expected e.g. 1.104.4)"

RECIPE="$RECIPES_DIR/tailscale_${PV}.bb"
[[ -e "$RECIPE" ]] && die "$RECIPE already exists"

# Collect every checksum first, so a failure leaves no half-written recipe.
declare -A SUMS
for arch in "${ARCHES[@]}"; do
    url="$BASE_URL/tailscale_${PV}_${arch}.tgz.sha256"
    sum="$(curl -fsSL "$url" | awk '{print $1}')" || die "download failed for $arch: $url"
    [[ "$sum" =~ ^[0-9a-f]{64}$ ]] || die "no valid sha256 for $arch: $url"
    SUMS[$arch]="$sum"
done

{
    echo 'require tailscale.inc'
    echo
    echo '# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256'
    for arch in "${ARCHES[@]}"; do
        printf '%-29s= "%s"\n' "SRC_URI[${arch}.sha256sum]" "${SUMS[$arch]}"
    done
} > "$RECIPE"

echo "Created $RECIPE:"
cat "$RECIPE"
cat <<EOF

Next:
  - the next build uses it (highest tailscale_*.bb wins);
  - bump DISTRO_VERSION in meta-autofran/conf/distro/autofran.conf for the OTA;
  - delete old tailscale_*.bb files you no longer want.
EOF
