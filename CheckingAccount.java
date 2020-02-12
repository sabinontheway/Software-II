



public class CheckingAccount extends Account 
{
    
	private float limit;
	private float serviceFee;
        
       
		
	public CheckingAccount(String number, float balance,float limit,float serviceFee) 
	{
		super(number, balance);
		this.limit = limit;
		this.serviceFee = serviceFee;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	public float getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(float serviceFee) {
		this.serviceFee = serviceFee;
	}
	
	public void printMonthlyStatement()
	{
		super.printMonthlyStatement();
		System.out.println("Service fee     : $"+ getServiceFee() );
		System.out.println("End balance     : $"+ (getBalance() - serviceFee) );
		
	}
	
        //polymorphism
	@Override
	public String toString() 
	{
		return getNumber() + "," + getBalance() + "," + limit + "," + serviceFee;
	}
	
	// get type
	public String getType()
	{
		return "Checking";
	}	

}

