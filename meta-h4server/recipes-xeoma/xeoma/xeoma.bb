DESCRIPTION = "xeoma"
SECTION = "apps"
HOMEPAGE = "https://felenasoft.com/xeoma/en/"
LICENSE = "CLOSED"
RDEPENDS_${PN} = "libusb1 hidapi alsa-lib udev glibc"

inherit systemd useradd features_check

# Version: 24.2.14
# Set SRC_URI subdir to ${P} so that files are unpacked into ${S}
SRC_URI = "https://felenasoft.com/xeoma/downloads/2024-02-14/linux/xeoma_linux64.tgz;subdir=${P}"
SRC_URI[md5sum] = "2fda8e87801f5129c776399be068ba86"
SRC_URI[sha256sum] = "fb2589fdd60bd0010ef75a192d8f85cc2eb1391f57cc4fc99cd98bedd136f982"

# Comes pre-stripped
INSANE_SKIP:${PN} = "ldflags"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "xeoma.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--uid 800 --system --shell /bin/false xeoma"

FILES:${PN} += " \
    ${bindir}/xeoma \
    ${systemd_unitdir}/systemd/xeoma.service \
    ${sysconfdir}/udev/rules.d/99-xeoma-usb-key.rules \
"

REQUIRED_DISTRO_FEATURES = "systemd"

do_install () {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/xeoma.app ${D}/${bindir}/xeoma

    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${THISDIR}/systemd/xeoma.service ${D}/${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${THISDIR}/udev/99-xeoma-usb-key.rules ${D}${sysconfdir}/udev/rules.d/99-xeoma-usb-key.rules
    
    install -m 0750 -d ${D}${localstatedir}/xeoma/data
    install -m 0750 -d ${D}${localstatedir}/xeoma/cache
    chown -R xeoma:xeoma ${D}${localstatedir}/xeoma
}
