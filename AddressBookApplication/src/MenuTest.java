import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *The MenuTest class performs unit testing on all the methods of Menu class
*	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 *
 */
public class MenuTest {
	/**
	 * Create an object of Menu class
	 */
		Menu m;
	/**
	 * This method performs unit testing on all the prompted values in the Menu class
	 */
	@Test
	public void testPrompt() {
		Menu m= new Menu();
		String input;
		InputStream in;
		/**
		 * Tests for prompt_FirstName
		 */
		input = "shravya";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_FirstName());	
	    input = "APARNA";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_FirstName());	
	/**
	 * Tests for prompt_LastName
	 */
		input = "MAHA";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_LastName());	
	    input = "ThAkUr";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_LastName());			
	/**
	 * Tests for prompt_Street
	 */
	    input = "street";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Street());	
	    input = "12 street";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Street());			
	/**
	 * Tests for prompt_City
	 */
	    input = "fremont";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_City());	
	    input = "paris";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_City());			
	/**
	 * Tests for prompt_State
	 */
	    input = "california";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_State());	
	    input = "ohio";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_State());			
	/**
	 * Tests for prompt_Zip
	 */
	    input = "11111";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Zip());	
	    input = "22222";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Zip());			
	/**
	 * Tests for prompt_Email
	 */
	    input = "mail@gmail.com";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Email());	
	    input = "mail1@gmail.com";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Email());			
	/**
	 * Tests for prompt_Telephone
	 */
	    input = "111-111-1111";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Phone());	
	    input = "222-222-2222";
	    in = new ByteArrayInputStream(input.toLowerCase().getBytes());
	    System.setIn(in);
	    assertEquals(input.toLowerCase(), m.prompt_Phone());			

	}
	/**
	 * This method checks whether the display class outputs the Menu option correctly or not.
	 * Test method for {@link Menu#display()}
	 */
	public void testDisplay(){
		String print="************************************"+'\n'
				+"Please enter in your menu selection"+'\n'
				+"a)Loading from file"+'\n'
				+"b)Addition"+'\n'
				+"c)Removal"+'\n'
				+"d)Find"+'\n'
				+"e)Listing"+'\n'
				+"f)Save and Quit"+'\n'
				+"************************************"+'\n';
	assertEquals(print,m.display());
	}

}
