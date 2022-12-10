package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileActions {
	GUI gui;
	String filename, fileAddress;

	public FileActions(GUI gui) {
		this.gui = gui;
	}

	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("MiniJPad - [new file]");
		filename = null;
		fileAddress = null;
	}

	public void openFile() {
		FileDialog fd = new FileDialog(gui.window, "Open a file", FileDialog.LOAD);
		fd.setVisible(true);

		if (fd.getFile() != null) {
			filename = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle("MiniJPad - " + "[" + fileAddress + filename + "]");
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + filename));
			gui.textArea.setText("");
			String line;
			while ((line = br.readLine()) != null) {
				gui.textArea.append(line + "\n");
			}
			br.close();

		} catch (Exception e) {
			System.out.println("[ERROR] The following error occured:" + e);
		}
	}

	public void save() {
		if (filename == null) {
			saveAs();
		} else {

			try {

				FileWriter fw = new FileWriter(fileAddress + filename);
				fw.write(gui.textArea.getText());
				fw.close();

			} catch (Exception e) {
				System.out.println("[ERROR] The following error occured:" + e);
			}
		}
	}

	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
		fd.setVisible(true);

		if (fd.getFile() != null) {
			filename = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle("MiniJPad - " + "[" + fileAddress + filename + "]");
		}
		try {
			FileWriter fw = new FileWriter(fileAddress + filename);
			fw.write(gui.textArea.getText());
			fw.close();

		} catch (Exception e) {
			System.out.println("[ERROR] The following error occured:" + e);
		}
	}

	public void exit() {
		System.out.println("[INFO] Exiting the editor");
		System.exit(0);
	}
}
