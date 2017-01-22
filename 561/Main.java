import java.util.ArrayList;
public class Main{
	public static void main(String[] args){
		ArrayList<Integer> primes = generatePrimes(15000000);
		System.out.println(E(2,1,primes));
	}
	
	public static long S(long n){
		long count = 0;
		for(long i=2;i<=n;i++){
			if(n%i==0){
				for(long j=1;j<i;j++){
					if(i%j==0){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int E(int m, int n, ArrayList<Integer> primes){
		long s = S((long) Math.pow(p(m, primes),n));
		int count =0;
		while(s%2==0){
			s=s>>1;
			count++;
		}
		return count;
	}
	
	public static long p(int m, ArrayList<Integer> primes){
		long out = 1L;
		for(int i=0; i<m;i++){
			out*=primes.get(i);
		}
		return out;
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