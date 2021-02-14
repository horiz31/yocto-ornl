EXTRA_OECONF_remove = "--disable-x265 --disable-uvch264"
EXTRA_OECONF += "--enable-x265 --enable-uvch264"

DEPENDS += " x265"

PACKAGECONFIG += " \ 
    rtmp \
    voaacenc \
    uvch264 \
"
