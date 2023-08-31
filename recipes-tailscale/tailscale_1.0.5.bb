SUMMARY = "Tailscale client and daemon for Linux from Tailscale pre-built binaries"

HOMEPAGE = "github.com/tailscale/tailscale"
SECTION = "net"

LICENSE = "CLOSED"
BB_STRICT_CHECKSUM = "0"

COMPATIBLE_HOST = "arm-phytec-linux-gnueabi"

SRC_URI = "https://pkgs.tailscale.com/stable/tailscale_1.48.1_arm.tgz;subdir=${P}"


inherit systemd

FILES_${PN} += "${systemd_unitdir}/*"
FILES:${PN} += "/lib /lib/systemd/"

do_install() {

install -d ${D}/${bindir}

install -d ${D}/${sbindir}

install ${S}/${PN}_1.48.1_arm/tailscale ${D}/${bindir}/tailscale

install ${S}/${PN}_1.48.1_arm/tailscaled ${D}/${sbindir}/tailscaled

if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then

install -d ${D}${sysconfdir}/default/

install -m 0644 ${S}/${PN}_1.48.1_arm/systemd/tailscaled.defaults ${D}${sysconfdir}/default/tailscaled

install -d ${D}${systemd_unitdir}/system

install -m 0644 ${S}/${PN}_1.48.1_arm/systemd/tailscaled.service ${D}${systemd_unitdir}/system/tailscaled.service

install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

ln -s ${systemd_unitdir}/system/tailscaled.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/tailscaled.service

fi

}

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "tailscaled.service"

SYSTEMD_AUTO_ENABLE = "enable"
