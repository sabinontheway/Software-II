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
				// show limit and service fee
				System.out.println("Limit Amount    : $"+ checking.getLimit());
				System.out.println("Service fee     : $"+ checking.getServiceFee() );
			}
			else
			{
				//for savings account
				SavingAccount saving = (SavingAccount)account;
				// show limit and service fee
				System.out.println("Limit Amount    : $"+ saving.getLimit() );
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
	
	// to check balance
	public void checkBal(Scanner scanner)
	{
		// ask for account number
		System.out.print("Enter account number : ");
		
		// read account number
		String accountNumber = scanner.nextLine();
		
		if( findAccount(accountNumber) == null )
			System.out.println("Account with number " + accountNumber + " not found!");
		else
		{
			// show
			Account account = findAccount(accountNumber);
			System.out.println("Account type    : "+ account.getType() + " Account");
			System.out.println("Account number  : "+ account.getNumber() );
			System.out.println("Account balance : $"+ account.getBalance() );
		}
	}
	
	//  to deposit
	public void deposit(Scanner scanner)
	{
		// ask for account number
		System.out.print("Enter account number : ");
		
		// read account number
		String accountNumber = scanner.nextLine();
		
		if( findAccount(accountNumber) == null )
		{
			System.out.println("Account with number " + accountNumber + " not found!");
			return;
		}
		
		// the account to deposit to
		Account account = findAccount(accountNumber);
		
		// ask for amount
		System.out.print("Enter amount to deposit : ");
		float depositAmount =  Float.parseFloat( scanner.nextLine() );
		System.out.println("Account type    : "+ account.getType() + " Account");
		System.out.println("Account number  : "+ account.getNumber() );
		System.out.println("Account balance : $"+ account.getBalance() );
		
		
		System.out.println();
		
		
		account.desposit(depositAmount);
		// show deposit amount and new balance
		System.out.println("Deposit amount  : $" + depositAmount);
		System.out.println("New Balance     : $" + account.getBalance());
		
	}
	
	// to withdraw
	public void withdraw(Scanner scanner)
	{
		
		System.out.print("Enter account number : ");
		String accountNumber = scanner.nextLine();
		
		if( findAccount(accountNumber) == null )
		{
			System.out.println("Account with number " + accountNumber + " not found!");
			return;
		}
		
		
		Account account = findAccount(accountNumber);
		
		
		System.out.print("Enter amount to withdraw : ");
		float withdrawAmount =  Float.parseFloat( scanner.nextLine() );
		
		
		System.out.println("Account type    : "+ account.getType() + " Account");
		System.out.println("Account number  : "+ account.getNumber() );
		System.out.println("Account balance : $"+ account.getBalance() );
		System.out.println();
		System.out.print("Withdraw amount : $" + withdrawAmount);
		
		// deposit
		boolean success = account.withdraw(withdrawAmount);
		// if success
		if( success )
		{
			// show new balance
			System.out.println("\nNew Balance     : $" + account.getBalance());
		}
		else
		{
			// show denied
			System.out.println("  - denied");
			System.out.println("Current Balance : $" + account.getBalance());
		}
		
	}
	
	// method to print
	public void printMonthlyStatement(Scanner scanner)
	{
		
		System.out.print("Enter account number : ");
		String accountNumber = scanner.nextLine();
		
		if( findAccount(accountNumber) == null )
		{
			System.out.println("Account with number " + accountNumber + " not found!");
			return;
		}
		Account account = findAccount(accountNumber);		
		System.out.println("Account Name     : " + lastName + ", " + firstName);
		account.printMonthlyStatement();
	}
	
	public void printMonthlyStatement()
	{
		
		System.out.println("Account Name     : " + lastName + ", " + firstName);
		for (Account account : acc )
		{
			account.printMonthlyStatement();
			System.out.println();
		}
	}
	
	// to remove account with this id
	public void removeAccount(String accountNumber)
	{
		// the index
		int index = 0;
		for( Account account : acc )
		{
			// if this is the account number
			if( account.getNumber().equals(accountNumber))
			{
				break;
			}
			index++;
		}
		acc.remove(index);
	}

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	// to get the number of acc
	public int getNumAccounts()
	{
		return acc.size();
	}

	public LinkedList<Account> getAccounts() {
		return acc;
	}
	
	
}
		 


