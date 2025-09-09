require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "1c3d18d4835aaea280117e30b4b4312f6475acd5b155769a7168db02511bf2fb"
SRC_URI[amd64.sha256sum]     = "3b122d9f1fbf281cf3c79fd61e84c89af9a3647c464859cbee8f133ffa74e8f8"
SRC_URI[arm.sha256sum]       = "61c6485308fd45c1a7e6be24adaf00406a5aba5ebd7c34fe73632c0992f137af"
SRC_URI[arm64.sha256sum]     = "bcc23dc30be2309c09f0d70692abf7442bc4772b491989b175734f0ca8a5fb9f"
