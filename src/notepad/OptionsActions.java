package notepad;

import java.awt.Font;

import javax.swing.JOptionPane;

public class OptionsActions {

	GUI gui;
	Font font;

	public OptionsActions(GUI gui) {
		this.gui = gui;
	}
	
	public void lineWrap() {
			gui.isWrap = !gui.isWrap;
			gui.textArea.setLineWrap(gui.isWrap);
			gui.textArea.setWrapStyleWord(gui.isWrap);
			gui.IWrap.setText("Line wrap: " + gui.isWrap);
	}

	public void font() {

		int fontSize;
		String fontName;

		try {

			fontName = JOptionPane.showInputDialog(gui.window, "Enter font name:", null).trim();
			fontSize = Integer.parseInt(JOptionPane.showInputDialog(gui.window, "Enter font size:", null));

		} catch (Exception e) {
			fontName = "Arial";
			fontSize = 14;
			System.out.println("[ERROR] The following error occured:" + e);
		}

		System.out.println(fontName);
		font = new Font(fontName, Font.PLAIN, fontSize);

		// TODO: save font in config file
		gui.textArea.setFont(font);
	}

	public void setDefaultFont() {
		// TODO: load fonts from config file
		int fontSize = 14;
		String fontName = "Arial";
		font = new Font(fontName, Font.PLAIN, fontSize);
		gui.textArea.setFont(font);
	}
	
	public void setTabSize(int tabSize) {
		gui.textArea.setTabSize(tabSize);
	}
}
