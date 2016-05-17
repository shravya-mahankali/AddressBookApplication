package address.GUI;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * The AddressEntryGUI class provides the user a graphical interface to enter the address entry attributes.
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016 */
public class AddressEntryGUI extends JPanel{
/**
 * Declaring Panel
 */
JPanel myPanel = new JPanel();
/**
 * Text field to enter First Name
 */
JTextField fn = new JTextField(20);
/**
 *  Text field to enter Last name.
 */
JTextField ln = new JTextField(20);
/**
 *  Text field to enter street
 */
JTextField street = new JTextField(30);
/**
 *  Text field to enter city
 */
JTextField city = new JTextField(15);
/**
 *  Text field to enter state
 */
JTextField state = new JTextField(15);
/**
 *  Text field to enter zip
 */
JTextField zip = new JTextField(5);
/**
 *  Text field to enter phone no.
 */
JTextField phone = new JTextField(10);
/**
 *  Text field to enter email
 */
JTextField email = new JTextField(20);
/**
 * Constructor to initialize all the GUI components and add them to the panel
 */
AddressEntryGUI(){
	myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
	myPanel.add(new JLabel("First Name :"));
	myPanel.add(fn);
	myPanel.add(new JLabel("Last Name :"));
	myPanel.add(ln);
	myPanel.add(new JLabel("Street :"));
	myPanel.add(street);
	myPanel.add(new JLabel("City :"));
	myPanel.add(city);
	myPanel.add(new JLabel("State :"));
	myPanel.add(state);
	myPanel.add(new JLabel("Zip :"));
	myPanel.add(zip);
	myPanel.add(new JLabel("Phone : xxx-aaa-bbbb"));
	myPanel.add(phone);
	myPanel.add(new JLabel("Email :"));
	myPanel.add(email);
}
/**
 * This method displays all the address entries fields to the user
 * 
 */
public void display(){
	JOptionPane.showConfirmDialog(null, myPanel,"Address Entry ", JOptionPane.OK_CANCEL_OPTION);
}
/**
 * Prompts the user for first name and checks for validity
 * @return FirstName 
 */
public String prompt_FirstName(){
	if(fn.getText().toLowerCase().matches("[a-z]*")&&!(fn.getText().equalsIgnoreCase("")))
		return fn.getText();
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid first name");
			fn.setText("");
			display();
			prompt_FirstName();			
		}		
	return fn.getText();
}
/**
 * Prompts the user for last name and checks for validity
 * @return LastName 
 */public String prompt_LastName(){
	 if(ln.getText().toLowerCase().matches("[a-z]*")&&!(ln.getText().equalsIgnoreCase("")))
			return ln.getText();
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid last name");			
			ln.setText("");
			display();
			prompt_LastName();
			}		
	return ln.getText();}
/** 
 * Prompts the user for street
 * @return Street
 */
public String prompt_Street(){
	if(!street.getText().equalsIgnoreCase(""))
		return street.getText();
	else{
		JOptionPane.showMessageDialog(null, "Please enter some street address");			
		street.setText("");
		display();
		prompt_Street();		
	}
	return street.getText();
}
/**
 * Prompts the user for city and checks for validity
 * @return City
 */
public String prompt_City(){
	 if(city.getText().toLowerCase().matches("[a-z]*")&&!(city.getText().equalsIgnoreCase("")))
			return city.getText();
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid City");			
			city.setText("");
			display();
			prompt_City();
			}		
	return city.getText();}
/**
 * Prompts the user for state and checks for validity
 * @return State
 */
public String prompt_State(){
	 if(state.getText().toLowerCase().matches("[a-z]*")&&!(state.getText().equalsIgnoreCase("")))
			return state.getText();
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid State");			
			state.setText("");
			display();
			prompt_State();
			}		
	return state.getText();}

/**
 * Prompts the user for zip code and checks for validity
 * @return Zip
 */
public String prompt_Zip(){
	if(zip.getText().matches("\\d{5}"))
		return zip.getText();
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid Zip");			
			zip.setText("");
			display();
			prompt_Zip();}		
	return zip.getText();
}
/**
 * Prompts the user for telephone and checks for validity
 * @return telephone
 */
public String prompt_Telephone(){
	if(phone.getText().matches("\\d{3}-\\d{3}-\\d{4}"))
	return phone.getText();
	else{
		JOptionPane.showMessageDialog(null, "Please enter a valid Phone number in the proper format");			
		phone.setText("");
		display();
		prompt_Telephone();}
	return phone.getText();
}
/**
 * Prompts the user for email and checks for validity
 * @return email
 */
public String prompt_Email(){
	if(email.getText().matches(".+@.+\\.[a-z]+"))
	return email.getText();
	else{
		JOptionPane.showMessageDialog(null, "Please enter a valid email");			
		email.setText("");
		display();
		prompt_Email();}
	return email.getText();
}
}
