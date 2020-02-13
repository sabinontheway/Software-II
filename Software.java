import java.util.LinkedList;
import java.util.Scanner;

public class Software
{
	private LinkedList<BankCustomer> customers;
	
	// constructor
	public Software()
	{
		customers = new LinkedList<>();
	}
	
	// method to add a customer to the list
	public void addCustomer(BankCustomer bankCustomer)
	{
		customers.add(bankCustomer);
	}
	
	public LinkedList<BankCustomer> getAllCustomers()
	{
		return customers;
	}
	
	//to add a new customer
	public void addNewCustomer(Scanner scanner){
		System.out.println("Enter id : ");
		String id = scanner.nextLine();
		System.out.println("Enter first name : ");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name : ");
		String lastName = scanner.nextLine();
		System.out.println("Enter username : ");
		String username = scanner.nextLine();
		System.out.println("Enter password : ");
		String password = scanner.nextLine();
		System.out.println("Enter address : ");
		String address = scanner.nextLine();
                        
		BankCustomer bankCustomer = new BankCustomer(id, firstName, lastName, username, password, address);
		openNewAccount(scanner, bankCustomer);
		customers.add(bankCustomer);
	}
	
	// check username and password
	public BankCustomer getCustomerById(String id)
        {
		for( BankCustomer bankCustomer : customers )
		{
			// if the id matches
			if( id.equals(bankCustomer.getId()))
			{
				return bankCustomer;
			}
		}
		return null;
	}
	
	private int getCustomerIndex(String id)
	{
		int index = 0;
		for( BankCustomer bankCustomer : customers )
		{
			// if the id matches
			if( id.equals(bankCustomer.getId()))
			{
				return index;
			}
			index++;
		}
		return -1;
	}
