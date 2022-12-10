#!/usr/bin/sh

function install {
    rm -rf /opt/MiniJPad
    rm /usr/share/applications/MiniJPad.desktop
    clear
    echo "MiniJPad uninstalled successfully"
}

if [[ $(id -u) -eq 0 ]]; then
    install
else
    echo "[INFO] Please run script as root"
fi
