# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image distro_features_check

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

IMAGE_FEATURES += " \
    splash \
    package-management \
    ssh-server-dropbear \
    hwcodecs \
    debug-tweaks \
    nfs-server \
    tools-debug \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

CORE_IMAGE_EXTRA_INSTALL += " \
	packagegroup-core-full-cmdline \
	packagegroup-tools-bluetooth \
	packagegroup-imx-tools-audio \
	packagegroup-fsl-tools-gpu \
	packagegroup-fsl-tools-gpu-external \
	packagegroup-fsl-tools-testapps \
	packagegroup-fsl-tools-benchmark \
	packagegroup-fsl-gstreamer1.0 \
	packagegroup-fsl-gstreamer1.0-full \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
        ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
        ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xterm', '', d)} \
        ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-core-x11-sato-games', '', d)} \
	nodejs \
	flex \
	gcc \
	git \
	m4 \
	make \
	iperf3 \
	libtool \
	libsodium \
	libsodium-dev \
	python-compiler \
	python3 \
	python3-lxml \
	python3-pip \
	python3-protobuf \
	python3-requests \
	python3-pexpect \
	python3-pyserial \
	python3-pytz \
	python3-urllib3 \
	strace \
	screen \
	minicom \
	openssl \
	imx-test \
	networkmanager \
	v4l-utils \
"

mount_readonly () {
    cat >> ${IMAGE_ROOTFS}/etc/fstab.modif <<EOF

# ORNL's custom partitioning layout

/dev/root            /                    auto       defaults              1  1
tmpfs                /var/local        	  tmpfs      defaults              0  0
tmpfs		         /var/log		      tmpfs      defaults              0  0

# uncomment this if your device has a SD/MMC/Transflash slot
#/dev/mmcblk0p1      /media/card          auto       defaults,sync,noauto  0  0

EOF

	mv ${IMAGE_ROOTFS}/etc/fstab.modif ${IMAGE_ROOTFS}/etc/fstab
} 

ROOTFS_POSTPROCESS_COMMAND += "mount_readonly; "
