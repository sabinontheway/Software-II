

public class Account {
	private String number;
	private float balance;
	
	// parameterized constructors
	public Account(String number, float balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	// to withdraw
	public boolean withdraw(float amount)
	{
		if( amount > balance )
			return false;
		balance -= amount;
		return true;
	}
	
	// to deposit
	public void desposit(double amount)
	{
		balance += amount;
	}
	
	// to  print monthly statement
	public void printMonthlyStatement()
	{
		System.out.println("Account number  : "+ getNumber() + " Account");
		System.out.println("Account balance : $"+ getBalance() + " Account");
	}

	@Override
	public String toString() 
	{
		return "[Account number=" + number + ", balance=" + balance + "]";
	}
	
	// get type
	public String getType()
	{
		return "";
	}
	
}


