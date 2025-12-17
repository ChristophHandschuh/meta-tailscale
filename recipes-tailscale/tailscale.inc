SUMMARY = "Tailscale client and daemon for Linux from Tailscale pre-built binaries"

HOMEPAGE = "github.com/tailscale/tailscale"
SECTION = "net"

LICENSE = "CLOSED"

INHIBIT_DEFAULT_DEPS = "1"

ARCH_DIR ?= "Unsupported"
ARCH_DIR:i386 = "386"
ARCH_DIR:x86-64 = "amd64"
ARCH_DIR:aarch64 = "arm64"
ARCH_DIR:arm = "arm"

# See: https://pkgs.tailscale.com/stable/
SRC_URI = "https://pkgs.tailscale.com/stable/tailscale_${PV}_${ARCH_DIR}.tgz;subdir=${P};name=${ARCH_DIR}"

inherit systemd

# These are needed to do the package splitting
DEPENDS:append = " virtual/${HOST_PREFIX}gcc virtual/${HOST_PREFIX}compilerlibs virtual/libc"
# Runtime dependencies, iptables required.
RDEPENDS:${PN} = "iptables"

# Runtime recommendations, kernel modules required
# RECOMMEDS as a kernel config might build them in rather than
# package as a module.
RRECOMMENDS:${PN} = "\
    kernel-module-wireguard \
    kernel-module-tun \
    kernel-module-xt-mark \
    kernel-module-xt-tcpudp \
    kernel-module-xt-masquerade"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "tailscaled.service"
SYSTEMD_AUTO_ENABLE = "enable"

S = "${WORKDIR}/${PN}-${PV}/${PN}_${PV}_${ARCH_DIR}"

do_install() {
  install -d ${D}/${bindir}
  install ${S}/tailscale ${D}/${bindir}/tailscale

  install -d ${D}/${sbindir}
  install ${S}/tailscaled ${D}/${sbindir}/tailscaled

  if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
    install -d ${D}${sysconfdir}/default/
    install -m 0644 ${S}/systemd/tailscaled.defaults ${D}${sysconfdir}/default/tailscaled

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/systemd/tailscaled.service ${D}${systemd_unitdir}/system/tailscaled.service
  fi
}
