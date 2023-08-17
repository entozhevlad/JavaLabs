package LB4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LB2 extends Exception{
		static String EnterStr() throws IOException {
			byte b[]=new byte[100];
			System.in.read(b);
			String s = new String(b); 
			s = s.trim(); 
			return s;
		 
	}
		static int EnterInt() throws IOException, NumberFormatException {
			byte b[]=new byte[100];
			try {
			System.in.read(b);
			String s = new String(b); 
			s = s.trim(); 
			int p=0;
			p = Integer.parseInt(s);
			return p;		 
			}
			catch(NumberFormatException ex){
				ex.printStackTrace();
				return -1;
			}
	}

}
