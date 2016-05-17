/**
 * 
 */
package address.UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import address.data.Name;
/**
 * The NameTest class performs Unit testing for all methods on the Name class
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016    */
public class NameTest {

	/**
	 * Test method for {@link address.data.Name#Name(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testName() {
		Name n=new Name("Shravya","Mahankali");
		assertEquals("Shravya",n.getfirstName());
		assertEquals("Mahankali",n.getlastName());

		n=new Name("Sherlock","Holmes");
		assertEquals("Sherlock",n.getfirstName());
		assertEquals("Holmes",n.getlastName());
	}

	/**
	 * Test method for {@link address.data.Name#getfirstName()}.
	 */
	@Test
	public void testGetfirstName() {
		Name n=new Name("Shravya","Mahankali");
		assertEquals("Shravya",n.getfirstName());

		n=new Name("Sherlock","Holmes");
		assertEquals("Sherlock",n.getfirstName());
	}

	/**
	 * Test method for {@link address.data.Name#getlastName()}.
	 */
	@Test
	public void testGetlastName() {
		Name n=new Name("Shravya","Mahankali");
		assertEquals("Mahankali",n.getlastName());

		n=new Name("Sherlock","Holmes");
		assertEquals("Holmes",n.getlastName());
	}

}
