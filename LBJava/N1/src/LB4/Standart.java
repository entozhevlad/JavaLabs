package LB4;

public class Standart extends Account {
	private int balance;

	private String type = "Стандартный";

	public Standart(){

	}
	public Standart(int numb, int pin, int Balance) {
		super(numb, pin, Balance);
		balance=Balance;
	}

	@Override
	public int getBalance() {
		return balance;
	}
	@Override
	public String getType() {
		return type;
	}


	@Override
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void withdraw(int sum) throws SnyatSoSchetaException {
		try {
        balance-=sum;
        if (balance<0)
        	throw new SnyatSoSchetaException();
		}
		catch(SnyatSoSchetaException ex){
			System.out.println(ex.toString() + sum);
			throw ex;
			
		}
        System.out.println("Остаток на счету " + getNumb() + " : " + balance);
	}
}
