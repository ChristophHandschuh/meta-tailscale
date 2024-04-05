require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "3199f6dc47a98fe8fbfa8878b2eef90080102c0e402ad5d827bc87afca737834"
SRC_URI[amd64.sha256sum]     = "644b58f660af191d0a0aff034cbc197059c90a2ee4276e13e647129175b352c1"
SRC_URI[arm.sha256sum]       = "439ab24ba73a4ece6e76055d07724e401ad5a789d942af10a38899a7d8d6fd26"
SRC_URI[arm64.sha256sum]     = "cb58658b3efe96a6e317356799d4ad75a84f07e2c5f7b3d2de0764305961f73e"
