import java.util.Arrays;
import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		int count = 0;
		for(int n=1;n<=100; n++){
			System.out.println(n);
			for(int r=0;r<=n;r++){
				if(choose(n,r).compareTo(new BigInteger(1000000+""))>0){
					count+=n-2*r+1;
					break;
				}
			}
		}
		System.out.println(count);
	}
	
	public static BigInteger choose(int n, int r){
		//n!/r!/(n-r)!
		BigInteger rFact = fact(r);
		BigInteger nrFact = fact(n-r);
		BigInteger nFact = fact(n);
		//System.out.printf("%d/(%d*%d)\n", nFact, nrFact, rFact);
		return nFact.divide(rFact.multiply(nrFact));
	}
	
	public static BigInteger fact(int n){
		BigInteger out =BigInteger.ONE;
		for(int i=1;i<=n;i++){
			out=out.multiply(new BigInteger(i+""));
		}
		return out;	
	}
}
