
import java.util.LinkedList;
import java.util.Scanner;

public class BankCustomer
{
	//variables and data types
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	
	// java linked list that keeps the list of all acc
	private LinkedList <Account> acc;

	// paramerterized constructor
	public BankCustomer(String id, String firstName, String lastName, String userName, String password, String address) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		
		// create acc list
		acc = new LinkedList<>();
	}
