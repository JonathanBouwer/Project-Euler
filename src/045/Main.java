import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		int n = 286;
		int p = 165;
		int h = 141;
		BigInteger t = tri(n);
		while(true){
			while(pent(p).compareTo(t)<0){
				p++;
			}
			//System.out.println(p+" :p "+pent(p));
			if(pent(p).equals(t)){
				while(hex(h).compareTo(t)<0){
					h++;
				}
				//System.out.println(h);
				if(hex(h).equals(t)){
					break;
				}
			}
			//System.out.println(n+" :t "+tri(n));
			n++;
			t = tri(n);
		}
		
		System.out.println(n+" : "+t);
	}
	
	public static BigInteger tri(int n){
		BigInteger val = new BigInteger(n+"");
		val = val.multiply(new BigInteger((n+1)+""));
		val = val.divide(new BigInteger(2+""));
		return val;
	}
	
	public static BigInteger pent(int n){
		BigInteger val = new BigInteger(n+"");
		val = val.multiply(new BigInteger((3*n-1)+""));
		val = val.divide(new BigInteger(2+""));
		return val;
	}
	
	public static BigInteger hex(int n){
		BigInteger val = new BigInteger(n+"");
		val = val.multiply(new BigInteger((2*n-1)+""));
		return val;
	}
}
