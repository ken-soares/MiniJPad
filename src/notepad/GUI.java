package notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class GUI implements ActionListener {

	// Editor UI
	JFrame window;
	JTextArea textArea;
	JTextArea lines;
	JScrollPane scrollPane;
	JMenuBar menuBar;

	// TODO: read value from config file
	boolean isWrap = false;
	boolean isExpandTab = false;

	// general menu buttons
	JMenu menuFile, menuEdit, menuOptions, menuTheme;

	// file menu buttons
	JMenuItem IOpen, INew, ISave, ISaveAs, IExit;

	
	//edit menu buttons
	JMenuItem ISpacesTabs;
	JMenuItem ISpawn;

	// options menu buttons
	JMenuItem IWrap;
	JMenuItem IFont;
	JMenu menuTabStop;
	JMenuItem ITab2, ITab4, ITab8;
	// theme menu button
	JMenuItem IDark;
	JMenuItem ILight;
	

	// Buttons functions
	FileActions file = new FileActions(this);
	OptionsActions options = new OptionsActions(this);
	EditActions edit = new EditActions(this, options);
	ThemeActions theme = new ThemeActions(this);

	public static void main(String[] args) {
		new GUI();
		System.out.println("[INFO] Editor up and running!");
	}

	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createOptionsMenu();
		createThemeMenu();
		window.setVisible(true);
		options.setTabSize(options.tabSize);
	}

	public void createWindow() {
		// font anti-aliasing for accurate font rendering
		System.setProperty("awt.useSystemAAFontSettings", "on");
		window = new JFrame("MiniJPad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createTextArea() {
		textArea = new JTextArea();

		lines = new JTextArea("1");
		lines.setEditable(false);

		textArea.getDocument().addDocumentListener(new DocumentListener() {

			public String getText() {

				int caretPosition = textArea.getDocument().getLength();
				Element root = textArea.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");

				for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
					 text += i + System.getProperty("line.separator");
				}
				return text;
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				lines.setText(getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				lines.setText(getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				lines.setText(getText());
			}
		});

		options.setDefaultFont();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPane.setRowHeaderView(lines);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		window.setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);

		menuTheme = new JMenu("Theme");
		menuBar.add(menuTheme);
	}

	public void createFileMenu() {

		INew = new JMenuItem("New");
		INew.addActionListener(this);
		INew.setActionCommand("New");
		menuFile.add(INew);

		IOpen = new JMenuItem("Open");
		IOpen.addActionListener(this);
		IOpen.setActionCommand("Open");
		menuFile.add(IOpen);

		ISave = new JMenuItem("Save");
		ISave.addActionListener(this);
		ISave.setActionCommand("Save");
		menuFile.add(ISave);

		ISaveAs = new JMenuItem("Save As");
		ISaveAs.addActionListener(this);
		ISaveAs.setActionCommand("SaveAs");
		menuFile.add(ISaveAs);

		IExit = new JMenuItem("Exit");
		IExit.addActionListener(this);
		IExit.setActionCommand("Exit");
		menuFile.add(IExit);

	}
	
	public void createEditMenu() {

		ISpacesTabs = new JMenuItem("tabs → spaces");
		ISpacesTabs.addActionListener(this);
		ISpacesTabs.setActionCommand("SpacesTabs");
		menuEdit.add(ISpacesTabs);
		
		ISpawn = new JMenuItem("execute");
		ISpawn.addActionListener(this);
		ISpawn.setActionCommand("execute");
		menuEdit.add(ISpawn);
	}

	public void createOptionsMenu() {
		menuOptions.setBorderPainted(false);
		IWrap = new JMenuItem("Line Wrap: false");
		IWrap.addActionListener(this);
		IWrap.setActionCommand("Wrap");
		menuOptions.add(IWrap);

		IFont = new JMenuItem("Font");
		IFont.addActionListener(this);
		IFont.setActionCommand("Font");
		menuOptions.add(IFont);
		
		
		menuTabStop = new JMenu("Tab Size");
		menuOptions.add(menuTabStop);

		ITab2 = new JMenuItem("2");
		ITab2.addActionListener(this);
		ITab2.setActionCommand("tab2");
		menuTabStop.add(ITab2);

		ITab4 = new JMenuItem("4");
		ITab4.addActionListener(this);
		ITab4.setActionCommand("tab4");
		menuTabStop.add(ITab4);

		ITab8 = new JMenuItem("8");
		ITab8.addActionListener(this);
		ITab8.setActionCommand("tab8");
		menuTabStop.add(ITab8);

	}
	
	public void createThemeMenu() {
		IDark = new JMenuItem("Dark");
		IDark.addActionListener(this);
		IDark.setActionCommand("Dark");
		menuTheme.add(IDark);

		ILight = new JMenuItem("Light");
		ILight.addActionListener(this);
		ILight.setActionCommand("Light");
		menuTheme.add(ILight);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();

		switch (command) {
		case "New":
			file.newFile();
			break;
		case "Open":
			file.openFile();
			break;
		case "Save":
			file.save();
			break;
		case "SaveAs":
			file.saveAs();
			break;
		case "Exit":
			file.exit();
			break;
		case "Font":
			options.font();
			break;
		case "Wrap":
			options.lineWrap();
			break;
		case "tab8":
			options.setTabSize(8);
			break;
		case "tab4":
			options.setTabSize(4);
			break;	
		case "tab2":
			options.setTabSize(2);
			break;
		case "SpacesTabs":
			edit.spacesTabs();
			break;
		case "execute":
			edit.execute();
			break;
		case "Dark":
			theme.setDark();
			break;
		case "Light":
			theme.setLight();
			break;
		}
	}

}