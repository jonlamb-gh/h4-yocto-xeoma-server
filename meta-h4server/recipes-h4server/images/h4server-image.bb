SUMMARY = "Odroid H4 Ultra xeoma server image"

LICENSE = "MIT"

inherit core-image extrausers

WKS_SEARCH_PATH:append = ":${THISDIR}/../wic"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

IMAGE_INSTALL += " libstdc++"
IMAGE_INSTALL += " openssl libcrypto libssl"
IMAGE_INSTALL += " openssh openssh-sftp-server ssh-user"
IMAGE_INSTALL += " usbutils mtd-utils udev hidapi"
IMAGE_INSTALL += " tzdata"
IMAGE_INSTALL += " ffmpeg x264"
IMAGE_INSTALL += " vim"
IMAGE_INSTALL += " kernel-modules"
IMAGE_INSTALL += " procps iptables"
IMAGE_INSTALL += " netcat iproute2 net-tools iputils-ping htop"
IMAGE_INSTALL += " parted e2fsprogs"
IMAGE_INSTALL += " xeoma"

COMPATIBLE_MACHINE = "odroid-h4"

set_pw () {
    default_root_password='$1$SgPqZNvM$23DXzPo4IdgslMVGj35SY0'
    sed -i "s/^root:\*:/root:$default_root_password:/" ${IMAGE_ROOTFS}/etc/shadow
}
ROOTFS_POSTPROCESS_COMMAND:append = "set_pw; "

# xeoma binary is linked to /lib64/ld-linux-x86-64.so.2
# but we only have /lib/ld-linux-x86-64.so.2
setup_xeoma_ld_symlink () {
    install -m 0755 -d ${IMAGE_ROOTFS}/lib64
    ln --symbolic --relative ${IMAGE_ROOTFS}/lib/ld-linux-x86-64.so.2 ${IMAGE_ROOTFS}/lib64/ld-linux-x86-64.so.2
}
ROOTFS_POSTPROCESS_COMMAND:append = "setup_xeoma_ld_symlink; "
