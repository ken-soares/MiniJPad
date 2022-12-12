package notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class EditActions {
	GUI gui;
	OptionsActions options;
	ProcessBuilder processBuilder;
	String SavedCommand;
	OutputArea commandOutput;

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
	
	public void execute() {
		String file = gui.file.fileAddress + gui.file.filename;
		String command;
		if(SavedCommand != null) {
			int answer = JOptionPane.showConfirmDialog(gui.window, "Rerun previous command?");

			if(answer == JOptionPane.YES_OPTION) {
				command = SavedCommand;

			}else if(answer == JOptionPane.CANCEL_OPTION){
				command = null;

			}else {
				command = JOptionPane.showInputDialog(gui.window, "execute command:", null);
				
			}

		}else {
				command = JOptionPane.showInputDialog(gui.window, "execute command:", null);
		}
		if(command == null) {
			return;
		}
		command = command.replace("%", file);
		SavedCommand = command;
		String[] commandList = command.split(" ");
		processBuilder = new ProcessBuilder(commandList);

		try {

			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line; 
			while((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			commandOutput = new OutputArea();
			commandOutput.outputArea.setText(command + "\n" + output.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		// TODO: create a window with JTextArea containing output
	}
}
