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
	
	
