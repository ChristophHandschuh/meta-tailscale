require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "f3fe6f3fb93238d56dc6238d392f95837cd6f3902aa6d07fa9d10196a5061222"
SRC_URI[amd64.sha256sum]     = "aab73c3dc6ded7b34b6aeb01e80ef99ce506bb525d6f7bf699b8bcf5972b4c8b"
SRC_URI[arm.sha256sum]       = "821bb5fc668bc080d77d2c8b4322380dd10693472cbd2e2b0ef1948c20578979"
SRC_URI[arm64.sha256sum]     = "f0dd9c4366d0bc4ca7957f8e819183084f366f54beccea883c9074a7de0bd4c6"
