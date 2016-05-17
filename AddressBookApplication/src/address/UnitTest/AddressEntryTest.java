
package address.UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;

/**
 * The AddressEntryTest class performs unit testing on all the methods inside the AddressEntry class
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016   *
 */
public class AddressEntryTest {
	/**
	 * Creating an instance of AddressEntry
	 */
	AddressEntry ae1;
	/**
	 * Creating an instance of AddressEntry
	 */

	AddressEntry ae2;
	/**
	 * Test method for {@link address.data.AddressEntry#AddressEntry(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddressEntryStringStringStringStringStringStringStringString() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("first".toLowerCase(),ae1.getFirstName().toLowerCase());
		assertEquals("last".toLowerCase(),ae1.getLastName().toLowerCase());
		assertEquals("12 STREET".toLowerCase(),ae1.getStreet().toLowerCase());
		assertEquals("city".toLowerCase(),ae1.getCity().toLowerCase());
		assertEquals("state".toLowerCase(),ae1.getState().toLowerCase());
		assertEquals("51015",ae1.getZip());
		assertEquals("EMail12@gmail.com".toLowerCase(),ae1.getEmail().toLowerCase());
		assertEquals("111-111-1111",ae1.getPhone());

		ae2=new AddressEntry("f","l","s","c","s","510","999-999-9999","invalid@h.com");
		assertEquals("f".toLowerCase(),ae2.getFirstName().toLowerCase());
		assertEquals("l".toLowerCase(),ae2.getLastName().toLowerCase());
		assertEquals("s".toLowerCase(),ae2.getStreet().toLowerCase());
		assertEquals("c".toLowerCase(),ae2.getCity().toLowerCase());
		assertEquals("s".toLowerCase(),ae2.getState().toLowerCase());
		assertEquals("510",ae2.getZip());
		assertEquals("INVALID@H.COM".toLowerCase(),ae2.getEmail().toLowerCase());
		assertEquals("999-999-9999",ae2.getPhone());
	}

	/**
	 * Test method for {@link address.data.AddressEntry#AddressEntry(address.data.Address, address.data.Name, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddressEntryAddressNameStringString() {
		Name n=new Name("first","last");
		Address a=new Address("12 street","city","state",51015);
		ae1=new AddressEntry(a,n,"111-111-1111","email12@gmail.com");
		assertEquals(n.getfirstName().toLowerCase(),ae1.getFirstName().toLowerCase());
		assertEquals(n.getlastName().toLowerCase(),ae1.getLastName().toLowerCase());
		assertEquals(a.getStreet().toLowerCase(),ae1.getStreet().toLowerCase());
		assertEquals(a.getCity().toLowerCase(),ae1.getCity().toLowerCase());
		assertEquals(a.getState().toLowerCase(),ae1.getState().toLowerCase());
		assertEquals("51015",ae1.getZip());
		assertEquals("EMail12@gmail.com".toLowerCase(),ae1.getEmail().toLowerCase());
		assertEquals("111-111-1111",ae1.getPhone());

		n=new Name("f","l");
		a=new Address("s","c","s",510);
		ae2=new AddressEntry(a,n,"999-999-9999","invalid@h.com");
		assertEquals("f".toLowerCase(),ae2.getFirstName().toLowerCase());
		assertEquals("l".toLowerCase(),ae2.getLastName().toLowerCase());
		assertEquals("s".toLowerCase(),ae2.getStreet().toLowerCase());
		assertEquals("c".toLowerCase(),ae2.getCity().toLowerCase());
		assertEquals("s".toLowerCase(),ae2.getState().toLowerCase());
		assertEquals("510",ae2.getZip());
		assertEquals("INVALID@H.COM".toLowerCase(),ae2.getEmail().toLowerCase());
		assertEquals("999-999-9999",ae2.getPhone());		
	}

	/**
	 * Test method for {@link address.data.AddressEntry#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("first".toLowerCase(),ae1.getFirstName().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("sUrAnJaN".toLowerCase(),ae2.getFirstName().toLowerCase());	}

	/**
	 * Test method for {@link address.data.AddressEntry#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("LAST".toLowerCase(),ae1.getLastName().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("jENA".toLowerCase(),ae2.getLastName().toLowerCase());
	}

	/**
	 * Test method for {@link address.data.AddressEntry#getStreet()}.
	 */
	@Test
	public void testGetStreet() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("12 street".toLowerCase(),ae1.getStreet().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","jENA","street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("street".toLowerCase(),ae2.getStreet().toLowerCase());	}

	/**
	 * Test method for {@link address.data.AddressEntry#getCity()}.
	 */
	@Test
	public void testGetCity() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("CITY".toLowerCase(),ae1.getCity().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","hercules","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("HERCULES".toLowerCase(),ae2.getCity().toLowerCase());	}

	/**
	 * Test method for {@link address.data.AddressEntry#getState()}.
	 */
	@Test
	public void testGetState() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("STATE".toLowerCase(),ae1.getState().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","city","CA","51015","111-111-1111","email12@gmail.com");
		assertEquals("CA".toLowerCase(),ae2.getState().toLowerCase());	}

	/**
	 * Test method for {@link address.data.AddressEntry#getZip()}.
	 */
	@Test
	public void testGetZip() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("51015",ae1.getZip());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","city","state","94547","111-111-1111","email12@gmail.com");
		assertEquals("94547",ae2.getZip());	}

	/**
	 * Test method for {@link address.data.AddressEntry#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("EMAIL12@Gmail.com".toLowerCase(),ae1.getEmail().toLowerCase());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","city","state","51015","111-111-1111","holmes@gmail.com");
		assertEquals("HolMEs@gmail.com".toLowerCase(),ae2.getEmail().toLowerCase());
	}

	/**
	 * Test method for {@link address.data.AddressEntry#getPhone()}.
	 */
	@Test
	public void testGetPhone() {
		ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
		assertEquals("111-111-1111",ae1.getPhone());
		ae2=new AddressEntry("sUrAnJaN","jENA","12 street","city","state","51015","2222222222","email12@gmail.com");
		assertEquals("2222222222",ae2.getPhone());
	}

}
