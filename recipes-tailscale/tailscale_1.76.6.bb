require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "ffcfcf7caecee54ab90d9df2bf61ab540279378fc095ede0a5cd1f7dfb11b881"
SRC_URI[amd64.sha256sum]     = "08f2377b78f7b9e411caa28f231a9c4cd0887209c142b49b815bcc7042ff61f7"
SRC_URI[arm.sha256sum]       = "00c9045e4902b1140ff27d920ff7df4da827e24565f5d8c2271f7665d7c44a0e"
SRC_URI[arm64.sha256sum]     = "a906659b57590a195370e93719d9633975db64704e90eb1ed9f8cd3d437b4941"
