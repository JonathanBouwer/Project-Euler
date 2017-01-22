import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String str = s.next();
		BigInteger out = new BigInteger("0");
		while(!str.equals("0")){
			BigInteger temp = new BigInteger(str);
			out = out.add(temp);
			str = s.next();
		}
		System.out.println(out);
	}
	
}