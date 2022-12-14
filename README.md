# MiniJPad

## A Text Editor Written in Java using the built-in Swing library

Free and open source Windows notepad upgrade featuring nice options for programming/scripting.

<div style="display:flex;">
<img src="screenshots/dark.png" width="400" alt="MiniJPad with gruvbox dark">
<img src="screenshots/light.png" width="400" alt="MiniJPad with gruvbox light">
</div>

This project is still in its early stages, every feature might not be implemented yet.

## Requirements

- Java 19 or above (on windows a popup will send you to download link)
- wget (for Linux cli installation)

## Installation

### Windows

Releases > MiniJPad.exe (install openjdk 19 if asked)

### Linux

Install openjdk 19 from your package manager or from the website and set it as default
then copy the following commands:

```bash
wget https://github.com/ken-soares/MiniJPad/releases/download/test/MiniJPad-0.0.1.tar.gz
tar -xf MiniJPad-0.0.1.tar.gz
cd MiniJPad/
chmod +x install.sh
sudo ./install.sh
```

## Development Goals for 1.0

- [x] basic gruvbox color themes
- [x] display line number
- [x] convert tabs to spaces button
- [x] support for spawning a compile/run process
- [ ] support for undo/redo
- [ ] support for keybindings
- [ ] custom configuration file
- [ ] ~~python syntax highlighting~~ (out of scope for the time being)
