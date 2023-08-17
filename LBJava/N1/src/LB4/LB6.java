package LB4;
import java.io.*;
import java.beans.*;

public class LB6 implements Serializable {
    public static void SaveXML(Bank bank) throws IOException {
        File out1 = new File("C:\\Users\\RBT\\LBJava\\N1\\file.xml");
        FileOutputStream Out1 = new FileOutputStream(out1);
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(Out1));
        e.writeObject(bank);
        e.close();
    }
    public static void DownloadXML(Bank bank) throws IOException, ClassNotFoundException {
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("file.xml")));
        Bank bank1 = (Bank)d.readObject();
        String name = bank1.getName();
        int accounts = bank1.getSize();
        int atm = bank1.getATMs();
        System.out.println("Банк: " + name);
        System.out.println("Количество счетов: " + accounts);
        System.out.println("Количество Банкоматов: " + atm);
        d.close();

    }
}
