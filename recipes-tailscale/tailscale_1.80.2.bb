require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "57b70486db74fca8ee8cf7b12d5c80daf17ba6fdf64472d8f1be00dd5e2ba0e4"
SRC_URI[amd64.sha256sum]     = "24e370743442297e54f7b3eeef1e0644ddfd58fd62e17a45e0b3caf47aa420a0"
SRC_URI[arm.sha256sum]       = "2809d165f7d35ded18f561793ee1013690f4f5606acdc5b9e52ce0fcdb21cd6f"
SRC_URI[arm64.sha256sum]     = "4f1cb13ff91529d8074524966d4eada3a9a412c8995ab6b66b8eb637017211c8"