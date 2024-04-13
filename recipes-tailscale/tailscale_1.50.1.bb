require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "4021a24335786f02a53671051003227ba86bccb6216dee3b28adf91ebea64cf7"
SRC_URI[amd64.sha256sum]     = "d9fe6b480fb5078f0aa57dace686898dda7e2a768884271159faa74846bfb576"
SRC_URI[arm.sha256sum]       = "94e93182db56798a93db0c371f7753bc6bde59552604746f473c713f5306b128"
SRC_URI[arm64.sha256sum]     = "ffee0d18b41715b59fc0cf38b1effd55041f65ce946ef0566ce07dd193b0d4f5"
