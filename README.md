
https://docs.yoctoproject.org/4.0/brief-yoctoprojectqs/index.html

WIC related (kirkstone):
https://docs.yoctoproject.org/4.0.17/dev-manual/wic.html

https://www.thegoodpenguin.co.uk/blog/self-installing-yocto-image-from-a-usb-drive/
https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097
https://github.com/lgirdk/meta-intel/blob/master/documentation/building_and_booting.md
https://stackoverflow.com/questions/76688026/yocto-build-not-recognizing-disks-when-live-booted-on-intel-based-server
https://stackoverflow.com/questions/73838536/yoctohow-to-use-meta-intel-to-generate-iso-images-that-can-be-started-in-vmware

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

NOTE:
until I get the live image working, I'm just dd to drive from the live image
disabling swap partition (use swap file)
and resizing the rootfs partition


TODO 
watchdog?

```
if USB is corrupt:
    dd if=/dev/zero of=/dev/sdX bs=1M count=512


minicom -c on -D /dev/ttyUSB0 -w
```
