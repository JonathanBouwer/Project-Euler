import java.util.ArrayList;
public class Main{
	
	public static void main(String[] args){
		int size = 1000000;
		long sum = 0;
		long t = System.nanoTime();
		ArrayList<Integer> primes = generatePrimes(size);
		for(int i=2; i<=size;i++){
			sum+=totient(i,primes);
			if(i%10000==0) System.out.printf("%d: %d\n",i,sum);
		}
		System.out.printf("%.3f milliseconds\n",(System.nanoTime()-t)/1e6);
	}
	
	public static int totient(int n,ArrayList<Integer> primes){
		int count = n;
		for(int p:primes){
			if(p*p>n) break;
			if(n%p==0){
				count/=p;
				count*=(p-1);
				while(n%p==0) n/=p;
			}
		}
		if(n>1) count -= count / n;
		return count;
		
	}
	
	public static ArrayList<Integer> generatePrimes(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(2);
		p.add(3);
		int c = 1;
		while(6*c+1<=n){
			if(isPrime(6*c-1,p)) p.add(6*c-1);
			if(isPrime(6*c+1,p)) p.add(6*c+1);
			c++;
		}
		return p;
	}
	
	public static boolean isPrime(int n, ArrayList<Integer> p){
		if(n==1||n==0) return false;
		for(Integer i:p){
			if(i*i>n) break;
			if(n%i==0) return false;
		}
		return true;
	}
}
