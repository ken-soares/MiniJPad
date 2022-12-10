package notepad;

import java.awt.Color;

public class ThemeActions {
	GUI gui;

	public ThemeActions(GUI gui) {
		this.gui = gui;
	}
	
	public void setDark() {
		gui.window.getContentPane().setBackground(Color.decode("#FF0000"));
		gui.textArea.setBackground(Color.decode("#FF0000"));
		gui.textArea.setForeground(Color.decode("#00FF00"));
	}
	
	public void setLight() {
		gui.window.getContentPane().setBackground(Color.decode("#FFFFFF"));
		gui.textArea.setBackground(Color.decode("#FFFFFF"));
		gui.textArea.setForeground(Color.decode("#000000"));

	}
}
