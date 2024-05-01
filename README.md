
https://docs.yoctoproject.org/4.0/brief-yoctoprojectqs/index.html

WIC related (kirkstone):
https://docs.yoctoproject.org/4.0.17/dev-manual/wic.html

https://www.thegoodpenguin.co.uk/blog/self-installing-yocto-image-from-a-usb-drive/
https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097

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


TODO 
watchdog?

```
minicom -c on -D /dev/ttyUSB0 -w
```
