require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "5c725d38ba329ee8494ff3f142d34a9b573cdd25a3f59b09e4a17d4dbc858c3e"
SRC_URI[amd64.sha256sum]     = "e9375a321faaba03c93e006f40318eb986937658e09287cdf0117b9e28ab8fbe"
SRC_URI[arm.sha256sum]       = "2e6e551ed7f62b35ca2df078ac924d0a7af8389fa20a19cc23a3c69933f1d3dc"
SRC_URI[arm64.sha256sum]     = "a7c9e801f43c04290481c2f6b0baad6fcaa82db3149fac232b2601115dd65db7"
