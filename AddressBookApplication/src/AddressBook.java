
public class AddressBook {
	public AddressEntry addressEntryList[]=new AddressEntry[100];
	public int i=0;
	
	public void add(AddressEntry addressEntry)
	{
		addressEntryList[i]=addressEntry;
		i++;
	}
	public void list()
	{
		for(int k=0;k<i;k++)
		{
			System.out.println(addressEntryList[k].toString());
			System.out.println("\n******************************\n");
		}
	}

}
