#!/usr/bin/sh

ver=0.0.1
mkdir -p releases/MiniJPad-$ver
cp -r MiniJPad/ releases/MiniJPad-$ver
cp MiniJPad.desktop releases/MiniJPad-$ver
cp install.sh releases/MiniJPad-$ver
cp uninstall.sh releases/MiniJPad-$ver
cp LICENSE releases/MiniJPad-$ver
cp README.md releases/MiniJPad-$ver
cd releases/
tar -czvf MiniJPad-$ver.tar.gz MiniJPad-$ver/
rm -rf MiniJPad-$ver
