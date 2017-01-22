import java.math.BigInteger;

public class Main{
	public static void main(String[] args){
		BigInteger n = new BigInteger("1");
		for(int i=0;i<1000;i++){
			n=n.multiply(new BigInteger("2"));
		}
		char[] c = n.toString().toCharArray();
		int sum = 0;
		for(char k:c){
			sum+=k-48;
		}
		System.out.println(sum);
	}
	
}