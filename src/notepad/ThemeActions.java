package notepad;

import java.awt.Color;

public class ThemeActions {
	
	// TODO: read from config.json
	GUI gui;
	String dark = "#282828";
	String darker = "#1D2021";
	String light = "#EBDDB2";
	String lighter = "#FBF1C7";

	public ThemeActions(GUI gui) {
		this.gui = gui;
	}
	
	public void setDark() {
		gui.textArea.setBackground(Color.decode(dark));
		gui.textArea.setForeground(Color.decode(light));
		gui.menuBar.setBackground(Color.decode(darker));
		gui.lines.setBackground(Color.decode(darker));
		gui.lines.setForeground(Color.decode(light));

		gui.menuFile.setForeground(Color.decode(light));
		gui.menuOptions.setForeground(Color.decode(light));
		gui.menuEdit.setForeground(Color.decode(light));
		gui.menuTheme.setForeground(Color.decode(light));
		
	}
	
	public void setLight() {
		gui.textArea.setBackground(Color.decode(lighter));
		gui.textArea.setForeground(Color.decode(dark));
		gui.menuBar.setBackground(Color.decode(light));
		gui.lines.setBackground(Color.decode(light));
		gui.lines.setForeground(Color.decode(dark));
		
		gui.menuFile.setForeground(Color.decode(dark));
		gui.menuOptions.setForeground(Color.decode(dark));
		gui.menuEdit.setForeground(Color.decode(dark));
		gui.menuTheme.setForeground(Color.decode(dark));
	}
}
