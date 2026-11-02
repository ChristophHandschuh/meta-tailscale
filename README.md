# OpenEmbedded/Yocto layer for Tailscale

This layer supports arm/arm64/i386/x86_64 architectures. If your board uses an other architecture edit the download link and the corresponding folder names.

Note this recipe uses the pre-built binaries from Tailscale and does not attempt to build it from source.

The latest releases of Tailscale stable binaries can be found here: https://pkgs.tailscale.com/stable/#static 

## Upgrading

```bash
./upgrade.sh            # add a recipe for the latest stable release
./upgrade.sh 1.104.4    # or for a given version
```

It writes `recipes-tailscale/tailscale_<version>.bb` with the sha256 of the
386, amd64, arm and arm64 tarballs from pkgs.tailscale.com. BitBake builds the
highest version present, so delete old recipes you no longer want.
