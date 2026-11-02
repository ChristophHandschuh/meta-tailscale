require tailscale.inc

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "462e367bb965f6db8044f78c96ba5e9101f8d5ad91506b4a0f33a96912e63573"
SRC_URI[amd64.sha256sum]     = "624ea093d47d62cf56f17b8332d74b8decda4a1faa610ebc60a1de334b2b3dc9"
SRC_URI[arm.sha256sum]       = "7412390619633d040dbb030c92626d10f3d056e2d9087fc1026556881bbe0de3"
SRC_URI[arm64.sha256sum]     = "a1c249ce6bdebef62e1ae3b997595555bce2ae4709bf95a718e9ca7a129dad7e"
