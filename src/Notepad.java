import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener{
	
//	Declare
	JComponent nComponent;
	JPanel wrapPanel,notePanel;
	JTextArea noteText;
	JMenuBar navBar;
	JMenu fileMenu,aboutMenu;
	JMenuItem aboutItem,clearItem,saveItem;
	
	public void initComponents() {
		wrapPanel = new JPanel();
		notePanel = new JPanel();
		noteText = new JTextArea();
		navBar = new JMenuBar();
		fileMenu = new JMenu("File");
		aboutMenu = new JMenu("About");
		aboutItem = new JMenuItem("About Me");
		clearItem = new JMenuItem("Clear content");
		saveItem = new JMenuItem("Save as note.txt");
		noteText = new JTextArea();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
