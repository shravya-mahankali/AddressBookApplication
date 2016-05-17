
package address.data;
/**
 * This class is used to store only address details of an Entry
 * 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 


 */
public class Address {

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
	private int zip;
	/**
	 * Constructor takes all the read in data from an address to initialize the Address object


	 * @param street		initialize street 
	 * @param city			initialize city
	 * @param state			initialize state
	 * @param zip			initialize zip

	 */
	public Address(String street,String city,String state,int zip)
	{

		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;


	}
	/**
	 * This method returns a formated string containing all the address info for printing on the console
	 * @return String
	 */
	public String toString()
	{
		return "\nStreet:\n>"+getStreet()+"\nCity:\n>"+getCity()+"\nState:\n>"+getState()+"\nZip:\n>"+getZip();
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
	public int getZip() {
		return zip;
	}
	/**
	 * This function sets the zip of an AddressEntry object
	 * @param zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}




}
