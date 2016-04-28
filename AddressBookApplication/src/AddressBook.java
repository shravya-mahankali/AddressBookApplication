import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 	The AddressBook allows various operation on address entries
  
 *	@author Shravya Mahankali
 *	@version 1.0	
 *	@since 15 April 2016
 * 
 
 */

public class AddressBook {
	/**
	 * Declaring addressEntryList to store AddressEntry objects. 
	 */	
	public ArrayList<AddressEntry> addressEntryList =new ArrayList<AddressEntry>();
	/**
	 * To store all the address entries found while searching through last names.	
	 */
		public ArrayList<AddressEntry> f = new ArrayList<AddressEntry>();
	
	/**
	 * Control flow of find operation.
	 */
		private int flag=1;
	/**
	 * To take user inputs	
	 */
		Scanner sc= new Scanner(System.in);
	/**
	 * Store total number of address entries found
	 */
		private int num;
	
	/**
	 * This method adds an address entry to addressEntry list taking addressEntry as argument and sorts them on basis of First name.
	 * @param addressEntry
	 */
	public void add(AddressEntry addressEntry)
	{
		
		// adding AddressEntry objects to the list
		 
		addressEntryList.add(addressEntry);

		/*
		 * To sort the list of AddressEntry object based on the first name.
		 */
		Collections.sort(addressEntryList, new Comparator<AddressEntry>(){
			public int compare(AddressEntry s1, AddressEntry s2){
				return s1.getLastName().compareToIgnoreCase(s2.getLastName());
			}
			});
		
	}
	/**
	 * This method used to display all the address entries in the list
	 
	 */
	public void List()
	{
		
		for(int k=0;k<addressEntryList.size();k++)
		{
			System.out.println(addressEntryList.get(k).toString());
			System.out.println("\n******************************\n");
		}
	}
	/**
	 * This method removes an address entry when searched through last name.
	 * @param LastName
	 */
	public void remove(String LastName){
		num=0;
		flag=0;
		/**
		 * it calls find to get the required address entries
		 */
		find(LastName);
		flag=1;num=0;
		System.out.println("The following "+f.size()+" entries were found in the address book, select number of entry you wish to remove");
		for(int i=0;i<f.size();i++){
			System.out.println((++num)+": "+f.get(i).toString());
		}			

		if(num!=0){
		num=sc.nextInt();
		System.out.println("Hit y to remove the following entry or n to return to main menu");		
/**
 * if user enters Y then the required address entry is removed
 */
		if(sc.next().equalsIgnoreCase("y")){
			System.out.println("You have successfully removed the "+f.get(--num).getFirstName()+" "+f.get(num).getLastName()+" contact");
			addressEntryList.remove(f.get(num));}
		else if(sc.nextLine().equalsIgnoreCase("n"))
			System.out.println("No entry were removed");
		}
	}
	/**
	 * This method finds a list of address entries starting from the given alphabets 
	 * @param LastName
	 * @return ArrayList<AddressEntry>
	 */
	public ArrayList<AddressEntry> find(String LastName){
		num=0;
		if(flag==0){				
		for(int i=0;i<addressEntryList.size();i++){
			if(addressEntryList.get(i).getLastName().equalsIgnoreCase(LastName)){
				f.add(addressEntryList.get(i));	num++;	}}

		}
		/**
		 * searches and displays number of address entries found
		 */
		else{
			for(int i=0;i<addressEntryList.size();i++){
				if(addressEntryList.get(i).getLastName().toLowerCase().startsWith(LastName.toLowerCase())){
					f.add(addressEntryList.get(i));	num++;
				}
			}
		System.out.println("The following "+num+" entries were found for a last name "
				+ "starting with "+LastName);
		num=1;
		for(int i=0;i<f.size();i++)
				System.out.println((num++)+": "+f.get(i).toString());}						
	return f;
	}
	/**
	 * This method writes the list of address entries from the required file
	 * @param filename
	 * @throws IOException
	 */
	public void FileWrite(String filename) throws IOException{
		File file=new File(filename);
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		for(int i=0;i<addressEntryList.size();i++){
		bw.write(addressEntryList.get(i).toFile());
		bw.newLine();
		}	
		bw.close();
	}
	/**
	 * This method clears the find list. This is necessary before a new search.
	 */
	public void clearFindList(){
		f.clear();
	}
	/**
	 * This method reads in the list of address entries from a given file
	 * @param filename
	 * @throws IOException
	 */
	public void FileRead(String filename) throws IOException {
		// TODO Auto-generated method stub
		int num=0;
		/**
		 * add[] is used to store each field of a particular address entry 
		 */
		String add[]=new String[8];
		/*
		 * creating BufferedReader object to read the text file.
		 */
		BufferedReader br=new BufferedReader(new FileReader(filename));
		/*
		 * Traversing through each line till the end of file 
		 */
		for(int i=0;(add[i]=br.readLine())!=null;i++){	
			if(i==7){
				/**
				 * adding a new AddressEntry object to the list in AddressBook class.
				 */
				++num;
				add(new AddressEntry(add[0],add[1],add[2],add[3],add[4],add[5],add[6],add[7]));
				i=-1;
			}
		}br.close();
		System.out.println("Have read "+num+" new addresses, successfully loaded, Current number of adresses is "
				+ num);
	}

}
