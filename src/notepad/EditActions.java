package notepad;

public class EditActions {
	GUI gui;
	OptionsActions options;

	public EditActions(GUI gui, OptionsActions options) {
		this.gui = gui;
		this.options = options;
	}
	public void spacesTabs() {
		String text = gui.textArea.getText();
		String spaces = "";
		for(int i = 0; i < options.tabSize; i++) {
			spaces += " ";
		}
		gui.textArea.setText(text.replace("\t", spaces));
	}
}
