import java.util.ArrayList;
import java.util.Collections;

public class Main{
	public static void main(String[] args){
		long target = 600851475143L;
		long x = System.currentTimeMillis();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		for(int i=1;6*i-1<Math.sqrt(target);i++){
			boolean add1 = true;
			boolean add2 = true;
			for(int j:primes){
				if(j*j>6*i+1) break;
				if((6*i-1)%j==0) add1 = false;
				if((6*i+1)%j==0) add2 = false;
				if(!add1 && !add2) break;
			}
			if(add1) primes.add(6*i-1);
			if(add2) primes.add(6*i+1);
			
		}
		
		Collections.reverse(primes);
		for(int j:primes){
			if(target%j==0) System.out.println(j);
		}
		System.out.println((System.currentTimeMillis()-x)/1000.0);

	}
}