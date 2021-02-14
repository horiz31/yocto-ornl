#!/bin/bash
# usage:
#   swu-manifest.sh [-k] filename(.swu)
#
# Produce a report of all the files in the swu archive

KEEP=false
while (($#)) ; do
	if [ "$1" == "-k" -o "$1" == "--keep" ] ; then KEEP=true ;
	else FILE=$1 ;
	fi
	shift
done
if [ -z "${FILE}" ] ; then cat <<- EOF
	Usage:
	    swu-manifest.sh [-k] filename(.swu)
	EOF
	exit 1
fi

set -e
SCRATCH=/tmp/swu-manifest.$$
mkdir -p ${SCRATCH}
( cd ${SCRATCH} && cpio -i < ${FILE} )
tar tvzf ${SCRATCH}/*.tar.gz
if ! ${KEEP} ; then rm -rf ${SCRATCH} ; fi
