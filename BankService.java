import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class BankService 
{
	private static Random obj1 = new Random();
	
	private static BankCustomer getNewCustomer(String tokens[])
	{
		BankCustomer customer = new  BankCustomer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
		Account acc1 = null;
		
		if( Double.parseDouble(tokens[9]) < 1 )
		{
			// for savings
			acc1 = new SavingAccount(tokens[6], Float.parseFloat(tokens[7]),Float.parseFloat(tokens[8]),Float.parseFloat(tokens[9]));			
		}
		else
		{
			// for checking
			acc1 = new CheckingAccount(tokens[6], Float.parseFloat(tokens[7]),Float.parseFloat(tokens[8]),Float.parseFloat(tokens[9]));
		}
		
		customer.addAccount(acc1);
		if( tokens.length > 10)
		{
			if( Double.parseDouble(tokens[13]) < 1 )
			{
				Account account = new SavingAccount(tokens[10], Float.parseFloat(tokens[11]),Float.parseFloat(tokens[12]),Float.parseFloat(tokens[13]));			
				customer.addAccount(account);
			}
			else
			{
				Account account = new CheckingAccount(tokens[10], Float.parseFloat(tokens[11]),Float.parseFloat(tokens[12]),Float.parseFloat(tokens[13]));
				customer.addAccount(account);
			}
			
		}
		return customer;
	}
	
	//main menu
	private static void mainMenu()
	{
		System.out.println("BANK SERVICE APPLICATION\n" + 
				"1. Bank Employee\n" + 
				"2. Bank Customer\n" + 
				"0. Exit");
	}
        
	private static void saveToFile(Software bankCustomers)
	{
		PrintWriter pw = null;
		//try catch method for expection handling
		try
		{
			pw = new PrintWriter(new File("bankCustomer.csv"));
		}
		catch(Exception e)
		{
			return;
		}
		
		for( BankCustomer bankCustomer : bankCustomers.getAllCustomers() )
			pw.println(bankCustomer.csvString());
		
		pw.close();
	}
	
	// bank employee menu
	private static void bankEmployeeMenu()
	{
		System.out.println("TASKS FOR BANK EMPLOYEES\n" + 
				"1. Add a New Customer : Open New Account\n" + 
				"2. Display a Customer With All Accounts\n" + 
				"3. Open New Account for Current Customer\n" + 
				"4. Read One Account of One Customer\n" + 
				"5. Remove One Account of Current Customer\n" + 
				"6. Display all Customers with their accounts\n" + 
				"7. Process Monthly Statement\n" + 
				"0. DONE");
	}
	
	// bank customer menu
	private static void customerMenu()
	{
		System.out.println("TASKS FOR BANK CUSTOMERS\n" + 
				"1. Print Information of Customer\n" + 
				"2. Check balance\n" + 
				"3. Deposit\n" + 
				"4. Withdraw\n" + 
				"5. Print Monthly Statement\n" + 
				"0. DONE");
	}

	private static void customerLoginMenu()
	{
		System.out.println("SELECT LOGIN TYPE \n1.Customer id\n" + 
				"2.User name and password \n0.DO NOT CONTINUE");
	}
	
	public static int getCustomerLoginInput(Scanner scanner)
	{
		customerLoginMenu();
		System.out.print("Enter option : ");
		int choice = Integer.parseInt( scanner.nextLine() );
		
		
		while( choice < 0 || choice > 2 )
		{
			System.out.println("Invalid option!");
			System.out.println();
			customerLoginMenu();
			System.out.print("Enter option : ");
			
			choice = Integer.parseInt( scanner.nextLine() );
		}
		
		return choice;
	}
	
	private static void customerMenu(BankCustomer customer,Scanner scanner)
	{
		customerMenu();
		System.out.print("Enter option : ");
		int customerInput = Integer.parseInt(scanner.nextLine());
		while( customerInput != 0 )
                {
			if(customerInput == 1 )
			{
				// Print Information of Customer
				System.out.println("YOU ARE : ");
				customer.printInformation();
			}
			else if(customerInput == 2 )
			{
				// 2. Check balance
				customer.checkBal(scanner);
			}
			else if(customerInput == 3 )
			{
				// 3. Deposit
				customer.deposit(scanner);
			}
			else if(customerInput == 4 )
			{
				// 4. Withdraw
				customer.withdraw(scanner);
			}
			else if(customerInput == 5 )
			{
				// 5. 5. Print Monthly Statement
				customer.printMonthlyStatement(scanner);
			}
			else 
			{
				// show invalid choice
				System.out.println("Invalid option!");
			}
			
			System.out.println();
			customerMenu();
			System.out.print("Enter option : ");
			customerInput = Integer.parseInt(scanner.nextLine());
		}
	}
	
	private static void runCustomerLoginMenu(Scanner scanner,Software bankCustomers)
	{
		// show login menu
		int loginInput = getCustomerLoginInput(scanner);
		
		// if this is 0, return
		while( loginInput != 0 )
		{
			// perform based on 2 inputs
			if( loginInput == 1 )
			{
				// ask for account id
				System.out.println("Enter id : ");
				String id = scanner.nextLine();
				
				// check if the customer is found
				BankCustomer customer = bankCustomers.getCustomerById(id);
				// if this is null
				if( customer == null )
				{
					// show message customer not found
					System.out.println("Customer not found!");
				}
				else
				{
					// start customer menu with this customer
					customerMenu(customer, scanner);
				}
			}
			else if( loginInput == 2 )
			{
				// ask user name and password
				System.out.println("Enter username : ");
				String username = scanner.nextLine();
				System.out.println("Enter password : ");
				String password = scanner.nextLine();
				
				// check if the customer is found
				BankCustomer customer = bankCustomers.getCustomerByUserPassword(username, password);
				// if this is null
				if( customer == null )
				{
					// show message customer not found
					System.out.println("Customer not found!");
				}
				else
				{
					// start customer menu with this customer
					customerMenu(customer, scanner);
				}
			}
			
			// ask input again
			loginInput = getCustomerLoginInput(scanner);
		}
	}
	
	// method to run employee menu
	private static void bankEmployeeMenu(Scanner scanner,Software  bankCustomers)
	{
		// bank employee menu
		bankEmployeeMenu();
		// ask choice
		System.out.print("Enter option : ");
		// read choice
		int bankMenuChoice = Integer.parseInt(scanner.nextLine());
		
		// while this is not 0
		while( bankMenuChoice != 0 )
		{
			// work according to choice
			if(bankMenuChoice == 1 )
			{
				// Add a New Customer â€“ Open New Account
				bankCustomers.addNewCustomer(scanner);
			}
			else if(bankMenuChoice == 2 )
			{
				// Display a Customer With All Accounts
				bankCustomers.displayCustomerAllAccounts(scanner);
			}
			else if(bankMenuChoice == 3 )
			{
				// Open New Account for Current Customer
				bankCustomers.openNewAccount(scanner, null);
			}
			else if(bankMenuChoice == 4 )
			{
				// Read One Account of One Customer
				bankCustomers.readOneAccountOfCustomer(scanner);
			}
			else if(bankMenuChoice == 5 )
			{
				// Remove One Account of Current Customer
				bankCustomers.readOneAccountOfCustomer(scanner);
			}
			else if(bankMenuChoice == 6 )
			{
				// Display all Customers with their accounts
				bankCustomers.displayAllCustomersWithAccounts();
			}
			else if(bankMenuChoice == 7 )
			{
				bankCustomers.processMonthlyStatements();
			}
			
			else 
			{
				System.out.println("Invalid option!");
			}
			
			System.out.println();
			bankEmployeeMenu();
			System.out.print("Enter option : ");
			bankMenuChoice = Integer.parseInt(scanner.nextLine());		
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		Software bankCustomers = new Software();
		Scanner fileScanner = new Scanner(new File("bankCustomer.csv"));
		
		while( fileScanner.hasNextLine() )
		{
			String line = fileScanner.nextLine();
			String tokens[] = line.split(",");
			bankCustomers.addCustomer(getNewCustomer(tokens));
		
		}
                
		fileScanner.close();
		Scanner scanner = new Scanner(System.in);
		int mainMenuChoice; 
		
		// show main menu
		mainMenu();
		System.out.print("Enter option : ");
		mainMenuChoice = Integer.parseInt( scanner.nextLine() );
		
		
		while( mainMenuChoice != 0 )
		{
			if( mainMenuChoice == 1 )
			{
				bankEmployeeMenu(scanner, bankCustomers);
			}
			else if(mainMenuChoice == 2 )
			{
				runCustomerLoginMenu(scanner, bankCustomers);
			}
			else
			{
				System.out.println("Invalid option!");
			}
			System.out.println();
			mainMenu();
			System.out.print("Enter option : ");
			mainMenuChoice = Integer.parseInt( scanner.nextLine() );
		}
		scanner.close();
		saveToFile(bankCustomers);
	}

	public static String getNewAccountNumber(Software bankCustomers)
	{
		String accountNumber = "";
		for( int i=0; i<10; i++)
			accountNumber = accountNumber + obj1.nextInt(10);
		while( bankCustomers.hasAccountNumber(accountNumber))
		{
			accountNumber = "";
			for( int i=0; i<10; i++)
				accountNumber = accountNumber + obj1.nextInt(10);
		}
		return accountNumber;
	}
}


