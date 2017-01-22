import java.util.ArrayList;
import java.math.BigInteger;

public class Main{
	public static void main(String[] args){
		ArrayList<BigInteger> e = new ArrayList<BigInteger>();
		for(int i=0; i<99;i++){
			if(i%3==1) e.add(new BigInteger((i/3+1)*2+""));
			else e.add(BigInteger.ONE);
			System.out.printf("%d: %s\n",i+2,calcContinuedFrac(new BigInteger("2"),e).toString());
		}
		char[] ch = calcContinuedFrac(new BigInteger("2"),e).toString().toCharArray();
		int sum = 0;
		for(char c:ch){
			if(c=='/') break;
			sum+=c-48;
		}
		System.out.println(sum);
	}
	
	public static Frac calcContinuedFrac(BigInteger start, ArrayList<BigInteger> q){
		Frac a = new Frac(q.get(q.size()-1),BigInteger.ONE);
		for(int i=q.size()-2; i>=0;i--){
			a= a.invert();
			Frac b = new Frac(q.get(i),BigInteger.ONE);
			a = a.add(b);
			//System.out.println(a);
		}
		a=a.invert();
		a=a.add(new Frac(start,BigInteger.ONE));
		return a;
	}
}

class Frac{
	BigInteger n,d;
	
	public Frac(BigInteger num, BigInteger denom){
		n=num;
		d=denom;
		BigInteger g = gcd(n,d);
		n=n.divide(g);
		d=d.divide(g);
	}

	private BigInteger gcd(BigInteger a, BigInteger b){
		if(b.equals(new BigInteger("0"))) return a;
		return gcd(b, a.mod(b));
	}
	
	public Frac add(Frac o){
		return new Frac(n.multiply(o.d).add(o.n.multiply(d)), d.multiply(o.d));
	}
	
	public Frac invert(){
		return new Frac(d,n);
	}
	
	public String toString(){
		return n.toString()+"/"+d.toString();
	}
}
