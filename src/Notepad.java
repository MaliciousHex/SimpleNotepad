import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener{
	
//	Declare
	JComponent nComponent;
	JPanel wrapPanel;
	JTextArea noteText;
	JMenuBar navBar;
	JMenu fileMenu,aboutMenu;
	JMenuItem aboutItem,clearItem,saveItem;
	
	public void initComponents() {
		wrapPanel = new JPanel();
		noteText = new JTextArea();
		navBar = new JMenuBar();
		fileMenu = new JMenu("File");
		aboutMenu = new JMenu("About");
		aboutItem = new JMenuItem("About Me");
		clearItem = new JMenuItem("Clear content");
		saveItem = new JMenuItem("Save as note.txt");
		noteText = new JTextArea();
	}
	
	public void setComponents() {
		
		wrapPanel.setLayout(new BorderLayout());
		wrapPanel.add(navBar,BorderLayout.NORTH);
		wrapPanel.add(new JScrollPane(noteText),BorderLayout.CENTER);
		
		navBar.add(fileMenu);
		navBar.add(aboutMenu);
		
		fileMenu.add(clearItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		aboutMenu.add(aboutItem);
		
//		Listener
		clearItem.addActionListener(this);
		saveItem.addActionListener(this);
		aboutItem.addActionListener(this);
	}
	
	public void viewComponents() {
		
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("Simple Notepad");
		add(wrapPanel);
		setVisible(true);
	}
	
	public Notepad() {
		// TODO Auto-generated constructor stub
		initComponents();
		setComponents();
		viewComponents();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notepad n = new Notepad();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == clearItem) {
			noteText.setText(null);
		}else if(arg0.getSource()==saveItem) {
			saveIt();
		}else if(arg0.getSource() == aboutItem) {
			JOptionPane.showMessageDialog(null,"1901507654 - Harry Ermawan - LA01","About",JOptionPane.PLAIN_MESSAGE);
			
		}
	}

	private void saveIt() {
		// TODO Auto-generated method stub
		final JFileChooser SaveNote = new JFileChooser();
		SaveNote.setApproveButtonText("Save");
		int actionDialog = SaveNote.showOpenDialog(this);
		if(actionDialog != JFileChooser.APPROVE_OPTION) {
			return;
		}
		
		File fileName = new File(SaveNote.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));

			noteText.write(outFile);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (outFile != null) {
				try {
					outFile.close();
				} catch (IOException e) {

				}
			}
		}
	}

}
