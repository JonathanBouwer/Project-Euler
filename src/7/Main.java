import java.util.ArrayList;
import java.util.Collections;

public class Main{
	public static void main(String[] args){
		long x = System.currentTimeMillis();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		for(int i=1;primes.size()<=10001;i++){
			boolean add1 = true;
			boolean add2 = true;
			for(int j:primes){
				if((6*i-1)%j==0) add1 = false;
				if((6*i+1)%j==0) add2 = false;
				if(!add1 && !add2) break;
			}
			if(add1) primes.add(6*i-1);
			if(add2) primes.add(6*i+1);
			
		}
		System.out.println(primes.get(10000));
		System.out.println((System.currentTimeMillis()-x)/1000.0);
	}
	
}