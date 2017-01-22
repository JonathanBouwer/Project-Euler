import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		ArrayList<Integer> p = generatePrimes(1000000);
		int cons = 4;
		for(int i=14; i<1000000; i++){
			if(distinctPrimeFactors(i,cons,p)){
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean distinctPrimeFactors(int n, int size, ArrayList<Integer> p){
		for(int i=n;i<n+size;i++){
			if(factorize(i,p)!=size) return false;
		}
		return true;
	}
	
	public static int factorize(int n, ArrayList<Integer> p){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(Integer i:p){
			if(n==1) break;
			int j = i.intValue();
			if(n%j==0) factors.add(i);
			while(n%j==0) n/=j;
		}
		return factors.size();
	}
	
	public static ArrayList<Integer> generatePrimes(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		for(int i=1; 6*i+1<n;i++){
			if(isPrime(6*i-1, primes)) primes.add(6*i-1);
			if(isPrime(6*i+1, primes)) primes.add(6*i+1);
		}
		return primes;
	}
	
	public static boolean isPrime(int n, ArrayList<Integer> p){
		if(n==1) return false;
		for(Integer i:p){
			int j = i.intValue();
			if(j*j>n) break;
			if(n%j==0) return false; 
		}
		return true;
	}
}