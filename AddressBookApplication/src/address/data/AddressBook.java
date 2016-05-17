package address.data;

import java.sql.*;
import java.io.IOException;
import java.util.*;
/**
 * 
 *	The AddressBook class represents the growing and shrinking list of address entries by inserting and removing from the database. 
 *	It also allows for various operation on address entries.
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016  
 *
 */
public class AddressBook {
	/**
	 * Declaring list to store AddressEntry objects. 
	 */	
	private ArrayList<AddressEntry> list = new ArrayList<AddressEntry>();
	/**
	 * List to store the corresponding id of an address entry.
	 */
	private ArrayList<Integer> id=new ArrayList<Integer>();
	/**
	 * To store all the address entries found when searched through last names.	
	 */
	public ArrayList<AddressEntry> f = new ArrayList<AddressEntry>();

	/**
	 * Store total number of address entries found
	 */
	private int num;

	/**
	 * This method returns the list of address entries
	 * @return LIST
	 */
	public List getList(){		 
		return list;
	}	
	/**
	 * This method returns the address entry id
	 * @return Id
	 */
	public List getId(){
		return id;
	}
	/**
	 *	This method adds AddressEntry object to the list and sorts them on basis of First name
	 * 	@param ae
	 
	 */
	public void add(AddressEntry ae) {
		/*
		 * adding AddressEntry objects to the list
		 */

		list.add(ae);			

		/*
		 * To sort the list of AddressEntry object based on the last name.
		 */
		Collections.sort(list, new Comparator<AddressEntry>(){
			public int compare(AddressEntry s1, AddressEntry s2){
				return s1.getLastName().compareToIgnoreCase(s2.getLastName());
			}
		});
	}
	/**
	 * This method sets id for every address entry by using hashing function on the email  
	 */
	public void setAddressId(){
		id.clear();
		for(int i=0;i<list.size();i++){
			id.add(list.get(i).getEmail().hashCode());
		}
	}
	/**
	 *This method returns the corresponding id when searched through the address entry 
	 * @param address 
	 * @return the address entry id
	 */
	public int getAddressId(String address){
		int addId = 0;
		for(int i=0;i<list.size();i++){
			if(address.equalsIgnoreCase(list.get(i).toString())){
				addId=id.get(i);
			}}	
		return addId;
	}
	/**
	 * This method returns the Name of the person when searched through the address entry id.
	 *  It is required while displaying the notes of corresponding address entry id.
	 * @param AddressId address entry id
	 * @return the name of the person of corresponding address entry id
	 */
	public String getName(int AddressId){
		String name="";
		for(int i=0;i<id.size();i++){
			if(id.get(i)==AddressId){
				name=list.get(i).getFirstName()+"   "+list.get(i).getLastName();
				break;	
			}
		}
		return name;
	}
	/**
	 * This method removes an address entry and also the corresponding id.
	 * @param address that needs to be removed
	 */
	public void remove(String address){

		for(int i=0;i<list.size();i++){
			if(address.equalsIgnoreCase(list.get(i).toString())){
				list.remove(i);
				id.remove(i);}
		}			
	}
	/**
	 * This method finds a list of address entries starting from the given alphabets 
	 * @param LastName 
	 * @return the list of address entries found
	 */
	public List find(String LastName){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getLastName().toLowerCase().startsWith(LastName.toLowerCase())){
				f.add(list.get(i));
			}
		}			
		return f;
	}
	/**
	 * This method clears the database before entering the list of address entries.
	 * The purpose is ensure that there is no duplicate entries.
	 * @throws ClassNotFoundException
	 * @throws SQLException,
	 */
	public void del() throws ClassNotFoundException, SQLException{
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
		Statement stmt = conn.createStatement ();
		/**
		 * query to remove all entries from a database
		 */
		String del="DELETE from ADDRESSENTRYTABLE";
		stmt.execute(del);	      
		conn.close();
	}
	/**
	 * This method is called when the save button is clicked. It saves the list of address entry to the database.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insert() throws  ClassNotFoundException, SQLException{
		del();
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
		Statement stmt = conn.createStatement ();
		/**
		 * query to insert address entry into database
		 */
		String query= "insert into ADDRESSENTRYTABLE (FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP, PHONE, EMAIL, ID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt =null; 
		/**
		 * Setting the values to the required fields and storing them to the database
		 */
		for(int i=0;i<list.size();i++){
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,list.get(i).getFirstName());
			pstmt.setString(2,list.get(i).getLastName());
			pstmt.setString(3,list.get(i).getStreet());
			pstmt.setString(4,list.get(i).getCity());
			pstmt.setString(5,list.get(i).getState());
			pstmt.setString(6,list.get(i).getZip());
			pstmt.setString(7,list.get(i).getPhone());
			pstmt.setString(8,list.get(i).getEmail());
			pstmt.setInt(9,list.get(i).getEmail().hashCode());
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}
	/**
	 * This method clears the find list. This is necessary before a new search.
	 */
	public void clearFindList(){
		f.clear();
	}
	/**
	 * This method loads the list of address entry from the data base and stores them in the address entry list.
	 * 

	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void Load() throws ClassNotFoundException, SQLException {
		/**
		 * Variable to store each row of the database and then add them to the list
		 */
		String add[]=new String[8];
		list.clear();
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:ge5329/iBBiZaQd@mcsdb1.sci.csueastbay.edu:1521/MCSDB1");
		Statement stmt = conn.createStatement ();		  
		ResultSet rset = stmt.executeQuery("select * from ADDRESSENTRYTABLE");
		/**
		 *Traverse through every row and store to the address entry list 
		 */
		while (rset.next ())
		{         for(int i=1; i<rset.getMetaData().getColumnCount(); i++) {//visit each column 
			add[i-1]=rset.getString(i);			  
		}
		add(new AddressEntry(add[0],add[1],add[2],add[3],add[4],add[5],add[6],add[7]));
		}
		conn.close();
		rset.close();
	}
}