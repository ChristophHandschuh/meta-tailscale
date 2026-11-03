require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "720f7986d9c494793c5fb030e0d111830eb76ecb2d70d5c1a470157ea3bc9806"
SRC_URI[amd64.sha256sum]     = "720cbbccbfc03d8b55df72afc19e5a72e31b0f65934700aa6fa38074d4ad7bf7"
SRC_URI[arm.sha256sum]       = "39e2bdf0042f38bf49beec357375c11c711f9c60f8e7242f385b5616c63dcd6e"
SRC_URI[arm64.sha256sum]     = "e900b0e6e25023a1e504b2c237ce2a32ea0535e006f8c1a1097a490886493b6c"
