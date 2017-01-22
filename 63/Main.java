import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		int pow = 1;
		int length = 1;
		int count = 0;
		while(length<25){
			for(int cur = 1;cur<=10;cur++){
				BigInteger power = new BigInteger(cur+"");
				power = power.pow(pow);
				if((power.toString()).length()==length){ System.out.printf("%d^%d=%s\n",cur,pow,power.toString()); count++;}
				if((power.toString()).length()>length)	length++;
			}
			pow++;	
		}
		System.out.println(count);
	}
}
