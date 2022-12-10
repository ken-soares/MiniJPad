#!/usr/bin/sh

version=0.0.1
JAVA_VER=$(java -version 2>&1 | sed -n ';s/.* version "\(.*\)\.\(.*\)\..*".*/\1\2/p;')


function install {
    chmod +x MiniJPad/run.sh
    cp -r MiniJPad/ /opt/
    cp MiniJPad.desktop /usr/share/applications/MiniJPad.desktop
    clear
    echo "MiniJPad ver. $version installed successfully"
}

if [[ $(id -u) -eq 0 ]]; then
    if [[ "$JAVA_VER" -ge 190 ]]; then
        echo "[INFO] Java version is recent enough"
        install
    else
        echo "[WARNING] Please install Java 19 or above"
        exit 1
    fi
else
    echo "[INFO] Please run script as root"
fi
