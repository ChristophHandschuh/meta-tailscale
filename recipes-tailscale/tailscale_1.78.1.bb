require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "1c4e49a9c26177408cb865985eb1176087310ded3bd6aac57126d5e52094eabe"
SRC_URI[amd64.sha256sum]     = "3db491bd6800012173cb6b739fa6705272f71da3e622f23639a3a385f2474a89"
SRC_URI[arm.sha256sum]       = "6e96650f9073f80c2ef4b1c4bd6a717db8211bb0828a02aea1d60d9d88b8d005"
SRC_URI[arm64.sha256sum]     = "8eb0ae11ac2f80beac379722b37651e6ef328d098fec0425ca2786c1c8f087e3"
