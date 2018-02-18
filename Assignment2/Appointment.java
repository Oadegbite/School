//Name: Oluwatomilayo Adegbite
//Student ID: 500569283

//Import calls
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Appointment class implements Comparable<Appointment> to organize the ArrayList
public class Appointment implements Comparable<Appointment> {
	
	// global variables
	private Calendar date;
	private String discription;
	private SimpleDateFormat sdf;
	private Person contact;
	
	/**
	 * Appointment constructor to make new Appointment on a time and day with a description of the event as a string and format of time
	 * @param year the appointment falls on and passes to the setYear method
	 * @param month the appointment falls on and passes to the setMontth method
	 * @param day the day of the month the appointment falls on and passes it to the setDay method
	 * @param hour hour according to the 24 hour clock and passes it to the setHour method
	 * @param mins the time the appointment falls on and passes it to the setMins method
	 * @param discription a description of the event sets it to global variable description
	 * @param person the appointment is with
	 */
	public Appointment(int year, int month, int day, int hour, int mins, String discription, Person per)
	{	
		date = new GregorianCalendar();
		setYear(year);
		setMonth(month);
		setDay(day);
		setHour(hour);
		setMins(mins);
		this.discription = discription;
		sdf = new SimpleDateFormat("HH:mm");
		setContact(per);
	}
	/**
	 * 
	 * @return the person the appointment is with
	 */
	public Person getContact()
	{
		return contact;
	}
	/**
	 * getDesciption of the Appointment
	 * @return the String with the description
	 */
	public String getDescription()
	{
		return this.discription;
	}
	
	/**
	 * sets the year the Appointment falls on in the Calendar date object
	 * @param year 
	 */
	public void setYear(int year)
	{
		date.set(Calendar.YEAR, year);
	}
	/**
	 * sets contact 
	 * @param person object the appointment is with
	 */
	public void setContact(Person per)
	{
		contact = per;
	}
	/**
	 * sets the day the Appointment falls on in the Calendar date object
	 * @param day 
	 */
	public void setDay(int day)
	{
		date.set(Calendar.DAY_OF_MONTH, day);
	}
	
	/**
	 * sets the month the Appointment falls on in the Calendar date object
	 * @param month 
	 */
	public void setMonth(int month)
	{
		date.set(Calendar.MONTH, month);
	}
	/**
	 *  sets the hour the Appointment falls on in the Calendar date object
	 * @param hour
	 */
	public void setHour(int hour)
	{
		date.set(Calendar.HOUR_OF_DAY, hour);
	}
	
	/**
	 * sets the mins the Appointment falls on in the Calendar date object
	 * @param mins 
	 */
	public void setMins(int mins)
	{
		date.set(Calendar.MINUTE, mins);
	}
	
	/**
	 * 
	 * @return the year stored in the Calendar date object
	 */
	public int getYear()
	{
		return date.get(Calendar.YEAR);
	}
	/**
	 * 
	 * @return the day stored in the Calendar date object
	 */
	public int getDay()
	{
		return date.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 
	 * @return the month stored in the Calendar date object
	 */
	public int getMonth()
	{
		return date.get(Calendar.MONTH);
	}
	
	/**
	 * 
	 * @return the hour stored in the Calendar date object in 24 hour clock format
	 */
	public int getHour()
	{
		return date.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 
	 * @return the mins stored in the Calendar date object
	 */
	public int getMins()
	{
		return date.get(Calendar.MINUTE);
	}
	/**
	 * 
	 * @return a Calendar object with the full date stored in the Calendar date object used inside the class for the compareTo method
	 */
	public Calendar getDate()
	{
		return date;
	}
	
	/**
	 *  Overrides the toString method of object to print the Appointments time in HH:mm format with the description
	 * @return a String of the time and description
	 */
	public String toString()
	{
		String out = sdf.format(date.getTime()) + " " + this.getDescription();
		return out;
	}
	
	/**
	 * Compares values to see if the current appointment falls on a certain day and time 
	 * @param year to check if the appointment falls on
	 * @param month to check if the appointment falls on
	 * @param day to check if the appointment falls on
	 * @param hour to check if the appointment falls on
	 * @param minute to check if the appointment falls on
	 * @return true or false if the Appointment matches the values
	 */
	public boolean occursOn(int year, int month, int day, int hour, int minute)
	{
		if (this.getYear() == year && this.getMonth() == month && this.getDay() == day && this.getHour() == hour && this.getMins() == minute) return true;
		
		else return false;
	}
	
	/**
	 * Compares Appointment objects using their dates to check which one comes first to sort the ArrayList using Collections.sort()
	 * @param Appointment another appointment object to compare
	 */
	public int compareTo(Appointment other)
	{
		return this.getDate().compareTo(other.getDate());
	}
	
}
