import java.io.*;
import java.util.Scanner;
/**
 * 	The AddressBookApplication is the main application class. It uses Menu class to prompt the various fields of
 * 	an AddressEntry and it uses AddressBook class for different operations on AddressEntries.
 * 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 
 */


public class AddressBookApplication {

	/**
	 * Creating object of the class AddressBook
	 */
	static AddressBook abook=new AddressBook();
	/**
	 * Creating object of class AddressEntry	
	 */
		static AddressEntry ae;
		/**
		 * Store name of file. By default the name of file is "AddressInputDataFile.txt" but the user may enter a new file name
		 */
		private static String filename="AddressBookFile.txt";
		/**
		 * getting the menu option from the user
		 */
		private static String option;
	
	
	/**
	 * The main method creates the object of class Menu to show different operation to the user and then 
	 * calls appropriate function from AddressBook class. 
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		/**
		 * creating object of Menu class
		 */
		Menu m=new Menu();
		/**
		 * loop through different options till user clicks on save and quit.
		 */
		
		while(true){
		/**
		 * displaying Menu options
		 */
		System.out.print(m.display());
		/**
		 * Scanner to take input from user
		 */
		try{
		Scanner sc=new Scanner(System.in);
		option=sc.nextLine();
		/**
		 * Take file name from user and load it
		 */
		if(option.equalsIgnoreCase("a")){
			System.out.println("Enter in File Name:");
			filename=sc.nextLine();
			abook.FileRead(filename);
		}
		/**
		 * Take input from user to add an address entry by calling all the prompted methods
		 */
		else if(option.equalsIgnoreCase("b")){	
			ae=new AddressEntry(m.prompt_FirstName(),m.prompt_LastName(),m.prompt_Street()
					,m.prompt_City(),m.prompt_State(),m.prompt_Zip(),m.prompt_Email(),m.prompt_Phone());
			abook.add(ae);
			System.out.println("Thank you the following contact has been added to your address book");
			System.out.println(ae.toString());
			abook.FileWrite(filename);	
			}
		/**
		 * Take last name from user and remove the address entry
		 */
		else if(option.equalsIgnoreCase("c")){
			System.out.println("Enter in Last Name of contact to remove:");
			abook.remove(sc.nextLine());
			abook.FileWrite(filename);
			abook.clearFindList();
		}
		/**
		 * Find all the address entry starting from the last name
		 */
		else if(option.equalsIgnoreCase("d")){
			System.out.println("Enter in all or beginning of the Last Name of the contact you wish to find:");	
			abook.find(sc.nextLine());
			abook.clearFindList();
		}
		/**
		 * listing all the address entries
		 */
		else if(option.equalsIgnoreCase("e")){
			abook.List();
		}
		/**
		 * save and quit. Breaks out of the infinite while loop
		 */
		else if(option.equalsIgnoreCase("f")){	
			System.out.println("Enter in the name of the file you wish to save your address book to:");
			filename=sc.nextLine();
			abook.FileWrite(filename);
			System.out.println("Thank you, your address book has been backed up to the file"+'\n'+filename+" Goodbye!");
//			
			break;
		}
		/**
		 * if the user enters an invalid menu choice
		 */
		else
			System.out.println("Please Enter a Valid option");
		}
		
		catch(FileNotFoundException f)
		{
			System.out.println("The file name entered was incorrect.Please check it and try once again");
			
		}
			}
	}
}
	

		
