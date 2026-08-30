require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "e613246f7496e6a87a9015666417e1e474a2f9263b47e09e4ca31d34f02ddd18"
SRC_URI[amd64.sha256sum]     = "36ddd9b51be57ffc2990cf76323cfa13643bfbb1b8a969f6183fa164741cdef5"
SRC_URI[arm.sha256sum]       = "568dffd398fa70698de3671a05f078dc29fef62b1daf248ef1f45f82fc3dc75d"
SRC_URI[arm64.sha256sum]     = "a0fa1b154af8c61f862a2259f559f7396d96c0225f4a863eae2333e1546bbe25"
