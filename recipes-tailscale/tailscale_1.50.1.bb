SUMMARY = "Tailscale client and daemon for Linux from Tailscale pre-built binaries"

HOMEPAGE = "github.com/tailscale/tailscale"
SECTION = "net"

LICENSE = "CLOSED"

COMPATIBLE_HOST = "(aarch64|arm|x86\_64|i386).*-linux"

ARCH_DIR:i386 = "386"
ARCH_DIR:x86_64 = "amd64"
ARCH_DIR:aarch64 = "arm64"
ARCH_DIR:arm = "arm"

# See: https://pkgs.tailscale.com/stable/
SRC_URI = "https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz;subdir=${P};name=${ARCH_DIR}"

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "4021a24335786f02a53671051003227ba86bccb6216dee3b28adf91ebea64cf7"
SRC_URI[amd64.sha256sum]     = "d9fe6b480fb5078f0aa57dace686898dda7e2a768884271159faa74846bfb576"
SRC_URI[arm.sha256sum]       = "94e93182db56798a93db0c371f7753bc6bde59552604746f473c713f5306b128"
SRC_URI[arm64.sha256sum]     = "ffee0d18b41715b59fc0cf38b1effd55041f65ce946ef0566ce07dd193b0d4f5"

inherit systemd

# Runtime dependencies, iptables required.
RDEPENDS:${PN} = "iptables"

FILES_${PN} += "${systemd_unitdir}/*"
FILES:${PN} += "/lib /lib/systemd/"

S = "${WORKDIR}/${PN}-${PV}/${PN}_${PV}_${ARCH_DIR}"

do_install() {
  install -d ${D}/${bindir}

  install -d ${D}/${sbindir}

  install ${S}/tailscale ${D}/${bindir}/tailscale

  install ${S}/tailscaled ${D}/${sbindir}/tailscaled

  # TODO: Not working for some reason.
  #if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then

  install -d ${D}${sysconfdir}/default/

  install -m 0644 ${S}/systemd/tailscaled.defaults ${D}${sysconfdir}/default/tailscaled

  install -d ${D}${systemd_unitdir}/system

  install -m 0644 ${S}/systemd/tailscaled.service ${D}${systemd_unitdir}/system/tailscaled.service

  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

  ln -s ${systemd_unitdir}/system/tailscaled.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/tailscaled.service

  #fi
}

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "tailscaled.service"

SYSTEMD_AUTO_ENABLE = "enable"
