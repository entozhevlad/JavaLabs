package LB3;

import java.io.*;
import java.util.Scanner;

public class lb31 {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream In = new DataInputStream(new FileInputStream("C:\\Users\\RBT\\LBJava\\N1\\f1.txt"));
            DataOutputStream Out1 = new DataOutputStream(new FileOutputStream("f2.txt"));
            DataOutputStream Out2 = new DataOutputStream(new FileOutputStream("C:\\Users\\RBT\\LBJava\\N1\\f3.txt"));
            DataOutputStream Out3 = new DataOutputStream(new FileOutputStream("C:\\Users\\RBT\\LBJava\\N1\\f4.txt"));
            FileReader fr = new FileReader("f1.txt");
            Scanner scan = new Scanner(fr);
            FileWriter fw = new FileWriter("f4.txt");
            FileWriter fw1 = new FileWriter("f2.txt");
            FileWriter fw2 = new FileWriter("f3.txt");


            int words = 1;
            int symbol = 1;
            int size =0;
            char[] array = new char[300];
            size =fr.read(array);

            for (int i=0;i<size;i++) {
                if (array[i + 1] == '\n') {
                    Out1.writeBytes(symbol +"\n");
                    String a = Integer.toString(words);
                    Out2.writeBytes(a+"\n");
                   fw.write(" "+words+" "+ symbol);
                    words = 1;
                    symbol = -1;
                }
                if (array[i] == '\n') {
                    symbol--;
                }
                if (array[i] == ' ') {
                    words++;
                }
                if (array[i] == '-') {
                    words--;
                    fw.write(array[i]);
                } else {
                    symbol++;
                    fw.write(array[i]);
                }
            }
//          fw.write(array);
            Out1.close();
            Out2.close();
            fw.close();
            fw1.close();
            fw2.close();
            fr.close();
            System.out.println("Done!");

        }

        catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
}

