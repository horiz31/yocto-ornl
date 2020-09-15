# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "This is the base image for the Ground Robotics image"

IMAGE_FEATURES += "package-management ssh-server-openssh "

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL_append += " \
    ornl-packagegroup-prod \
	packagegroup-imx-tools-audio \
	packagegroup-fsl-gstreamer1.0-full \
	packagegroup-fsl-gstreamer1.0 \
	git \
	libsodium \
	libsodium-dev \
    python3-pyyaml \
    python3-netifaces \
    libxml2-dev \
    libxslt-dev \
    webcam-tools \
"