
public class AddressEntry {
	
	public String firstName;
	public String lastName;
	public String street;
	public String city;
	public String state;
	public String zip;
	public String phone;
	public String email;
	
	public AddressEntry(String firstName,String lastName,String street,String city,String state,String zip,String phone,String email)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setPhone(phone);
		this.setEmail(email);
	}
	public String toString()
	{
		return "FirstName:\n>"+getFirstName()+"\nLastName:\n>"+getLastName()+"\nStreet:\n>"+getStreet()+"\nCity:\n>"+getCity()+"\nState:\n>"+getState()+"\nZip:\n>"+getZip()+"\nPhone:\n>"+getPhone()+"\nEmail:\n>"+getEmail();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
