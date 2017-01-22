import java.math.BigInteger;
import java.util.TreeSet;

public class Main{
	public static void main(String[] args){
		TreeSet<BigInteger> t = new TreeSet<BigInteger>();
		for(int i=2; i<=100; i++){
			BigInteger b = new BigInteger(""+i);
			for(int j=2; j<=100;j++){
				t.add(b.pow(j));
			}
		}
		System.out.println(t.size());
	}
}
