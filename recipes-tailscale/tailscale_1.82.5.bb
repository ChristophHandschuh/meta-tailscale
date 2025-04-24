require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "a2f732003543442f59bd84b7ef451fc1c98fe2940d2d0a0139904a323630a98e"
SRC_URI[amd64.sha256sum]     = "41a8931fa52055bd7ea4b51df9acff2ba2d4e9000c2380b667539b5b99991464"
SRC_URI[arm.sha256sum]       = "94b9bc3177027a64774e4d9678e24cffb2f0a43b42c4a1b088a6f3352f8609ed"
SRC_URI[arm64.sha256sum]     = "8361aa3bc0cbbfd79363fef4e16b86cb4b8b5b18d186f9bc5c2dfcdf981d9d44"