package address.GUI;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
/**
 *	The NoteGUI class provides the user to enter notes for an address entry and also displays notes when searched. 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 **/
public class NoteGUI extends JPanel{
/**
 * Declaring Panel	
 */
	JPanel myPanel = new JPanel();
	/**
	 * Text Area to write notes for an address entry or display note to user when searched
	 */
	JTextArea display=new JTextArea(16,40);
	/**
	 * declaring scroll pane
	 */
	JScrollPane scroll=new JScrollPane(display);
	/**
	 * Declaring the JFrame
	 */
	JFrame frame = new JFrame ();
	/**
	 * Constructor to initialize all the GUI components and add them to the frame
	 */
	NoteGUI(){	
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );	
		myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
		//myPanel.add(new JLabel("PLEASE ENTER YOUR NOTES:"));
		myPanel.add(scroll);
		frame.add(myPanel);
	}
	/**
	 * This method provides the user the interface to enter comments for a particular address entry
	 * @return	comments entered by the user
	 */
	public String enterNote(){
		display.setText("");
		display.setEditable(true);
		int n=JOptionPane.showConfirmDialog(null, myPanel,"ENTER NOTES", JOptionPane.OK_CANCEL_OPTION);
		//System.out.print(display.getText());
		if (n == JOptionPane.OK_OPTION)
		return display.getText();
		else
		return "";	
	}
	/**
	 * Displays the comments obtained from the database along with the person's name
	 * @param comment	Comment obtained from the database
	 */
	public void displayNotes(String comment){
		display.setText(comment);
		display.setEditable(false);
		JOptionPane.showConfirmDialog(null, myPanel,"VIEW NOTES", JOptionPane.OK_CANCEL_OPTION);
	}
}
