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
