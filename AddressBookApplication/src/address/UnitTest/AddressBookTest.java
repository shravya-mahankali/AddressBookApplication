/**
 * 
 */
package address.UnitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import address.data.AddressBook;
import address.data.AddressEntry;

/**
 * The AddressBookTest class tests all the methods inside the address book class
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016    */
public class AddressBookTest {
	/**
	 * Create an instance of AddressBook class
	 */
	AddressBook ab;
	/**
	 * Test method for {@link address.data.AddressBook#getList()}.
	 */
	@Test
	public void testgetList() {
		ab=new AddressBook();
		ab.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));
		assertEquals(1,ab.getList().size());
		ab.add(new AddressEntry("f","l","s","city","s","510","999-999-9999","invalid@h.com"));
		assertEquals(2,ab.getList().size());
	}

	/**
	 * Test method for {@link address.data.AddressBook#add(address.data.AddressEntry)}.
	 */
	@Test
	public void testAdd() {
		ab=new AddressBook();
		ab.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));
		assertEquals(1,ab.getList().size());
		ab.add(new AddressEntry("f","l","s","city","s","510","999-999-9999","invalid@h.com"));
		assertEquals(2,ab.getList().size());	
	}



	/**
	 * Test method for {@link address.data.AddressBook#getAddressId(java.lang.String)}.
	 */
	@Test
	public void testGetAddressId() {
		ab=new AddressBook();
		ab.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));
		ab.setAddressId();
		assertEquals("email12@gmail.com".hashCode(),ab.getAddressId(ab.getList().get(0).toString()));
	}

	/**
	 * Test method for {@link address.data.AddressBook#getName(int)}.
	 */
	@Test
	public void testGetName() {
		ab=new AddressBook();
		ab.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));
		assertEquals("first"+"   "+"last",ab.getName((int) ab.getId().get(0)));
	}

	/**
	 * Test method for {@link address.data.AddressBook#remove(java.lang.String)}.
	 */
	@Test
	public void testRemove() {
		ab=new AddressBook();
		ab.add(new AddressEntry("first","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));
		ab.add(new AddressEntry("f","l","s","city","s","510","999-999-9999","invalid@h.com"));
		ab.remove(ab.getList().get(1).toString());
		assertEquals(1,ab.getList().size());

		ab.remove(ab.getList().get(0).toString());
		assertEquals(0,ab.getList().size());
	}

	/**
	 * Test method for {@link address.data.AddressBook#find(java.lang.String)}.
	 */
	@Test
	public void testFind() {
		ab=new AddressBook();
		ab.add(new AddressEntry("fex","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		

		assertEquals(1,ab.find("x").size());
		ab.clearFindList();
		assertEquals(2,ab.find("las").size());
		ab.clearFindList();
		assertEquals(0,ab.find("lax").size());
		ab.clearFindList();
	}
	/**
	 * Test method for {@link address.data.AddressBook#clearFindList()}.
	 */
	@Test
	public void testClearFindList() {
		ab=new AddressBook();
		ab.add(new AddressEntry("fex","last","12 street","city","state","51015","111-111-1111","email12@gmail.com"));		
		ab.add(new AddressEntry("fname","last","street","hercules","state","51015","111-111-1111","email@gmail.com"));
		ab.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.find("last");
		ab.clearFindList();
		assertEquals(0,ab.f.size());

		ab.add(new AddressEntry("fname","xyz","street","hercules","state","51015","111-111-1111","email@gmail.com"));		
		ab.find("last");
		ab.clearFindList();
		assertEquals(0,ab.f.size());	
	}

	/**
	 * Test method for {@link address.data.AddressBook#Load()}.
	 */
	@Test
	public void testLoad() {
		ab=new AddressBook();
		try {
			ab.Load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ab.getId().size(),ab.getList().size());
	}

}
