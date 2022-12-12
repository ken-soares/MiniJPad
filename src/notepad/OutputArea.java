package notepad;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class OutputArea extends JFrame{
	JTextArea outputArea;
	Font font = new Font("Arial", Font.PLAIN, 22);
	public OutputArea() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Command Output");
		this.setVisible(true);
		this.setSize(400,600);
		createOutputArea();
	}
	
	public void createOutputArea() {
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		outputArea.setVisible(true);
		outputArea.setFont(font);
		this.add(outputArea);
	}
}
