import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
/**
* The AddressBookApplicationTest class checks whether the entire program is functioning correctly or not.
*	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 *
*/
public class AddressBookApplicationTest {
	
	/**
	 * This method tests for the correct functioning of AddressBookApplication by using AddressBook class to read from a text file and then using Main method to modify the text file as mentioned.
	 * Test method for {@link AddressBookApplication#main(java.lang.String[])}.
	 * @throws IOException 
	 */
	@Test
	public void testMain() throws IOException {
		AddressBookApplication aba=new AddressBookApplication();
		AddressBook ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.FileWrite("AddressBookFile.txt");
		ab.addressEntryList.clear();
		System.out.println("OPEN AddressBookFile.txt AND ADD A NEW ADDRESS"
				+'\n'+"THE FILE HAS PREVIOUSLY 7 ADDRESSES"
				+'\n'+"ADD A NEW ADDRESS AND CHECK");
		AddressBookApplication.main(new String[] {"arg1"});
		ab.FileRead("AddressBookFile.txt");
		assertEquals(4,ab.addressEntryList.size());
		
	}

}
