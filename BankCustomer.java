
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
// to open a nee account
	public void addAccount(Account account)
	{
		acc.add(account);
	}
	
	
	public String csvString()
	{
		
		String str = id + "," +
				firstName + "," + 
				lastName + "," +  
				userName + "," +  
				password + "," + 
				address;
		
	
		for( Account account : acc )
		{
			// add the csv string to it
			str = str + "," + account.toString();
		}
		
		// return the return string
		return str;
	}
	
	
	public void customerInfo()
	{
		System.out.println("Customer Name     : " + lastName + ", " + firstName);
		System.out.println("Customer id       : " + id);
		System.out.println("Address           : " + address);
	}
	
	// show account details
	public void accDetails()
	{
		System.out.println("List of accounts: ");
		// for each account
		for( Account account : acc )
		{
			// account types
			System.out.println("Account type    : "+ account.getType() + " Account");
			System.out.println("Account number  : "+ account.getNumber() );
			System.out.println("Account balance : $"+ account.getBalance() );
			
			// for checking accounts
			if( account.getType().equals("Checking"))
			{
				
				CheckingAccount checking = (CheckingAccount)account;
				// show service fee
				System.out.println("Service fee     : $"+ checking.getServiceFee() );
			}
			else
			{
				//for savings account
				SavingAccount saving = (SavingAccount)account;
				// show service fee
				System.out.println("Interest rate   : "+ saving.getInterestRate() + "%");
			}
		}
	}
	
	// for customer information
	public void printInformation()
	{
		customerInfo();
		System.out.println();
		accDetails();
		System.out.println();
	}
	
	
	public Account findAccount(String accountNumber)
	{
		for( Account account : acc )
		{
			
			if( account.getNumber().equals(accountNumber))
			{
				return account;
			}
		}
		return null;
	}
