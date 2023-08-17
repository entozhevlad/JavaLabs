package LB4;
import java.io.*;
public class BankReport  {
    File out2 = new File("C:\\Users\\RBT\\LBJava\\N1\\Отчёт.txt");
    File in = new File("C:\\Users\\RBT\\LBJava\\N1\\Отчёт.txt");
    public static void FormAndSaveReport(Bank bank) throws IOException {
        FileWriter fw = new FileWriter("Отчёт.txt");
        String name =bank.getName();
        int clients = bank.getSize();
        int atms = bank.getATMs();
        fw.write("Банк " + name +"\n");
        int bankBalance =0;
        for(int i = 0; i< clients; i++){
            Account account = (Account) (bank.getAccounts()).get(i);
            int numb = account.getNumb();
            int balance = account.getBalance();
            bankBalance+=account.getBalance();
            fw.write("Счёт №: " + numb + ", остаток: " + balance +"\n" );
        }
        fw.write("-----------"  +"\n");
        fw.write("Суммарный остаток на счетах: " + bankBalance+"\n");
        fw.write("" +"\n");
        fw.write("" +"\n");
        fw.write("------------------------------------------"+"\n");
        for(int i = 0; i<atms; i++){
            ATM atm = (ATM) (bank.getATM()).get(i);
            int id = atm.getID();
            String adress = atm.getAddress();
            fw.write("Банкомат №: " + id + ", адрес: " + adress+"\n");
        }
        fw.close();
    }
    public static void downloadReport() throws IOException{
        FileReader fr = new FileReader("Отчёт.txt");
        char[] array = new char[500];
        int size =0;
        size =fr.read(array);
        for (int i=0;i<size;i++) {
            System.out.print(array[i]);
         }
        }
}

