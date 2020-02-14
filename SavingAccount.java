//inheritance
public class SavingAccount extends Account 
{
	
	private float limit;
	private float interestRate;
	
        //parameterized constructors
	public SavingAccount(String number, float balance,float limit,float interestRate) 
	{
		super(number, balance);
		this.limit = limit;
		this.interestRate = interestRate;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
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
		return getNumber() + "," + getBalance() + "," + limit + "," + interestRate;
	}

	public String getType()
	{
		return "Savings";
	}	
}

