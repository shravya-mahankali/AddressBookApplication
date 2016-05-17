package address;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import address.GUI.AddressBookGUI;

/**
 * 	The AddressBookApplication is the main application class. It calls the GUI interface of the AdddressBookApplication
 * 
  *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 
 */
public class AddressBookApplication {
/**
 * The main method calls the main method of the class AddressBookGUI which starts the Address Book Interface. 
 * d
 * @param args
 * @throws IOException
 */
public static void main(String[] args) throws IOException {
/**
 *Display the GUI to the User
 */
AddressBookGUI.main(args);
}

}
