FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://00-enp2s0.network \
    file://timesyncd.local.conf \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/00-enp2s0.network \
    ${sysconfdir}/systemd/timesyncd.conf.d/local.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/00-enp2s0.network ${D}${sysconfdir}/systemd/network
    
    install -d ${D}${sysconfdir}/systemd/timesyncd.conf.d/
    install -m 0644 ${WORKDIR}/timesyncd.local.conf ${D}${sysconfdir}/systemd/timesyncd.conf.d/local.conf
}
