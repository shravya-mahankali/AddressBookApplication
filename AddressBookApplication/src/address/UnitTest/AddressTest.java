/**
 * 
 */
package address.UnitTest;

import static org.junit.Assert.*;
import address.data.Address;
import org.junit.Test;

/**
 * The AddressTest class performs Unit testing for all methods inside the Address class
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016     */
public class AddressTest {

	/**
	 * Test method for {@link address.data.Address#Address(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testAddress() {
		Address a=new Address("139 Paradise deive","Hercules","CA",94547);
		assertEquals("139 Paradise deive",a.getStreet());
		assertEquals("Hercules",a.getCity());
		assertEquals("CA",a.getState());
		assertEquals(94547,a.getZip());

		a=new Address("andheri","mumbai","maharastra",12121);
		assertEquals("andheri",a.getStreet());
		assertEquals("mumbai",a.getCity());
		assertEquals("maharastra",a.getState());
		assertEquals(12121,a.getZip());
	}

	/**
	 * Test method for {@link address.data.Address#getStreet()}.
	 */
	@Test
	public void testGetStreet() {
		Address a=new Address("139 Paradise deive","Hercules","CA",94547);
		assertEquals("139 Paradise deive",a.getStreet());

		a=new Address("andheri","mumbai","maharastra",12121);
		assertNotEquals("139 paradise drive",a.getStreet());		
	}

	/**
	 * Test method for {@link address.data.Address#getCity()}.
	 */
	@Test
	public void testGetCity() {
		Address a=new Address("139 Paradise deive","Hercules","CA",94547);
		assertEquals("Hercules",a.getCity());

		a=new Address("andheri","mumbai","maharastra",12121);
		assertEquals("mumbai",a.getCity());		
	}

	/**
	 * Test method for {@link address.data.Address#getState()}.
	 */
	@Test
	public void testGetState() {
		Address a=new Address("139 Paradise deive","Hercules","CA",94547);
		assertEquals("CA",a.getState());

		a=new Address("andheri","mumbai","maharastra",12121);
		assertEquals("maharastra",a.getState());		
	}

	/**
	 * Test method for {@link address.data.Address#getZip()}.
	 */
	@Test
	public void testGetZip() {
		Address a=new Address("139 Paradise deive","Hercules","CA",94547);
		assertEquals(94547,a.getZip());

		a=new Address("andheri","mumbai","maharastra",12121);
		assertEquals(12121,a.getZip());
	}
}
