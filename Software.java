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
	// find customer by user ID password
	public BankCustomer getCustomerByUserPassword(String user,String password)
	{
		// check all customers
		for( BankCustomer bankCustomer : customers )
		{
			// if the id matches
			if( user.equals(bankCustomer.getUserName()) && password.equals(bankCustomer.getPassword()))
			{
				return bankCustomer;
			}
		}
		return null;
	}
	
	// display a customer with all account
	public void displayCustomerAllAccounts(Scanner scanner)
	{
		System.out.println("Enter id : ");
		String id = scanner.nextLine();
		
		// check if the customer is found
		BankCustomer customer = getCustomerById(id);
		
		// // if this is null
		if( customer == null )
		{
			// show message customer not found
			System.out.println("Customer with id " + id + " does not exist");
		}
		else
		{
			// start customer menu with this customer
			customer.printInformation();
		}
	}
	// method to read one account
	public void readOneAccountOfCustomer(Scanner scanner)
	{
		int type = BankService.getCustomerLoginInput(scanner);
		if( type == 0 )
			return;
		
		BankCustomer customer = null;
		if( type == 1 )
		{
			System.out.println("Enter id : ");
			String id = scanner.nextLine();
			
			// check if the customer is found
			customer = getCustomerById(id);
			// if this is null
			if( customer == null )
			{
				// show message customer not found
				System.out.println("Customer with id " + id + " does not exist");
				return;
			}
		}
		else if ( type == 2 )
		{
			System.out.println("Enter username : ");
			String username = scanner.nextLine();
			System.out.println("Enter password : ");
			String password = scanner.nextLine();
			
			// check if the customer is found
			customer = getCustomerByUserPassword(username, password);
			// if this is null
			if( customer == null )
			{
				// show message customer not found
				System.out.println("Customer with username " + username + " and password " + password + " does not exist");
				return;
			}
		}
		
		System.out.print("Enter account number : ");
		// read account number
		String accountNumber = scanner.nextLine();
		
		if( customer.findAccount(accountNumber) == null )
		{
			System.out.println("Account with number " + accountNumber + " not found!");
			return;
		}
		else
		{
			Account account = customer.findAccount(accountNumber);
			System.out.println("Account type    : "+ account.getType() + " Account");
			System.out.println("Account number  : "+ account.getNumber() );
			System.out.println("Account balance : $"+ account.getBalance() );
			
			// get the type
			if( account.getType().equals("Checking"))
			{
				// print the type
				
				// get the checking
				CheckingAccount checking = (CheckingAccount)account;
				// show limit and service fee
				System.out.println("Limit Amount    : $"+ checking.getLimit());
				System.out.println("Service fee     : $"+ checking.getServiceFee() );
			}
			else
			{
				// get savings
				SavingAccount saving = (SavingAccount)account;
				// show limit and service fee
				System.out.println("Limit Amount    : $"+ saving.getLimit() );
				System.out.println("Interest rate   : "+ saving.getInterestRate() + "%");
			}
		}
	}
	
	// method to open new account
	public void openNewAccount(Scanner scanner, BankCustomer customer)
	{
		String id = "";
		if( customer == null )
		{
			System.out.println("Enter id : ");
			id = scanner.nextLine();
			
			// check if the customer is found
			customer = getCustomerById(id);
			// if this is null
			if( customer == null )
			{
				// show message customer not found
				System.out.println("Customer with id " + id + " does not exist");
				return;
			}
		}
		
		// Ask for account choice
		System.out.println("Enter Account type choice\n1.Checking\n2.Savings");
		// ask choice
		int accountChoice = Integer.parseInt(scanner.nextLine());
		
		// generate number
		String accountNumber = BankService.getNewAccountNumber(this);
		// get balance
		System.out.print("Enter starting balance : ");
		float balance = Float.parseFloat(scanner.nextLine());
		
		// if this is check
		if( accountChoice == 1 ) 
		{
			
			// ask service fee
			System.out.print("Enter service fee : ");
			float serviceFee = Float.parseFloat(scanner.nextLine());
			
			// add new account to this customer
			customer.addAccount( new CheckingAccount(accountNumber, balance, limit, serviceFee));
		}
		else
		{
		
			// ask service fee
			System.out.print("Enter interest rate : ");
			float interestRate = Float.parseFloat(scanner.nextLine());	
			
			// create new account
			customer.addAccount( new SavingAccount(accountNumber, balance, limit, interestRate));
		}
		
		// show success
		System.out.println("Open new Account for Customer with id: " + id + " SUCCESS");
		
	}
	
	
