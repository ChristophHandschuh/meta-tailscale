require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "00d784c21c3c8786e31c2961496e6dce6badaaa91ff02db70a44227d56f5e380"
SRC_URI[amd64.sha256sum]     = "c61bad47c11647b579c15906dabdd20b58252e826306b6415a04fca78d14bedb"
SRC_URI[arm.sha256sum]       = "21b013ca6e64f1c4c58e7645a73934f39175ba2a9290a5dc85eb3d2db46d1e72"
SRC_URI[arm64.sha256sum]     = "3e3d574c26743c79abf747a00c8adbf98d21d06c880f9a5567afbc5eb29dde0c"
