package address.data.note;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import address.data.AddressBook;
/**
 *	The NoteAction class performs all operation on Note object i.e. Storing in database and retrieving from database. 
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016  
 */
public class NoteAction {
	/**
	 * Uses an instance of AddressBook to get the AddressEntry ID
	 */
	AddressBook ab;
	/**
	 * List to store the Note objects.
	 */
	private static ArrayList<Note> n=new ArrayList<Note>();
	/**
	 * Constructor to initialize the AddressBook class
	 * @param a		initializes the AddressBook class
	 */
	public NoteAction(AddressBook a){
		ab=a;
	}
	/**
	 * Method to return the list of note object
	 * @return  list of Note object
	 */
	public static ArrayList<Note> getNote(){
		return n;
	}
	/**
	 * Method to store the current Note object to the Database.
	 * @param address		Address entry for which the note needs to be stored		
	 * @param Comment		Comment on the Note
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void storeNoteToDB(String address,String Comment) throws ClassNotFoundException, SQLException{
		if(!Comment.equalsIgnoreCase("")){
			Class.forName ("oracle.jdbc.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
			Statement stmt = conn.createStatement ();
			/**
			 * Query to insert the note to the data base
			 */
			String query= "insert into NOTES (ID, ADDRESSENTRYID, COMMENTS) values(?, ?, ?)";
			ResultSet rset = stmt.executeQuery("select * from NOTES");
			PreparedStatement pstmt =null;
			/**
			 * Variable to get the Unique Note ID.
			 */
			int noteId=0;
			while(rset.next ()){
				noteId++;
			}
			/**
			 * Iterate through the list of address entries to get the corresponding Address Entry id.
			 */
			for(int i=0;i<ab.getList().size();i++){
				if(address.equalsIgnoreCase(ab.getList().get(i).toString())){
					pstmt=conn.prepareStatement(query);
					pstmt.setInt(1,++noteId);
					pstmt.setInt(2,(int) ab.getId().get(i) );
					pstmt.setString(3, Comment);
					pstmt.executeUpdate();
				}}
			pstmt.close();
			stmt.close();
		}}
	/**
	 * Method to retrieve the note from database by AddressEntry ID.
	 * @param ID	The address entry ID
	 * @return		Array list of note object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Note> getNotes(int ID) throws ClassNotFoundException, SQLException{
		n.clear();
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
		Statement stmt = conn.createStatement ();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/**
		 * Query to search the database by the given address entry id
		 */
		String query="select * from NOTES where ADDRESSENTRYID=?";
		pstmt=conn.prepareStatement(query);
		pstmt.setInt(1, ID);
		rs=pstmt.executeQuery();
		/**
		 * iterate through every row of an Address entry
		 */
		while(rs.next()){
			n.add(new Note(rs.getInt(2),rs.getString(3)));
			//				 System.out.println(rs.getString(3));			 
		}
		return n;} 		
	/**
	 * Method to retrieve Note from database based on the phrase entered by the user. 
	 * @param phrase	phrase entered by the user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Note> getNotes(String phrase) throws ClassNotFoundException, SQLException{
		n.clear();
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
		Statement stmt = conn.createStatement ();		  
		ResultSet rs = null;
		/**
		 * Query to get the notes having the particular phrase
		 */
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM NOTES WHERE COMMENTS like ?");
		pstmt.setString(1, "%" + phrase + "%");

		rs=pstmt.executeQuery();
		/**
		 * Iterate through every row of the database		
		 */
		while(rs.next())
			n.add(new Note(rs.getInt(2),rs.getString(3)));
		return n;
	}
}
