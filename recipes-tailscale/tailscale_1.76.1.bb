require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "c70464b73bf36a01af86076d287ebb2cf3c0d0b9beb7a3f5120abd6d14ac1646"
SRC_URI[amd64.sha256sum]     = "6b11493710d8aa706027f41b2dbf1eb92069d5969490f46460e686c424b96036"
SRC_URI[arm.sha256sum]       = "1510d9e19f581605f7f31732d5e01981aae6c506a710fbced2371a18f2b95a81"
SRC_URI[arm64.sha256sum]     = "3f3760f3e49a55511d96db1d9b741053b8c24428dcea7bc1f6b8fa5b12310318"
