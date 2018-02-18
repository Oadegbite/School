
public class PhoneComapre implements Comparable<Person>{

	public boolean compareTo(Person person1, Person person2)
	{
		if (person1.getPhoneNumber().equals(person2.getPhoneNumber())) return true;
		else return false;
		
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
