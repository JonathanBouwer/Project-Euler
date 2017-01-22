import java.util.ArrayList;
import java.util.Collections;

public class Main{
	public static void main(String[] args){
		long x = System.currentTimeMillis();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		double perc = 0.0;
		for(int i=1;6*i-1<2000000;i++){
			
			boolean add1 = true;
			boolean add2 = true;
			for(int j:primes){
				if((6*i-1)%j==0) add1 = false;
				if((6*i+1)%j==0) add2 = false;
				if(!add1 && !add2) break;
				if(j*j>6*i+1) break;
			}
			if(add1) primes.add(6*i-1);
			if(add2) primes.add(6*i+1);
			if((6*i+1)/2000000.0>perc){
				perc=perc+0.1;
				System.out.println((6*i+1)/2000000.0+" "+perc);
			}
		}
		long sum = 0;
		for(int j:primes){
			sum+=j;
		}
		System.out.println("Sum: "+sum + "\n"+(System.currentTimeMillis()-x)/1000.0);

	}
	
}