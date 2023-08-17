package LB4;
import java.io.IOException;
public class main {

	public static void main(String[] args) throws SnyatSoSchetaException, IOException, ClassNotFoundException {
		Bank bank = new Bank("Спёрбанк");
		Standart standart1 = new Standart(1,1123,100);
		Standart standart2 = new Standart(2,1234,5000);
		Preferential preferential = new Preferential(3,7777,100);
		ATM atm1 = new ATM(35,"пр.Ленина, 30");
		ATM atm2 = new ATM(36,"пр.Ветеранов, 31");
		ATM atm3 = new ATM(37,"пр.Кирова, 22");
		ATM atm4 = new ATM(38,"пр.Сахарова, 44");
		bank.addAccount(standart1);
		bank.addAccount(standart2);
		bank.addAccount(preferential);
		bank.addATM(atm1);
		bank.addATM(atm2);
		bank.addATM(atm3);
		bank.addATM(atm4);
		LB9 lb = new LB9();
	}
}
