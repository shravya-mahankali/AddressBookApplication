
public class AddressBookApplication {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AddressBook ab=new AddressBook();
		initAddressBookExercise(ab);
	}
	public static void initAddressBookExercise(AddressBook ab)
	{
		AddressEntry adEntry1,adEntry2;
		adEntry1=new AddressEntry("Shravya", "Mahankali", "Guardian dr", "Fremont", "CA", "94538","908-240-5594","shravyamahankali@gmail.com");
		adEntry2=new AddressEntry("Shanthi", "Monica", "Gaullaudet dr", "Union city", "CA", "94555","908-240-5555","shanthimonicai@gmail.com");
		ab.add(adEntry1);
		ab.add(adEntry2);
		ab.list();
	}

}
