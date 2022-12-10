package notepad;

import java.awt.Color;

public class ThemeActions {
	
	// TODO: read from config.json
	// TODO: add gruvbox light
	GUI gui;
	String dark = "#282828";
	String darker = "#1D2021";
	String semiLight = "#EBDDB2";

	public ThemeActions(GUI gui) {
		this.gui = gui;
	}
	
	public void setDark() {
		gui.textArea.setBackground(Color.decode(dark));
		gui.textArea.setForeground(Color.decode(semiLight));
		gui.menuBar.setBackground(Color.decode(darker));

		gui.menuFile.setForeground(Color.decode(semiLight));
		gui.menuOptions.setForeground(Color.decode(semiLight));
		gui.menuEdit.setForeground(Color.decode(semiLight));
		gui.menuTheme.setForeground(Color.decode(semiLight));
		
	}
	
	public void setLight() {
		gui.window.getContentPane().setBackground(Color.decode("#FFFFFF"));
		gui.textArea.setBackground(Color.decode("#FFFFFF"));
		gui.textArea.setForeground(Color.decode("#000000"));

	}
}
