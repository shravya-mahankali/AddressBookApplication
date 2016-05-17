/**
 * 
 */
package address.UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import address.data.note.Note;

/**
 * The NoteTest class performs unit testing on all methods inside the Note class
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016    */
public class NoteTest {

	/**
	 * Test method for {@link address.data.note.Note#Note(int, java.lang.String)}.
	 */
	@Test
	public void testNote() {
		Note n=new Note(12,"This is a new note");
		assertEquals(12,n.getId());
		assertEquals("This is a new note",n.getComments());

		n=new Note(13,"This is another note");
		assertEquals(13,n.getId());
		assertEquals("This is another note",n.getComments());
	}

	/**
	 * Test method for {@link address.data.note.Note#getId()}.
	 */
	@Test
	public void testGetId() {
		Note n=new Note(12,"This is a new note");
		assertEquals(12,n.getId());

		n=new Note(13,"This is another note");
		assertEquals(13,n.getId());
	}

	/**
	 * Test method for {@link address.data.note.Note#getComments()}.
	 */
	@Test
	public void testGetComments() {
		Note n=new Note(12,"This is a new note");
		assertEquals("This is a new note",n.getComments());

		n=new Note(13,"This is another note");
		assertEquals("This is another note",n.getComments());
	}

}
