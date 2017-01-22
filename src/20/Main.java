import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		long k = System.currentTimeMillis();
		BigInteger x = new BigInteger("1");
		int sum=0;
		for(int i=2; i<=100; i++){
			x = x.multiply(new BigInteger(i+""));
		}
		char[] s = x.toString().toCharArray();
		for(char c:s){
			sum = sum+(c-48);
		}
		System.out.println(sum);
		System.out.println((System.currentTimeMillis()-k)/1000.0);
	}

}