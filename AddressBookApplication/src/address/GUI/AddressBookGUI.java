package address.GUI;
import java.awt.EventQueue;

import address.data.AddressEntry;
import address.data.note.NoteAction;
import address.data.*;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
/**
 * 	The AddressBookGUI provides the GUI interface to the user and it performs all the action events by using listeners.
  *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 **/
public class AddressBookGUI {
	/**
	 * Declaring the JFrame and setting all the dimensions
	 */
	private JFrame frmAddressBookApplication = new JFrame();
	/**
	 * To store value inputed to JList	
	 */
	DefaultListModel<String> listModel = new DefaultListModel<>();
	/**
	 * Declaring scrollPane to scroll down through the list of Addresses	
	 */
	JScrollPane scrollPane = new JScrollPane();
	/**
	 * Declaring the JList	
	 */
	JList<String> list = new JList<>(listModel);
	/**
	 * Declaring the Remove button 			
	 */
	JButton btnRemove = new JButton("REMOVE");
	/**
	 * declaring the search button and setting all the attributes
	 */
	JButton btnSearch_1 = new JButton("SEARCH ");
	/**
	 * Declaring the View Notes button and setting all the attributes
	 */
	JButton btnViewNotes = new JButton("VIEW NOTES");
	/**
	 * Declaring the Add button to add note objects and setting all the attributes.
	 */
	JButton btnAdd = new JButton("ADD");
	/**
	 * Creating an instance of Address book
	 */
	AddressBook ab=new AddressBook();
	/**
	 * Creating an instance of NoteAction class
	 */
	NoteAction na=new NoteAction(ab);
	/**
	 * Creating an instance of NoteGUI class
	 */
	NoteGUI Obj=new NoteGUI();
	/**
	 * The main method launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookGUI window = new AddressBookGUI();
					window.frmAddressBookApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor to initialize the contents of the frame.
	 */
	public AddressBookGUI() {
		initialize();		
	}

	/**
	 * Initializes the contents of the frame and also handles action events.
	 */
	private void initialize() {


		frmAddressBookApplication.setMinimumSize(new Dimension(1000, 500));
		frmAddressBookApplication.setTitle("Address Book Application Version 2.0");
		frmAddressBookApplication.setBackground(new Color(255, 255, 240));
		frmAddressBookApplication.getContentPane().setBackground(new Color(102, 102, 102));
		frmAddressBookApplication.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frmAddressBookApplication.setBounds(100, 100, 1000, 559);
		frmAddressBookApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddressBookApplication.getContentPane().setLayout(null);

		scrollPane.setBounds(350, 11, 605, 498);
		frmAddressBookApplication.getContentPane().add(scrollPane);

		
		btnRemove.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnRemove.setBackground(new Color(253, 245, 230));
		btnRemove.setBounds(174, 131, 113, 56);
		frmAddressBookApplication.getContentPane().add(btnRemove);
		/**
		 * ActionListener for Remove button. It removes the list of selected address entries.
		 */
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * It stores the list of items selected in the list
				 */
				DefaultListModel remove = (DefaultListModel) list.getModel();
				if(list.getSelectedIndices().length > 0) {
					/**
					 * Variable to get the index of the item selected
					 */
					int[] selectedIndices = list.getSelectedIndices();
					/**
					 * iterating through the list and removing the selected address entries.
					 */
					for (int i = selectedIndices.length-1; i >=0; i--) {
						ab.remove(remove.get(selectedIndices[i]).toString());
						remove.removeElementAt(selectedIndices[i]);				              
					} 
				}	
				
			}
		});

		/**
		 * 		Declaring the Display button and setting all the attributes
		 */
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(253, 245, 230));
		btnNewButton.setBounds(174, 64, 113, 56);
		frmAddressBookApplication.getContentPane().add(btnNewButton);
		/**
		 * ActionListener for Display button. The display button displays the list of address entries on the JList.
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				listModel.clear();
				for(int i=0;i<ab.getList().size();i++){
					listModel.addElement(ab.getList().get(i).toString());	
				}								
			}
		});

		/**
		 * Declaring the New button and setting all the attributes		
		 */
		JButton btnNew = new JButton("NEW");
		btnNew.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNew.setBackground(new Color(253, 245, 230));
		btnNew.setForeground(Color.BLACK);
		btnNew.setBounds(57, 64, 113, 56);
		frmAddressBookApplication.getContentPane().add(btnNew);

		/**
		 * ActionListener for New button. The NEW button prompts the user to enter a new address entry.
		 */
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * It calls the AddressEntryGUI class to display the input fields to the user.	
				 */
				AddressEntryGUI m=new AddressEntryGUI();
				m.display();		
				ab.add(new AddressEntry(m.prompt_FirstName(),m.prompt_LastName(),m.prompt_Street(),m.prompt_City(),
						m.prompt_State(),m.prompt_Zip(),m.prompt_Telephone(),m.prompt_Email()));
			}

		});

		/**
		 * Declaring the Search button and setting all the attributes		
		 */
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(253, 245, 230));
		btnSearch.setBounds(57, 131, 113, 56);
		frmAddressBookApplication.getContentPane().add(btnSearch);

		/**
		 * ActionListener for the Search Button. The Search button finds the list of address entries starting from a given last name.
		 */		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				ab.clearFindList();
				/**
				 * Variable to store the user input of Last Name.				
				 */
				String find=JOptionPane.showInputDialog("Enter in all or begining of the Last Name of the contact you wish to find");	
				ab.find(find);
				if(ab.f.size()>0){
					for(int i=0;i<ab.f.size();i++){
						listModel.addElement(ab.f.get(i).toString());	
					}}
				else
					JOptionPane.showMessageDialog(null,"No AddressEntries were found starting with the givenlast name");
			}
		});

		/**
		 * Declaring the Exit button and setting all the attributes		
		 */
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnExit.setBackground(new Color(253, 245, 230));
		btnExit.setBounds(230, 426, 89, 46);
		frmAddressBookApplication.getContentPane().add(btnExit);

		/**
		 * ActionListenser for Exit button. The Exit button exits the whole program.
		 */
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/**
		 * Declaring the Save button and setting all the attributes
		 */
		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(253, 245, 230));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSave.setBounds(131, 426, 89, 46);
		frmAddressBookApplication.getContentPane().add(btnSave);

		/**
		 * ActionListener for the Save button. The save button stores the current list of address entries to the database.
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ab.insert();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Declaring the Load button and setting all the attributes
		 */
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnLoad.setBackground(new Color(253, 245, 230));
		btnLoad.setBounds(32, 426, 89, 46);
		frmAddressBookApplication.getContentPane().add(btnLoad);

		/**
		 * ActionListener for the Load Button. The Load button retrieves the address entries from the data base.
		 */

		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ab.Load();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		/**
		 * declaring a JLabel to display some instruction to the user
		 */
		JLabel lblpleasePress = new JLabel("Please press the SAVE button after any operation ");
		lblpleasePress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblpleasePress.setForeground(new Color(250, 240, 230));
		lblpleasePress.setBounds(22, 495, 316, 14);
		frmAddressBookApplication.getContentPane().add(lblpleasePress);
		/**
		 * declaring a JLabel to provide guidance to the user
		 */				
		JLabel lblAddressEntryOperations = new JLabel("ADDRESS ENTRY OPERATIONS");
		lblAddressEntryOperations.setForeground(new Color(250, 240, 230));
		lblAddressEntryOperations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddressEntryOperations.setBounds(24, 26, 316, 14);
		frmAddressBookApplication.getContentPane().add(lblAddressEntryOperations);
		/**
		 * declaring a JLabel to provide guidance to the user
		 */				
		JLabel lblOperationOnNotes = new JLabel("OPERATION ON NOTES");
		lblOperationOnNotes.setForeground(new Color(250, 240, 230));
		lblOperationOnNotes.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblOperationOnNotes.setBounds(22, 223, 316, 14);
		frmAddressBookApplication.getContentPane().add(lblOperationOnNotes);

		btnAdd.setVisible(false);
		btnAdd.setBackground(new Color(253, 245, 230));
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAdd.setBounds(57, 260, 113, 46);
		frmAddressBookApplication.getContentPane().add(btnAdd);
		/**
		 * Action Listener for the Add button. The add button adds a note object to the database.
		 */
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * To get the list of Address entry selected in the JList
				 */
				DefaultListModel add = (DefaultListModel) list.getModel();
				if(list.getSelectedIndices().length > 0) {
					/**
					 * Array to store the indices of the selectes address entries on the JList
					 */
					int[] selectedIndices = list.getSelectedIndices();
					for (int i = selectedIndices.length-1; i >=0; i--) {
						try {
							na.storeNoteToDB(add.get(selectedIndices[i]).toString(), Obj.enterNote());
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//			          } 
					}}	

				btnRemove.setVisible(false);

			}
		});


		btnViewNotes.setVisible(false);
		btnViewNotes.setBackground(new Color(253, 245, 230));
		btnViewNotes.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnViewNotes.setBounds(176, 260, 111, 46);
		frmAddressBookApplication.getContentPane().add(btnViewNotes);
		/**
		 * Action Listener for the ViweNotes Button. The View note button enables the user to view the comments for a particular address entry.
		 * 
		 */
		btnViewNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * To store the list of address entries selected in the JList.
				 */
				DefaultListModel view = (DefaultListModel) list.getModel();
				if(list.getSelectedIndices().length > 0) {
					/**
					 * Store the indices of the Address entry selected in the JList
					 */
					int[] selectedIndices = list.getSelectedIndices();				          
					/**
					 * Variable to store the comments retrieved from database.
					 */
					String notes="ALL THE NOTES OF THIS ADDRESS ARE SEPARATED BY LINES"+'\n';
					try {
						NoteAction.getNotes(ab.getAddressId(view.get(selectedIndices[0]).toString()));

						for(int i=0;i<NoteAction.getNote().size();i++){
							notes=notes+"___________________________________________________________"+'\n';
							notes=notes+NoteAction.getNote().get(i).getComments()+'\n';
						}
						/**
						 * Displaying the comments of a address entry
						 */
						Obj.displayNotes(notes);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});


		btnSearch_1.setBackground(new Color(253, 245, 230));
		btnSearch_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSearch_1.setBounds(174, 317, 113, 46);
		frmAddressBookApplication.getContentPane().add(btnSearch_1);
		/**
		 * Action Listener for the search button. The search button displays all the notes having a particular phrase. 		
		 */
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Getting the input phrase from the user
				 */
				String input=JOptionPane.showInputDialog("Please enter the phrase you want to search");
				/**
				 * Variable to store the notes retrieved from the database.
				 */
				String notes="";
				try {
					NoteAction.getNotes(input);
					for(int i=0;i<NoteAction.getNote().size();i++){
						notes+="NOTE FOR: "+ab.getName(NoteAction.getNote().get(i).getId())+'\n';
						notes+=NoteAction.getNote().get(i).getComments()+'\n'+'\n'+'\n';
					}
					/**
					 * Displaying the all the notes having that particular phrase.
					 */
					Obj.displayNotes(notes);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		/**
		 * ActionListener if one or more items are selected in the JList	
		 */
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnRemove.setVisible(true);
				btnAdd.setVisible(true);
				btnViewNotes.setVisible(true);
				btnSearch_1.setVisible(true);
			}			
		});
		scrollPane.setViewportView(list);
	}
}
