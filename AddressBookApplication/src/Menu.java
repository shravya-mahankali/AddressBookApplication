import java.util.Scanner;

/**
 * The Menu class is used to display menu options to the user. It also prompts user for information to be used to 
 *	create a new AddressEntry
  *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 
 */
public class Menu {
	/**
	 * Stores all the input values from user	
	 */
	private String values="";
	/**
	 * To take input values from user
	 */
	Scanner sc=new Scanner(System.in);
	/**
	 * Stores the menu options to be displayed to the user
	 */
	private String print="************************************"+'\n'
						+"Please enter in your menu selection"+'\n'
						+"a)Loading from file"+'\n'
						+"b)Addition"+'\n'
						+"c)Removal"+'\n'
						+"d)Find"+'\n'
						+"e)Listing"+'\n'
						+"f)Save and Quit"+'\n'
						+"************************************"+'\n';
	/**
	 * This method returns the menu option to be displayed to the user
	 * @return print
	 */
	public String display(){
		return print;
	}
	/**
	 * Prompts the user for first name and checks for validity
	 * @return FirstName 
	 */
	public String prompt_FirstName(){
		System.out.println("FirstName:");
		values=sc.nextLine().toLowerCase();
		if(values.matches("[a-z]*"))
			return values;
			else{
				System.out.println("Please enter a valid first name");
				prompt_FirstName();}		
		return values;
	}
	/**
	 * Prompts the user for last name and checks for validity
	 * @return LastName 
	 */public String prompt_LastName(){
		System.out.println("LastName:");
		values=sc.nextLine().toLowerCase();
		if(values.matches("[a-z]*"))return values;
			else{
				System.out.println("Please enter a valid last name");
				prompt_LastName();}		
		return values;}
	/**
	 * Prompts the user for street
	 * @return Street
	 */
	public String prompt_Street(){
		System.out.println("Street:");
		values=sc.nextLine();
		return values;
	}
	/**
	 * Prompts the user for city and checks for validity
	 * @return City
	 */
	public String prompt_City(){
		System.out.println("City:");
		values=sc.nextLine().toLowerCase();
		if(values.matches("[a-z]*"))	return values;
			else{
				System.out.println("Please enter a valid city");
				prompt_City();}		
		return values;}
	/**
	 * Prompts the user for state and checks for validity
	 * @return State
	 */
	public String prompt_State(){
		System.out.println("State:");
		values=sc.nextLine().toLowerCase();
		if(values.matches("[a-z]*"))		return values;
			else{
				System.out.println("Please enter a valid state");
				prompt_State();}		
		return values;
	}
	/**
	 * Prompts the user for zip code and checks for validity
	 * @return Zip
	 */
	public String prompt_Zip(){
		System.out.println("Zip:");
		values=sc.nextLine();
		if(values.matches("\\d{5}"))
			return values;
			else{
				System.out.println("Please enter valid zip code");
				prompt_Zip();}		
		return values;
	}
	/**
	 * Prompts the user for telephone and checks for validity
	 * @return telephone
	 */
	public String prompt_Phone(){
		System.out.println("Phone: xxx-aaa-bbbb");
		values=sc.nextLine();
		if(values.matches("\\d{3}-\\d{3}-\\d{4}"))
		return values;
		else{
			System.out.println("Please enter telephone number in the below mentioned format");
			prompt_Phone();}
		return values;
	}
	/**
	 * Prompts the user for email and checks for validity
	 * @return email
	 */
	public String prompt_Email(){
		System.out.println("Email:");
		values=sc.nextLine();
		if(values.matches(".+@.+\\.[a-z]+"))
		return values;
		else{
			System.out.println("Please enter a valid email address");
			prompt_Email();}
		return values;
	}
}
