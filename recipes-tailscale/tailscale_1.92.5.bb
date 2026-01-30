require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "ea2a483fc10882de91a1741effbec0347fb278aa5070d448318882643a92ab41"
SRC_URI[amd64.sha256sum]     = "340936481d6bb7d15ee20c7f881f7b4edef01606a7273cde65164f9e8c5b3c89"
SRC_URI[arm.sha256sum]       = "db77be7b897fea0b783a378a22d90330a0aa23ade1e545aaeaffe47ad08da107"
SRC_URI[arm64.sha256sum]     = "13a59c3181337dfc9fdf9dea433b04c1fbf73f72ec059f64d87466b79a3a313c"
