import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		int j=0;
		for(int i=0; i<10000;i++) if(!isLychrel(i)) j++;
		System.out.println(j);
	}
	
	public static boolean isLychrel(long n){
		//System.out.println("\n"+n);
		BigInteger b = new BigInteger(n+"");
		for(int i=0; i<50; i++){
			b=b.add(rev(b));
			//System.out.println(b);
			if(b.equals(rev(b))) return true;
		}
		return false;
	}
	
	public static BigInteger rev(BigInteger n){
		BigInteger ret = new BigInteger("0");
		while(n!=BigInteger.ZERO){
			ret = ret.multiply(new BigInteger("10")).add(n.mod(new BigInteger("10"))); 
			n=n.divide(new BigInteger("10"));
		}
		return ret;
	}
}