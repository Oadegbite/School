//Name: Oluwatomilayo Adegbite
//Student ID: 500569283

//Import statements
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Stack;

//Appointment Frame subclass of JFrame
public class AppointmentFrame extends JFrame{
	
	//Creation of all needed global variables
	private static final int FRAME_WIDTH = 850;
	private static final int FRAME_HEIGHT = 900;
	private static final int FIELD_WIDTH = 2;
	private Calendar date;
	private ArrayList<Appointment> appointments; 
	private SimpleDateFormat outDate = new SimpleDateFormat("EEE, MMM dd, yyyy");
	private LinkedList<Person> contactList;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField yearField;
	private JTextField hourField;
	private JTextField minsField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JLabel mainDate;
	private JScrollPane appScroll;
	private JTextArea appointmentsView;
	private JTextArea descriptionField;
	private JTextArea addressArea;
	private Stack<Appointment> recallStack;
	private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	private JLabel monthLabel;
	private JPanel monthCalander;

	/**
	 * Appointment Frame constructor
	 * creates objects for the ArrayList
	 * Calendar and labels for formating
	 * also calls the CreateMainArea() to create the action,date, and description frames
	 * crates the JTextArea to display the appointments ArrayList and places in JScrollPane
	 * Sets the frame height and width and creates several Appointments
	 * Prints the current appointments in the array list
	 * 
	 */
	public AppointmentFrame() {
		
		appointments = new ArrayList<Appointment>();
		recallStack = new Stack<Appointment>();
		
		date = new GregorianCalendar();
	    mainDate = new JLabel(outDate.format(date.getTime()));
	    monthLabel = new JLabel(monthFormat.format(date.getTime()));
		createMainArea();
		appointmentsView = new JTextArea();
		appScroll = new JScrollPane(appointmentsView);
		appointmentsView.setEditable(false);
		createMonthView();
		JPanel subMain = new JPanel();
		JPanel subDates = new JPanel();
		subDates.setLayout(new GridLayout(1,2));
		subMain.setLayout(new GridLayout(1,2));
		subDates.add(mainDate);
		subDates.add(monthLabel);
		subMain.add(appScroll);
		subMain.add(monthCalander);
		add(subMain, BorderLayout.CENTER);
		add(subDates, BorderLayout.NORTH);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		importContacts();
		
		Person tomi = new Person("Adegbite", "Tomi", "647-835-2598", "Oadegbite@ryerson.ca", "23 Catchfly cres");
		
		Appointment app1 = new Appointment(date.get(Calendar.YEAR), date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH),11,11, "Assignment 1",tomi);
		Appointment app2 = new Appointment(date.get(Calendar.YEAR), date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH),10,15, "Hackathon",tomi);
		Appointment app3 = new Appointment(date.get(Calendar.YEAR), date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH),9,15, "Party Hard",tomi);
		recallStack.push(app1);
		recallStack.push(app2);
		recallStack.push(app3);
		appointments.add(app1);
		appointments.add(app2);
		appointments.add(app3);
		printAppointments();
		
	}
	
	
	/**
	 * Creates the action,date, and description frames
	 * add them to a panel with a gird layout to organize
	 * add it the the main AppointmentFrame and organizes it to the south
	 */
	public void createMainArea()
	   {
	      JPanel datePanel = createDateArea();
	      JPanel actionPanel = createActionArea();
	      JPanel descriptionPanel = createDescriptionArea();
	      JPanel contactPanel = createContactArea();
	      
	      JPanel mainPanel = new JPanel();
	      
	      mainPanel.setLayout(new GridLayout(2, 2));
	      mainPanel.add(datePanel);
	      mainPanel.add(contactPanel);
	      mainPanel.add(actionPanel);
	      mainPanel.add(descriptionPanel);
	      

	      add(mainPanel, BorderLayout.SOUTH);
	      
	      
	   }

	/**
	 * Creates the date JPanel all the JButtons and JLabels that go inside initializes and attaches the ActionListeners to the buttons and sets their text and the layout
	 * @return the finished Date JPanel
	 */
	public JPanel createDateArea()
	{
		JPanel datePanel = new JPanel();
		JButton leftB = new JButton("<");
		JButton rightB = new JButton(">");
		ActionListener nextDay = new addDay();
		ActionListener previousDay = new subtractDay();
		ActionListener changeDay = new showDate();
		JButton showB = new JButton("Show");
		JLabel dayL = new JLabel("Day ");
		JLabel monthL = new JLabel("Month ");
		JLabel yearL = new JLabel("Year ");
		dayField = new JTextField(FIELD_WIDTH);
		monthField = new JTextField(FIELD_WIDTH);
		yearField = new JTextField(FIELD_WIDTH + 3);
		datePanel.setLayout(new GridLayout(3, 1));
		
		JPanel scrollSubPanel = new JPanel();
		rightB.addActionListener(nextDay);
		leftB.addActionListener(previousDay);
		scrollSubPanel.setLayout(new GridLayout(1, 1));
		scrollSubPanel.add(leftB,BorderLayout.NORTH);
		scrollSubPanel.add(rightB, BorderLayout.NORTH);
		
		JPanel dateSubPanel = new JPanel();
		dateSubPanel.add(dayL);
		dateSubPanel.add(dayField);
		dateSubPanel.add(monthL);
		dateSubPanel.add(monthField);
		dateSubPanel.add(yearL);
		dateSubPanel.add(yearField);
		
		JPanel showSubPanel = new JPanel();
		showB.addActionListener(changeDay);
		showSubPanel.add(showB);
		
		datePanel.add(scrollSubPanel, BorderLayout.NORTH);
		datePanel.add(dateSubPanel, BorderLayout.CENTER);
		datePanel.add(showSubPanel);
		datePanel.setBorder(new TitledBorder(new EtchedBorder(), "Date"));
		
		return datePanel;
		
	}
	
	/**
	 * Creates the Action JPanel all the JButtons and JLabels that go inside initializes and attaches the ActionListeners to the buttons and sets their text and the layout
	 * @return the finished Action JPanel
	 */
	public JPanel createActionArea()
	{
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new GridLayout(2,1));
		ActionListener create = new createAppointment();
		ActionListener cancel = new cancelAppointment();
		ActionListener recall = new recallAppointment();
		JLabel hourL = new JLabel("Hour");
		JLabel minsL = new JLabel("Minute");
		JButton createB = new JButton("Create");
		JButton cancelB = new JButton("Cancel");
		JButton recallB = new JButton("Recall");
		hourField = new JTextField(FIELD_WIDTH + 2);
		minsField = new JTextField(FIELD_WIDTH + 2);
		JPanel timeSubPanel = new JPanel();
		JPanel buttonSubPanel = new JPanel();
		createB.addActionListener(create);
		cancelB.addActionListener(cancel);
		recallB.addActionListener(recall);
		timeSubPanel.add(hourL);
		timeSubPanel.add(hourField);
		timeSubPanel.add(minsL);
		timeSubPanel.add(minsField);
		buttonSubPanel.add(createB);
		buttonSubPanel.add(cancelB);
		buttonSubPanel.add(recallB);
		
		actionPanel.add(timeSubPanel);
		actionPanel.add(buttonSubPanel);
		
		actionPanel.setBorder(new TitledBorder(new EtchedBorder(), "Appointment"));
		
		return actionPanel;
		
	}
	
	public void createMonthView()
	{
		monthCalander = new JPanel();
		GridLayout layout = new GridLayout(6,7);
		monthCalander.setLayout(layout);
		JLabel sunLabel = new JLabel("Sun");
		JLabel monLabel = new JLabel("Mon");
		JLabel tueLabel = new JLabel("Tue");
		JLabel wedLabel = new JLabel("Wed");
		JLabel thuLabel = new JLabel("Thu");
		JLabel friLabel = new JLabel("Fri");
		JLabel satLabel = new JLabel("Sat");
		monthCalander.add(sunLabel);
		monthCalander.add(monLabel);
		monthCalander.add(tueLabel);
		monthCalander.add(wedLabel);
		monthCalander.add(thuLabel);
		monthCalander.add(friLabel);
		monthCalander.add(satLabel);
		int current = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= current; i++ )
		{
			JButton button = new JButton( Integer.toString(i));
			ActionListener press = new monthButton(i);
			button.addActionListener(press);
			monthCalander.add(button);
			
		}
		
		
	}
	
	/**
	 * creates the JPanel for the Description area initializes the JTextArea
	 * @return the Description JPanel
	 */
	public JPanel createDescriptionArea()
	{
		JPanel descriptionPanel = new JPanel();
		JButton clearB = new JButton("Clear");
		ActionListener clear = new clearDescription();
		clearB.addActionListener(clear);
		descriptionField = new JTextArea();
		descriptionField.setPreferredSize(new Dimension(FRAME_WIDTH/3, FRAME_HEIGHT /10));
		
		descriptionPanel.setLayout(new GridLayout(2,1));
		descriptionPanel.add(descriptionField);
		descriptionPanel.add(clearB);
		descriptionPanel.setBorder(new TitledBorder(new EtchedBorder(), "Description"));
		
		return descriptionPanel;
		
	}
	/**
	 * creates the JPanel for the Contact are creates new JTExtFields and JText area attaches buttons and ActionListeners
	 * @return the Contact JPanel
	 */
	public JPanel createContactArea()
	{
		
		JPanel contactPanel = new JPanel();
		contactPanel.setLayout(new GridLayout(4,1));
		
		ActionListener find = new findContact();
		ActionListener clear = new clearContacts();
		
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel firstNameLabel = new JLabel("First Name");
		JLabel phoneNumberLabel = new JLabel("Telephone #");
		JLabel emailLabel = new JLabel("Email");
		JLabel addressLabel = new JLabel("Address");
		
		lastNameField = new JTextField(FIELD_WIDTH);
		firstNameField = new JTextField(FIELD_WIDTH);
		phoneNumberField = new JTextField(FIELD_WIDTH);
		emailField = new JTextField(FIELD_WIDTH);
		addressArea = new JTextArea();
		
		JButton findB = new JButton("Find");
		JButton clearB = new JButton("Clear");
		findB.addActionListener(find);
		clearB.addActionListener(clear);
		
		JPanel namesPanel = new JPanel();
		namesPanel.setLayout(new GridLayout(2,2));
		namesPanel.add(lastNameLabel);
		namesPanel.add(firstNameLabel);
		namesPanel.add(lastNameField);
		namesPanel.add(firstNameField);
		
		JPanel telEmailPanel = new JPanel();
		telEmailPanel.setLayout(new GridLayout(2,2));
		telEmailPanel.add(phoneNumberLabel);
		telEmailPanel.add(emailLabel);
		telEmailPanel.add(phoneNumberField);
		telEmailPanel.add(emailField);
		
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new GridLayout(2,1));
		addressPanel.add(addressLabel);
		addressPanel.add(addressArea);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(findB);
		buttonPanel.add(clearB);
		
		contactPanel.add(namesPanel);
		contactPanel.add(telEmailPanel);
		contactPanel.add(addressPanel);
		contactPanel.add(buttonPanel);
		contactPanel.setBorder(new TitledBorder(new EtchedBorder(), "Contact"));
		return contactPanel;
	}
	
	/**
	 * Creates an appointment object using the Calendar objects Year, Month, and Day and uses user input time and Description
	 * Also checks if an appointment exists at that time already using the findAppointment method
	 * creates a new person objects if feilds are full or creates an appointment with a null person 
	 */
	public void createAppointment() throws IllegalArgumentException
	{
		int mins = 0;
		int hours = Integer.parseInt(hourField.getText());
		if (!minsField.getText().isEmpty()) mins = Integer.parseInt(minsField.getText());
		int day = date.get(Calendar.DAY_OF_MONTH);
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		String description = descriptionField.getText();
		String lastName = lastNameField.getText();
		String firstName = firstNameField.getText();
		String tel = phoneNumberField.getText();
		String email = emailField.getText();
		String address = addressArea.getText();
		if (mins < 0 || mins > 59) throw new IllegalArgumentException();
		if (hours < 0 || hours > 23) throw new IllegalArgumentException();
		if (findAppointment(year, month, day, hours, mins) != null)
		{
			descriptionField.setText("CONFILICT!!");
		}
		else 
		{
			Person contact = new Person(lastName, firstName, tel, email, address);
			Appointment newApp;
			if (lastName.equals("") || firstName.equals("") || address.equals(""))
			{
				 newApp = new Appointment(year, month, day, hours, mins, description, null);
			}
			else
			{
			 newApp = new Appointment(year, month, day, hours, mins, description, contact);
			}
			appointments.add(newApp);
			recallStack.push(newApp);
			hourField.setText("");
			minsField.setText("");
			descriptionField.setText("");
			lastNameField.setText("");
			firstNameField.setText("");
			phoneNumberField.setText("");
			emailField.setText("");
			addressArea.setText("");
		}
	}
	/**
	 * Checks through the entire ArrayList sorts by date and prints all the appointments that land on the same Year, Month, and Day as the Calendar object
	 *
	 */
	public void printAppointments()
	{
		String out = "";
		Collections.sort(appointments);
		for (Appointment s : appointments)
		{
			if (s.getYear() == date.get(Calendar.YEAR) && s.getMonth() == date.get(Calendar.MONTH) && s.getDay() == date.get(Calendar.DAY_OF_MONTH))
			{
				if (s.getContact() == null)
				{
					out += s.toString() + "\n\n";
				}
				else
				{
				out += s.toString() + " WITH " + s.getContact().toString() + "\n\n";
				}
			}
		}
		appointmentsView.setText(out);
	}
	
	/**
	 * Using a Year, Month, Day, Hour, and Minute checks the ArrayList for a Appointment Object matching the values
	 * @param year the appointment occurs on
	 * @param month the appointment occurs on
	 * @param day the appointment occurs on
	 * @param hour the appointment occurs on
	 * @param minute the appointment occurs on
	 * @return null if no appointment is found and the appointment object in the ArrayList if found
	 */
	public Appointment findAppointment(int year, int month, int day, int hour, int minute)
	{
		Appointment out = null;
		
		for (Appointment s : appointments)
		{
			if (s.occursOn(year, month, day, hour, minute))
			{
				out = s;
			}
			
		}
		return out;
	}
	/**
	 * Checks the ArrayList to try find an Appointment on the same Year, Month, and Day as the Calendar object and that matches the user input time
	 * if found the appointment object is removed from the ArrayList
	 */
	public void cancelAppointment()
	{
		int mins = 0;
		int hours = Integer.parseInt(hourField.getText());
		if (!minsField.getText().isEmpty()) mins = Integer.parseInt(minsField.getText());
		int day = date.get(Calendar.DAY_OF_MONTH);
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		if (findAppointment(year, month, day, hours, mins) != null)
		{
			appointments.remove(findAppointment(year, month, day, hours, mins));
			lastNameField.setText("");
			firstNameField.setText("");
			phoneNumberField.setText("");
			emailField.setText("");
			addressArea.setText("");
			hourField.setText("");
			minsField.setText("");
			descriptionField.setText("");
			recallStack.pop();
		}
		
	}
	/**
	 * imports contacts into a linked list using the Contacts class to read files
	 * catches FileNotFoundExcption if not such file
	 * catches IllegalArgument if first line of contact file is not a number
	 * catches Exception if error reading contact file
	 */
	public void importContacts()
	{
		
		Contacts contact = new Contacts();
		
		try 
		{
			contactList = contact.readContactsFile("contacts.txt");
		}
		catch (FileNotFoundException e) 
		{
			descriptionField.setText("No Contact list not found");
			contactList = null;
		}
		catch (IllegalArgumentException e) 
		{
			descriptionField.setText("Not vaild first line");
		}
		catch (Exception e)
		{
			descriptionField.setText("Error reading contact file");
		}
		
	}
	/**
	 * ActionListener for the ">" Button to add a day to the current day in the Calendar object and updates the label and prints any appointments that occur on that day
	 * 
	 */
	class addDay implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			date.add(Calendar.DAY_OF_WEEK, 1);
			mainDate.setText(outDate.format(date.getTime()));
			monthLabel.setText(monthFormat.format(date.getTime()));
			printAppointments();
			createMonthView();
		}
	}
	
	/**
	 * ActionListener for the "<" Button to subtracts a day to the current day in the Calendar object and updates the label and prints any appointments that occur on that day
	 * 
	 */
	class subtractDay implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			date.add(Calendar.DAY_OF_WEEK, -1);
			mainDate.setText(outDate.format(date.getTime()));
			monthLabel.setText(monthFormat.format(date.getTime()));
			printAppointments();
			createMonthView();
		}
	}
	
	/**
	 * ActionListener for the "Show" Button to change the current Year, Month, and Day value according to user input and updates the label and prints any appointments that occur on that day
	 * 
	 */
	class showDate implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
			int day = Integer.parseInt(dayField.getText());
			int month = Integer.parseInt(monthField.getText());
			if (month < 1 || month > 12) throw new IllegalArgumentException();
			
			date.set(Calendar.YEAR, Integer.parseInt(yearField.getText()));
			date.set(Calendar.MONTH, month -1);
			if (day < 1 || day > date.getActualMaximum(Calendar.DAY_OF_MONTH)) throw new IllegalArgumentException();
			date.set(Calendar.DAY_OF_MONTH, day);
			mainDate.setText(outDate.format(date.getTime()));
			monthLabel.setText(monthFormat.format(date.getTime()));
			printAppointments();
			dayField.setText("");
			monthField.setText("");
			yearField.setText("");
			}
			catch (IllegalArgumentException e)
			{
				descriptionField.setText("Invlaid date");
			}
		}
	}

	/**
	 * ActionListener for the "Create" Button runs the create Appointment Method and the printAppointment methods
	 */
	class createAppointment implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try{
			createAppointment();
			printAppointments();
			}
			catch (IllegalArgumentException e)
			{
				descriptionField.setText("Invalid Input");
			}
			
		}
	}
	
	/**
	 * ActionListener for the "Cancel" Button runs the create Appointment Method and the printAppointment methods
	 */
	class cancelAppointment implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
			cancelAppointment();
			printAppointments();
			}
			catch (NumberFormatException e)
			{
				
			}
			
		}
	}
	
	/**
	 * to change date using buttons
	 * @author Tomi
	 *
	 */
	class monthButton implements ActionListener
	{
		int day;
		/**
		 * 
		 * @param i the number of the button
		 */
		public monthButton (int i)
		{
			day = i;
		}
		/**
		 * sets day to day on button
		 */
		public void actionPerformed(ActionEvent event)
		{
			date.set(Calendar.DAY_OF_MONTH, day);
			mainDate.setText(outDate.format(date.getTime()));
			printAppointments();
		}
	}
	
	
	/**
	 * recalls appointment from the stack and changes the day to that appointment catches exception if no contact
	 * @author Tomi
	 *
	 */
	class recallAppointment implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
			Appointment recalled = recallStack.peek();
			
			date.set(Calendar.YEAR, recalled.getYear());
			date.set(Calendar.MONTH, recalled.getMonth());
			date.set(Calendar.DAY_OF_MONTH, recalled.getDay());
			mainDate.setText(outDate.format(date.getTime()));
			
			printAppointments();
			
			hourField.setText(Integer.toString(recalled.getHour()));
			minsField.setText(Integer.toString(recalled.getMins()));
			
			descriptionField.setText(recalled.getDescription());
			lastNameField.setText(recalled.getContact().getLastName());
			firstNameField.setText(recalled.getContact().getFirstName());
			phoneNumberField.setText(recalled.getContact().getPhoneNumber());
			emailField.setText(recalled.getContact().getEmail());
			addressArea.setText(recalled.getContact().getAddress());
			}
			catch (NullPointerException e)
			{
				
			}
			catch (EmptyStackException e)
			{
				descriptionField.setText("No More appointments");
			}
		}
	}
	
	/**
	 * searches contact list to find person
	 * @author Tomi
	 *
	 */
	class findContact implements ActionListener
	{
		/**
		 * creates a new person object to compare to person objects in contact list to find the matching information
		 * catches NullPointerException when contact list is empty
		 */
		public void actionPerformed(ActionEvent event)
		{
			try{
			Person findperson = new Person(lastNameField.getText(), firstNameField.getText(), phoneNumberField.getText(), emailField.getText(), addressArea.getText());
			for (Person s : contactList)
			{
				
				if (s.compareTo(findperson) == 1 || s.compareToEmail(findperson) == 1 || s.compareToPhone(findperson) ==1 )
				{
					lastNameField.setText(s.getLastName());
					firstNameField.setText(s.getFirstName());
					phoneNumberField.setText(s.getPhoneNumber());
					emailField.setText(s.getEmail());
					addressArea.setText(s.getAddress());
					return;
				}
				else if (s.compareTo(findperson) == 0) descriptionField.setText("Not found");
			}
			}
			catch (NullPointerException e)
			{
				descriptionField.setText("No Contact List");
			}
		}
	}
	
	/**
	 * clears contacts feilds
	 * @author Tomi
	 *
	 */
	class clearContacts implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			lastNameField.setText("");
			firstNameField.setText("");
			phoneNumberField.setText("");
			emailField.setText("");
			addressArea.setText("");
		}
	}
	
	/**
	 * clears Description area
	 * @author Tomi
	 *
	 */
	class clearDescription implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			descriptionField.setText("");
		}
	}
}
