package address.data;

/**
 * The AddressEntry class represents a single contact information entry in the AddressBook.  
 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 
 */

public class AddressEntry {
	
	/**
	 * Stores the first name of an address entry. 
	 */
	private String firstName;
	/**
	 * Stores the last name of an address entry. 
	 */
	private String lastName;
	/**
	 * Stores the street of an address entry. 
	 */
	private String street;
	/**
	 * Stores the city of an address entry. 
	 */
	private String city;
	/**
	 * Stores the state of an address entry. 
	 */
	private String state;
	/**
	 * Stores the zip of an address entry. 
	 */
	private String zip;
	/**
	 * Stores the telephone number of an address entry. 
	 */
	private String phone;
	/**
	 * Stores the email address of an address entry. 
	 */
	private String email;
	/**
	 * It calls the Address class to store the address information of a contact.
	 */
		private Address ad;
	/**
		 * It calls the Name class to store the first and last name of a contact respectively.
		 */
			private Name n;
			
	/**
	 * Constructor takes all the read in data from an address to initialize the AddressEntry object
	 * 
	 * @param firstName 	initialize firstName
	 * @param lastName 		initialize lastName
	 * @param street		initialize street 
	 * @param city			initialize city
	 * @param state			initialize state
	 * @param zip			initialize zip
	 * @param phone		initialize telephone
	 * @param email			initialize email
	 */
	
	public AddressEntry(String firstName,String lastName,String street,String city,String state,String zip,String phone,String email)
	{
		this.firstName = firstName;
		this.lastName= lastName;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone=phone;
		this.email=email;
		
	}
	/**
	 * Constructor that takes in an instance of Address class, Name class, Phone and email to initialize the address entry
	 * @param address	to initialize address information
	 * @param name		to initialize first and last name
	 * @param phone		to initialize phone no
	 * @param em		to initialize email address
	 */
		public AddressEntry(Address address,Name name,String phone,String em){
			this.ad=address;
			this.n=name;
			this.firstName=name.getfirstName();
			this.lastName=name.getlastName();
			this.street=address.getStreet();
			this.city=address.getCity();
			this.state=address.getState();
			this.zip=""+address.getZip();
			this.email=em;
			this.phone=phone;
		}
	/**
	 * This method returns a formated string containing all the address info for printing on the console
	 * @return String
	 */
	public String toString()
	{
		return "FirstName:\n>"+getFirstName()+"\nLastName:\n>"+getLastName()+"\nStreet:\n>"+getStreet()+"\nCity:\n>"+getCity()+"\nState:\n>"+getState()+"\nZip:\n>"+getZip()+"\nPhone:\n>"+getPhone()+"\nEmail:\n>"+getEmail();
	}
	/**
	 * This method returns a formated string for writing to file.
	 * @return formatted String
	 */
	public String toFile(){
		String print="";
		print=String.format(firstName+ System.getProperty("line.separator")+lastName+System.getProperty("line.separator")+
		street+System.getProperty("line.separator")+city+System.getProperty("line.separator")+state+System.getProperty("line.separator")+
		zip+System.getProperty("line.separator")+phone,System.getProperty("line.separator")+
		email+System.getProperty("line.separator")	);
		return print;
	}
	/**
	 * This function returns the first name of an AddressEntry object
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * This function sets the first name of an AddressEntry object
	 *  @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * This function returns the last name of an AddressEntry object
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * This function sets the last name of an AddressEntry object
	 *  @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * This function returns the street of an AddressEntry object
	 * @return street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * This function sets the street of an AddressEntry object
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * This function returns the city of an AddressEntry object
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * This function sets the city of an AddressEntry object
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * This function returns the state of an AddressEntry object
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * This function sets the state of an AddressEntry object
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * This function returns the zip of an AddressEntry object
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * This function sets the zip of an AddressEntry object
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * This function returns the phone number of an AddressEntry object
	 * @return phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * This function sets the phone number of an AddressEntry object
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * This function returns the email of an AddressEntry object
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * This function sets the email of an AddressEntry object
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
