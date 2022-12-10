#!/usr/bin/sh

ver=0.0.1
mkdir -p releases/MiniJPad-$ver
cp -r MiniJPad/ releases/MiniJPad-$ver
cp MiniJPad.desktop releases/MiniJPad-$ver
cp install.sh releases/MiniJPad-$ver
cp LICENCE releases/MiniJPad-$ver
cp README.md releases/MiniJPad-$ver
tar -czvf releases/MiniJPad-$ver.tar.gz releases/MiniJPad-$ver
rm -rf releases/MiniJPad-$ver
