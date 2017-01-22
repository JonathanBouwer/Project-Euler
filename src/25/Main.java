import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		long k = System.currentTimeMillis();
		BigInteger x = new BigInteger("1");
		BigInteger y = new BigInteger("1");
		int count = 1;
		double check = 0.0;
		while(x.toString().length()<1000){
			BigInteger temp = new BigInteger(y.toString());
			y=y.add(x);
			x=temp;
			if(x.toString().length()/1000.0>check) {System.out.println(check); check+=0.1;}
			count++;
		}
		System.out.println(count);
		System.out.println((System.currentTimeMillis()-k)/1000.0);
	}

}