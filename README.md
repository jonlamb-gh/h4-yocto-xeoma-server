
https://docs.yoctoproject.org/4.0/brief-yoctoprojectqs/index.html

WIC related (kirkstone):
https://docs.yoctoproject.org/4.0.17/dev-manual/wic.html

https://www.thegoodpenguin.co.uk/blog/self-installing-yocto-image-from-a-usb-drive/

once done, dd the wic file to usb stick

examples:
* https://magazine.odroid.com/article/yocto-on-the-odroid-c2-using-yocto-with-kernel-5-0/

yocto version: kirkstone
probably switch to scarthgap when
https://github.com/akuster/meta-odroid
has support for it

see h3 support for diff:
https://github.com/akuster/meta-odroid/pull/93/files

hw:
https://www.hardkernel.com/shop/odroid-h4-ultra/
https://www.hardkernel.com/shop/samsung-16gb-ddr5-5600-so-dimm/
TODO


trying qemu:
doesn't work yet
```
qemu-system-x86_64 -smp 4 -m 2G -initrd core-image-minimal-initramfs-odroid-h4.cpio.gz -drive file=core-image-full-cmdline-odroid-h4-20240425151742.rootfs.wic,if=none,id=disk,format=raw -kernel ./bzImage
```
