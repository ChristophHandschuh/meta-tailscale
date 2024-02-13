SUMMARY = "Tailscale client and daemon for Linux from Tailscale pre-built binaries"

HOMEPAGE = "github.com/tailscale/tailscale"
SECTION = "net"

LICENSE = "CLOSED"

COMPATIBLE_HOST = ".*(aarch64|arm|x86\_64|i386).*"

ARCH_DIR:i386 = "386"
ARCH_DIR:x86-64 = "amd64"
ARCH_DIR:aarch64 = "arm64"
ARCH_DIR:arm = "arm"

# See: https://pkgs.tailscale.com/stable/
SRC_URI = "https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz;subdir=${P};name=${ARCH_DIR}"

# Find checksum with: https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz.sha256
SRC_URI[386.sha256sum]       = "5c725d38ba329ee8494ff3f142d34a9b573cdd25a3f59b09e4a17d4dbc858c3e"
SRC_URI[amd64.sha256sum]     = "e9375a321faaba03c93e006f40318eb986937658e09287cdf0117b9e28ab8fbe"
SRC_URI[arm.sha256sum]       = "2e6e551ed7f62b35ca2df078ac924d0a7af8389fa20a19cc23a3c69933f1d3dc"
SRC_URI[arm64.sha256sum]     = "a7c9e801f43c04290481c2f6b0baad6fcaa82db3149fac232b2601115dd65db7"

inherit systemd

# Runtime dependencies, iptables required.
RDEPENDS:${PN} = "iptables"

FILES_${PN} += "${systemd_unitdir}/*"
FILES:${PN} += "/lib /lib/systemd/"
FILES:${PN} += "/usr/lib"
FILES:${PN} += "/usr/lib/systemd"
FILES:${PN} += "/usr/lib/systemd/system"
FILES:${PN} += "/usr/lib/systemd/system/tailscaled.service"

S = "${WORKDIR}/${PN}-${PV}/${PN}_${PV}_${ARCH_DIR}"

do_install() {
  install -d ${D}/${bindir}

  install -d ${D}/${sbindir}

  install ${S}/tailscale ${D}/${bindir}/tailscale

  install ${S}/tailscaled ${D}/${sbindir}/tailscaled

  # TODO: Not working for some reason.
  #if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then

  install -d ${D}${sysconfdir}/default/

  install -m 0644 ${S}/systemd/tailscaled.defaults ${D}${sysconfdir}/default/tailscaled

  install -d ${D}${systemd_unitdir}/system

  install -m 0644 ${S}/systemd/tailscaled.service ${D}${systemd_unitdir}/system/tailscaled.service

  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

  ln -s ${systemd_unitdir}/system/tailscaled.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/tailscaled.service

  #fi
}

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "tailscaled.service"

SYSTEMD_AUTO_ENABLE = "enable"
