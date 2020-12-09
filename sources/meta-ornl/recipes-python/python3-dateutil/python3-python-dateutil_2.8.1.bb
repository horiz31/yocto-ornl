DESCRIPTION = "The dateutil module provides powerful extensions to the standard datetime module, available in Python."
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3155c7bdc71f66e02678411d2abf996"

SRC_URI[md5sum] = "f2a1d4b680b297b367a974664ca3a4f6"
SRC_URI[sha256sum] = "73ebfe9dbf22e832286dafa60473e4cd239f8592f699aa5adaf10050e6e1823c"

DEPENDS_${PN} += " python-dateutil-native"

inherit pypi setuptools3