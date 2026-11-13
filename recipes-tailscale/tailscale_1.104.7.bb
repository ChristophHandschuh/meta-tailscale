require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "041c3ac8198f52b3259873611b14551111aa3c80198d445cc2bbb755e1e29580"
SRC_URI[amd64.sha256sum]     = "e56693ff74a64f2591b7e819c280635a100aae1ddfb0ef058fcd052b7cd8d16c"
SRC_URI[arm.sha256sum]       = "1c753fef45d497491081db37552b7a2a42c7932292743bf6936cb1a42b6bceb0"
SRC_URI[arm64.sha256sum]     = "d6bed2720310b328b861f943d7b4016c5358a9bad60575eb51e8143b79068484"
