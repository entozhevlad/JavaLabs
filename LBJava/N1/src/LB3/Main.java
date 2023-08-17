package LB3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File in1 = new File("C:\\Users\\RBT\\LBJava\\N1\\f1.txt");
        File out1 = new File("C:\\Users\\RBT\\LBJava\\N1\\f2.txt");
        File out2 = new File("C:\\Users\\RBT\\LBJava\\N1\\f3.txt");
        File out3 = new File("C:\\Users\\RBT\\LBJava\\N1\\f4.txt");
        try{
            FileInputStream In = new FileInputStream(in1);
            FileOutputStream Out1 = new FileOutputStream(out1,false);
            FileOutputStream Out2 = new FileOutputStream(out2,false);
            FileOutputStream Out3 = new FileOutputStream(out3);

            byte [] str = In.readAllBytes();

            int words = 1;
            int symbol = 1;

            for(int i=0;i<str.length-1;i++) {
                if (str[i + 1] == '\n') {
                    Out1.write((symbol + "\n").getBytes());
                    Out2.write((words + "\n").getBytes());
                    Out3.write((" "+words+" "+ symbol).getBytes());
                    words= 1;
                    symbol=-1;
                }
                if (str[i] == '\n') {
                    symbol--;
                }
                if (str[i] == ' ') {
                    words++;
                }
                if (str[i] == '-') {
                    words--;
                    Out3.write(str[i]);
                } else {
                    symbol++;
                    Out3.write(str[i]);
                }
            }
            In.close();
            Out1.close();
            Out2.close();
            Out3.close();

        }
        catch(IOException e){
            e.getStackTrace();

        }
        System.out.println("Готово");

    }
}




