import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		long t = System.currentTimeMillis();

		BigInteger k = new BigInteger("0");
		for(int i=1;i<1001;i++){
			BigInteger j = new BigInteger(""+i);
			j=j.pow(i);
			//System.out.println(j);
			k=k.add(j);
		}
		System.out.println(k.mod(new BigInteger("10000000000")));
		
		
		System.out.println((System.currentTimeMillis()-t)+" Milliseconds");
	}	
}