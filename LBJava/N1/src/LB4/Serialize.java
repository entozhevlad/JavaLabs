package LB4;
        import java.io.*;

public class Serialize implements Serializable {
        public static void Save(Bank bank) throws IOException {
                File out1 = new File("C:\\Users\\RBT\\LBJava\\N1\\file.dat");
                FileOutputStream Out1 = new FileOutputStream(out1);
                ObjectOutputStream objectOutput = new ObjectOutputStream(Out1);
                objectOutput.writeObject(bank);
                Out1.close();
        }

        public static Bank Download(String path) throws IOException, ClassNotFoundException {
                FileInputStream In1 = new FileInputStream(path);
                ObjectInputStream objectInput = new ObjectInputStream(In1);
                Bank bank1 = (Bank) objectInput.readObject();
                String name = bank1.getName();
                int accounts = bank1.getSize();
                int atm = bank1.getATMs();

                In1.close();
                return bank1;
        }
}
