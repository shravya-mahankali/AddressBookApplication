import static org.junit.Assert.*;

import org.junit.Test;
/**
 *The AddressEntryTest class performs unit testing all the methods of the AddressEntry class. 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 *
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
		 * This method tests the constructor for given input parameters.
		 * Test method for {@link AddressEntry#AddressEntry(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
		 */
		@Test
		public void testAddressEntry() {

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
		 * This method checks whether the AddressEntry object is getting converted to the appropriate string format
		 * Test method for {@link AddressEntry#toString()}.
		 */
		@Test
		public void testToString() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			String print="first last"+'\n'
					+ "12 street"+'\n'
					+"city, state 51015"+'\n'
					+ "email12@gmail.com"+'\n'
					+"111-111-1111"+'\n';
			assertEquals(print.toLowerCase(),ae1.toString().toLowerCase());
		
			ae2=new AddressEntry("f","l","s","c","s","510","invalid@h.com","999-999-9999");
			print="f l"+'\n'
					+ "s"+'\n'
					+"c, s 510"+'\n'
					+ "invalid@h.com"+'\n'
					+"999-999-9999"+'\n';
			assertEquals(print.toLowerCase(),ae2.toString().toLowerCase());
		
		}


		/**
		 * This method checks for the initialization of first name
		 * Test method for {@link AddressEntry#getFirstName()}.
		 */
		@Test
		public void testGetFirstName() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("first".toLowerCase(),ae1.getFirstName().toLowerCase());
			ae2=new AddressEntry("SHRavya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("SHRavya".toLowerCase(),ae2.getFirstName().toLowerCase());
		}

		/**
		 * This method checks for the initialization of last name
		 * Test method for {@link AddressEntry#getLastName()}.
		 */
		@Test
		public void testGetLastName() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("LAST".toLowerCase(),ae1.getLastName().toLowerCase());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("MAHA".toLowerCase(),ae2.getLastName().toLowerCase());
			
		}

		/**
		 * This method checks for the initialization of street
		 * Test method for {@link AddressEntry#getStreet()}.
		 */
		@Test
		public void testGetStreet() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("12 street".toLowerCase(),ae1.getStreet().toLowerCase());
			ae2=new AddressEntry("SHRavya","MAHA","street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("street".toLowerCase(),ae2.getStreet().toLowerCase());
			
		}

		/**
		 * This method checks for the initialization of city
		 * Test method for {@link AddressEntry#getCity()}.
		 */
		@Test
		public void testGetCity() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("CITY".toLowerCase(),ae1.getCity().toLowerCase());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","hercules","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("HERCULES".toLowerCase(),ae2.getCity().toLowerCase());

		}

		/**
		 * This method checks for the initialization of state
		 * Test method for {@link AddressEntry#getState()}.
		 */
		@Test
		public void testGetState() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("STATE".toLowerCase(),ae1.getState().toLowerCase());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","city","CA","51015","111-111-1111","email12@gmail.com");
			assertEquals("CA".toLowerCase(),ae2.getState().toLowerCase());

		}

		/**
		 * This method checks for the initialization of zip
		 * Test method for {@link AddressEntry#getZip()}.
		 */
		@Test
		public void testGetZip() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("51015",ae1.getZip());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","city","state","94547","111-111-1111","email12@gmail.com");
			assertEquals("94547",ae2.getZip());

		}

		/**
		 * This method checks for the initialization of email
		 * Test method for {@link AddressEntry#getEmail()}.
		 */
		@Test
		public void testGetEmail() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("EMAIL12@Gmail.com".toLowerCase(),ae1.getEmail().toLowerCase());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","city","state","51015","111-111-1111","holmes@gmail.com");
			assertEquals("HolMEs@gmail.com".toLowerCase(),ae2.getEmail().toLowerCase());

		}

		/**
		 * This method checks for the initialization of phone no.
		 * Test method for {@link AddressEntry#getPhone()}.
		 */
		@Test
		public void testGetPhone() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			assertEquals("111-111-1111",ae1.getPhone());
			ae2=new AddressEntry("SHRavya","MAHA","12 street","city","state","51015","2222222222","email12@gmail.com");
			assertEquals("2222222222",ae2.getPhone());
		
		}

		/**
		 * This method checks whether the AddressEntry object gets converted to the required format for saving into a file
		 * Test method for {@link AddressEntry#toFile()}.
		 * 
		 */
		@Test
		public void testToFile() {
			ae1=new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com");
			String print=String.format(ae1.getFirstName()+ System.getProperty("line.separator")+ae1.getLastName()+System.getProperty("line.separator")+
					ae1.getStreet()+System.getProperty("line.separator")+ae1.getCity()+System.getProperty("line.separator")+ae1.getState()+System.getProperty("line.separator")+
					ae1.getZip()+System.getProperty("line.separator")+
					ae1.getEmail()+System.getProperty("line.separator")+ae1.getPhone(),System.getProperty("line.separator")+
					ae1.getPhone(),System.getProperty("line.separator"));
					assertEquals(print.toLowerCase(),ae1.toFile().toLowerCase());
		
			ae2=new AddressEntry("f","l","s","c","s","510","999-999-9999","invalid@h.com");
			print=String.format(ae2.getFirstName()+ System.getProperty("line.separator")+ae2.getLastName()+System.getProperty("line.separator")+
					ae2.getStreet()+System.getProperty("line.separator")+ae2.getCity()+System.getProperty("line.separator")+ae2.getState()+System.getProperty("line.separator")+
					ae2.getZip()+System.getProperty("line.separator")+
					ae2.getEmail()+System.getProperty("line.separator")+ae2.getPhone(),System.getProperty("line.separator")+
					ae2.getPhone(),System.getProperty("line.separator"));
					assertEquals(print.toLowerCase(),ae2.toFile().toLowerCase());
		//assertEquals(print.toLowerCase(),ae2.toString().toLowerCase());
		}

}
