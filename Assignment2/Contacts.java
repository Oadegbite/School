//Name: Oluwatomilayo Adegbite
//Student ID: 500569283
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class Contacts {

	private LinkedList<Person> contactList;
	private Scanner scanner;
	
	/**
	 * creats link list
	 */
	public Contacts() 
	{
		 contactList = new LinkedList<Person>();
	}
	/**
	 * looks through LinkedList to return person with matching email
	 * @param other person
	 * @return matched person
	 */
	public Person findPersonEmail(Person other)
	{
		for (Person s : contactList)
		{
			if (s.compareToEmail(other) == 1) return s;
		}
		return null;
	}
	/**
	 * looks through LinkedList to return person with matching phoneNumber
	 * @param other person to match
	 * @return matched person
	 */
	public Person findPersonPhone(Person other)
	{
		for (Person s : contactList)
		{
			if (s.compareToPhone(other) == 1) return s;
		}
		return null;
	}
	
	/**
	 * looks through LinkedList to return person with matching last name 
	 * @param other person to match
	 * @return matched person
	 */
	public Person findPersonLastName(Person other)
	{
		for (Person s : contactList)
		{
			if (s.compareTo(other) == 1) return s;
		}
		return null;
	}
	
	/**
	 * looks through LinkedList to return person with matching first name 
	 * @param other person to match
	 * @return matched person
	 */
	public Person findPersonfirstName(Person other)
	{
		for (Person s : contactList)
		{
			if (s.compareTo(other) == 1) return s;
		}
		return null;
	}
	
	
	/**
	 * Read a file and add contact information to linked list of Persons
	 * @param fname file name to read
	 * @return LinkedList of the contacts read
	 * @throws FileNotFoundException in case file not found
	 * @throws IllegalArgumentException if first number is not present
	 * @throws Exception issues reading the file
	 */
	public LinkedList<Person> readContactsFile(String fname) throws FileNotFoundException, IllegalArgumentException, Exception 
	{
		
		scanner = new Scanner(new File(fname));
		if (!scanner.hasNextInt()) throw new IllegalArgumentException();
		int lines = 0; 
		int contactAmount = Integer.parseInt(scanner.nextLine());
		while (scanner.hasNextLine())
		{
			scanner.nextLine();
			lines++;
		}
		scanner = new Scanner(new File(fname));
		scanner.nextLine();
		
		
		for (int i = 0; i < contactAmount ; i++)
		{
			String lastName = scanner.nextLine();
			String firstName = scanner.nextLine();
			String address = scanner.nextLine();
			String telephone = scanner.nextLine();
			String email = scanner.nextLine();
			
			contactList.add(new Person(lastName, firstName, telephone, email ,address));
			
		}
		
		for(Person s : contactList)
		{
			if (s.getLastName().equals("") || s.getEmail().equals("") || lines % 5 != 0 )
			{
				contactList.clear();
				
				throw new Exception("Could not read contactfile");
			}
		}
		
		scanner.close();
		return contactList;
		
		
	}
	
	
}
