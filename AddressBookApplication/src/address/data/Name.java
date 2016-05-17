package address.data;
/**
 *	The Name class stores the first and Last name of a address entry. 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016 
 */
public class Name {
	/**
	 * Variable to store the first name
	 */
	private String fName;
	/**
	 * Variable to store the last name
	 */
	private String lName;
	/**
	 * Constructor to initialize the first and last name of an Address entry
	 * @param f		initialize the first name
	 * @param l		initialize the last name
	 */
	public Name(String f,String l){
		this.fName=f;
		this.lName=l;
	}
	/**
	 * Method to returns the first name of an address entry
	 * @return	First Name
	 */
	public String getfirstName(){
		return this.fName;
	}
	/**
	 * Method to return the Last name of an address entry
	 * @return Last Name
	 */
	public String getlastName(){
		return this.lName;
	}
}
