import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;



/**
 *The AddressBookTest class performs unit testing on every method inside the AddressBook class
  *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 *
 */
public class AddressBookTest {
	/**
	 * Create an instance of AddressBook
	 */
	AddressBook ab;
	/**
	 * This method checks for total number of address entries on the addressEntryList
	 * Test method for {@link AddressBook#list()}.
	 */
	@Test
	public void testList() {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email@gmail.com"));
		assertEquals(1,ab.addressEntryList.size());
		ab.addressEntryList.add(new AddressEntry("f","l","s","city","s","510","999-999-9999","invalid@sh.com"));
		assertEquals(2,ab.addressEntryList.size());
	}

	/**
	 * This method checks whether a given address entry is getting added to the addressEntryList or not
	 * Test method for {@link AddressBook#add(AddressEntry)}.
	 */
	@Test
	public void testAdd() {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email@gmail.com"));
		assertEquals(1,ab.addressEntryList.size());
		ab.addressEntryList.add(new AddressEntry("f","l","s","city","s","510","999-999-9999","invalid@sh.com"));
		assertEquals(2,ab.addressEntryList.size());
		
	}

	/**
	 *This method checks whether a given address entry is removed from the addressEntryList or not.
	 * Test method for {@link AddressBook#remove(java.lang.String)}.
	 */
	@Test
	public void testRemove() {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","maha","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","guardino","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","last","street","guardino","state","51015","111-111-1111","email@gmail.com"));		
		ab.remove("last");
		ab.clearFindList();
		assertEquals(2, ab.addressEntryList.size());
		ab.remove("last");
		ab.clearFindList();
		assertEquals(1, ab.addressEntryList.size());
	}

	/**
	 * This method checks for the number of entries returned by the find method when the initials of last name are given as input
	 * Test method for {@link AddressBook#find(java.lang.String)}.
	 */
	@Test
	public void testFind() {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		
		assertEquals(1,ab.find("xyz").size());
		ab.clearFindList();
		assertEquals(2,ab.find("last").size());
		ab.clearFindList();
		assertEquals(0,ab.find("la").size());
		ab.clearFindList();
	}

	/**
	 *This method checks whether the entries are getting stored in file or not
	 * Test method for {@link AddressBook#FileWrite(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testFileWrite() throws IOException {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.FileWrite("test.txt");
		ab.addressEntryList.clear();
		ab.FileRead("test.txt");
		assertEquals(3,ab.addressEntryList.size());
		
		ab.addressEntryList.clear();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.FileWrite("test.txt");
		ab.addressEntryList.clear();
		ab.FileRead("test.txt");
		assertEquals(2,ab.addressEntryList.size());
		
	}

	/**
	 * This method checks whether the find addressEntryList is cleared or not
	 * Test method for {@link AddressBook#clearFindList()}.
	 */
	@Test
	public void testClearFindaddressEntryList() {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.find("last");
		ab.clearFindList();
		assertEquals(0,ab.f.size());
		
		ab.addressEntryList.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.find("last");
		ab.clearFindList();
		assertEquals(0,ab.f.size());
		
	}

	/**
	 * This method checks whether the address entries are correctly read from file
	 * Test method for {@link AddressBook#FileRead(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testFileRead() throws IOException {
		ab=new AddressBook();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.addressEntryList.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.FileWrite("test.txt");
		ab.addressEntryList.clear();
		ab.FileRead("test.txt");
		assertEquals(3,ab.addressEntryList.size());
		
		ab.addressEntryList.clear();
		ab.addressEntryList.add(new AddressEntry("shravya","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.addressEntryList.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.FileWrite("test.txt");
		ab.addressEntryList.clear();
		ab.FileRead("test.txt");
		assertEquals(2,ab.addressEntryList.size());
		
		ab.addressEntryList.clear();
		ab.FileRead("AddressInputDataFile.txt");
		System.out.println("The address book has "+ab.addressEntryList.size()+" address entries");
		
	}

}

