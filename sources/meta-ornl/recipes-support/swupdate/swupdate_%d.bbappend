FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://swupdate.cfg \
	file://swupdate.default \
	file://favicon.png \
	file://logo.png \
"

do_install_append () {
	install -m 644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/default/
	install -m 644 ${WORKDIR}/swupdate.default ${D}${sysconfdir}/default/swupdate
	install -d ${D}/www/images
	install -m 644 ${WORKDIR}/favicon.png ${D}/www/images/
	install -m 644 ${WORKDIR}/logo.png ${D}/www/images/
}
