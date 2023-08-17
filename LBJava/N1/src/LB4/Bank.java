package LB4;
import java.io.Serializable;
import java.util.ArrayList;
public class Bank implements Serializable {
	private static String name;
	public Bank(String name) {
		this.name = name;
		System.out.println(name);
	}
	public Bank(){

	}
	public static String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	private ArrayList Accounts = new ArrayList();
	public ArrayList getAccounts() {
		return Accounts;
	}
	public void addAccount(Account Account) {
		Accounts.add(Account);	
	}
	public int getSize() {
		return Accounts.size();
	}
	private ArrayList ATMs = new ArrayList();

	public void setAccounts(ArrayList accounts) {
		Accounts = accounts;
	}

	public void setATMs(ArrayList ATMs) {
		this.ATMs = ATMs;
	}

	public void addATM(ATM ATM) {

		ATMs.add(ATM);
	}
	public ArrayList getATM() {
		return ATMs;
	}
	public int getATMs() {
		return ATMs.size();
	}

}
