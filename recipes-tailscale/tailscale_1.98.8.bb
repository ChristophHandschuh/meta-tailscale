require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "0f3599e7c74e7afb2976060d03dd3c5ac52042f6d3a31971c8edbc7115c93076"
SRC_URI[amd64.sha256sum]     = "3a55b5900dd7e11e09b6c74d1e46d223d549dfbefbdc1f044a8ab7bdbafb933c"
SRC_URI[arm.sha256sum]       = "3de36af9fa58f465113bc7cfce7cdb5eb7fc2d99d24b48febd819672916b58ac"
SRC_URI[arm64.sha256sum]     = "53eb3ce89d062fd34e393d24a6c8ec08c769fede8eb77fe9c6e347ad4ae00f84"
