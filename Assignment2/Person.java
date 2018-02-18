//Name: Oluwatomilayo Adegbite
//Student ID: 500569283
import java.util.Comparator;

public class Person implements Comparable<Person>{
	
	private String lastName;
	private String firstName;
	private String telephoneNumber;
	private String email;
	private String address;
	
	/**
	 * Creates a person object using Last name, First name, telephone number, email, and address
	 * @param lastname of the person
	 * @param firstName of the person
	 * @param tel telephone number of the person
	 * @param email of the person
	 * @param address of the person
	 */
	public Person(String lastname, String firstName, String tel, String email, String address)
	{
		setLastName(lastname);
		setFirstName(firstName);
		setNumber(tel);
		setEmail(email);
		setAddress(address);
	}
	
	/**
	 * sets lastname
	 * @param lname last name of the person
	 */
	public void setLastName(String lname)
	{
		lastName = lname;
	}
	
	/**
	 * sets first name
	 * @param fname first name of the person
	 */
	public void setFirstName(String fname)
	{
		firstName = fname;
	}
	/**
	 * sets phone number 
	 * @param num number of the person
	 */
	public void setNumber(String num)
	{
		telephoneNumber = num;
	}
	/**
	 * sets persons email address
	 * @param mail the persons email address
	 */
	public void setEmail(String mail)
	{
		email = mail;
	}
	/**
	 * the address of the person
	 * @param add address of the person
	 */
	public void setAddress(String add)
	{
		address = add;
	}
	
	/**
	 * gets string last name
	 * @return the string last name
	 */
	
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * 
	 * @return string first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * 
	 * @return String phone number
	 */
	public String getPhoneNumber()
	{
		return telephoneNumber;
	}
	/**
	 * 
	 * @return String email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * 
	 * @return the address of the person
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * prints information of object depending on information present
	 */
	public String toString()
	{
		 if (telephoneNumber.equals("") && email.equals("")) return firstName + " " + lastName;
		 else if (telephoneNumber.equals(""))return firstName + " " + lastName + " " + email;
		 else if (email.equals("")) return firstName + " " + lastName + " " + telephoneNumber;
		 else return firstName + " " + lastName + " " + telephoneNumber + " " + email;
		
	}
	/**
	 * compare Person objects based on last name and first name
	 * @param Person other to compare
	 * @return 1 for true, 0 for false
	 */
	public int compareTo(Person other) 
	{
		if (this.getLastName().equals(other.getLastName()))
		{
			if (this.getFirstName().equals(other.getFirstName())) return 1;
			else return 0;
		}
		else return 0;
		
	}
	
	/**
	 * Compare person objects based on email
	 * @param other Person to compare
	 * @return 1 for true or 0 for false
	 */
	public int compareToEmail(Person other)
	{
		return new EmailCompare().compare(this, other);
	}
	/**
	 * Compare person objects based on phone number
	 * @param other person to compare
	 * @return 1 for true 0 for false
	 */
	public int compareToPhone(Person other)
	{
		return new PhoneCompare().compare(this, other);
	}
	
	/**
	 * email compare using Comparator
	 * @author Tomi
	 *
	 */
	class EmailCompare implements  Comparator<Person>
	{
		
	 public EmailCompare()
	 {
		
	 }
	 
	 public int compare(Person person1, Person person2) 
		{
			if (person1.getEmail().equals(person2.getEmail()) && (!person1.getEmail().equals("") || !person2.getEmail().equals(""))) return 1;
			else return 0;
		}
	}
	/**
	 * email compare using Comparator
	 * @author Tomi
	 *
	 */
	class PhoneCompare implements Comparator<Person>
	{

		public PhoneCompare()
		{
			
		}
		public int compare(Person person1, Person person2) {
			if (person1.telephoneNumber.equals(person2.telephoneNumber) && (!person1.telephoneNumber.equals("") || !person2.telephoneNumber.equals("") ) ) return 1;
			return 0;
		}
		
	

	}


}


