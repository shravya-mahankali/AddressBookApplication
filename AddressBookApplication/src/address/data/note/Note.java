package address.data.note;
/**
 *	The Note class is used to store information about a contact represented by an Address Entry. 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016 
 **/
public class Note {
	/**
	 * Variable to store the address entry ID 
	 */
	private int AddressEntryId;
	/**
	 * Variable to store the Comments relating to an address entry
	 */
	private String comments;
	/**
	 * Constructor to initialize the Address entry id and Comments
	 * @param id		initialize the address entry id.	
	 * @param comm		initialize the comment.
	 */
	public Note(int id, String comm){
		this.AddressEntryId=id;
		this.comments=comm;
	}
	/**
	 * Method to get the address entry id of a particular note
	 * @return the address entry id
	 */
	public int getId(){
		return this.AddressEntryId;
	}
	/**
	 * Method to get the comment of a particular note
	 * @return the comment
	 */
	public String getComments(){
		return this.comments;
	}
}
