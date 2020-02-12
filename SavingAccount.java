//inheritance
public class SavingAccount extends Account 
{
	private float interestRate;
	
 //parameterized constructors
	public SavingAccount(String number, float balance, float interestRate) 
	{
		super(number, balance);
		this.interestRate = interestRate;
	}

	
	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	public void printMonthlyStatement()
	{
		super.printMonthlyStatement();
		System.out.println("Interest Rate   : "+ (interestRate*100) + "%" );
		float interestAmount = interestRate*getBalance();
		System.out.println("Interest Amount : $"+ (interestAmount) );
		System.out.println("End Balance     : $"+ (interestAmount + getBalance()) );
	}
	
	
  //polymorphism
	@Override
	public String toString() 
	{
		return getNumber() + "," + getBalance() + "," + interestRate;
	}

	public String getType()
	{
		return "Savings";
	}	
}

