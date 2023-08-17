package LB4;
import java.io.Serializable;
import java.util.ArrayList;
public abstract class Account implements Serializable {
	private String name;
	private int numb;
	private int pin;
	private int balance;
	private String type;
	public String getType() {
		return type;
	}


	public Account(){

	}
	public Account(int numb,int pin, int balance) {
		try {
		this.numb = numb;
		this.pin = pin;
		this.balance = balance;
			if (balance<0) 
				throw new OstatokNaScheteException();
			}
		catch(OstatokNaScheteException ex){
			System.out.println(ex.toString() + balance);
			return;
		}
        System.out.println("Номер счёта: " + numb + "; Остаток: " + balance + " ПИН: " + pin);
	}
	
	public int getNumb() {
		return numb;
	}
	public void setNumb(int newNumb) {
		numb = newNumb;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int Pin) {
		pin = Pin;
	}
	public int getBalance() {
		return balance;
	}


	public void setBalance(int Balance) {
		balance = Balance;
	}
    public void withdraw(int sum)throws SnyatSoSchetaException {
    	try {
            balance-=sum;
            if (balance<0)
            	throw new SnyatSoSchetaException();
    		}
    		catch(SnyatSoSchetaException ex){
    			System.out.println(ex.toString() + sum);
    			throw ex;		
    		}
        System.out.println("Остаток на счету " + getNumb() +" : " + balance);
    }
}
