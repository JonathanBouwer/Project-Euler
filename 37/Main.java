import java.util.ArrayList;

public class Main{
	
	
	public static void main(String[] args){
		long t = System.nanoTime();
		ArrayList<Integer> p = generatePrimes(1000000);
		System.out.printf("%.3f seconds",(System.nanoTime()-t)/1000000000.0);
		/*
		for(Integer i:p){
			int j = i.intValue();
			if(j<10) continue;
			if(isLeftTrunc(j, p)&&isRightTrunc(j, p)) System.out.println(i);
		}
		*/
	}
	
	public static boolean isLeftTrunc(int n, ArrayList<Integer> p){
		if((n<10)&&isPrime(n,p)) return true;
		if(!isPrime(n,p)) return false;
		int c = (int) Math.log10(n);
		int q = (int) Math.pow(10,c);      
		int k = n / q;           
		return isLeftTrunc(n-k*q, p);
	}
	
	public static boolean isRightTrunc(int n, ArrayList<Integer> p){
		if((n<10)&&isPrime(n,p)) return true;
		if(!isPrime(n,p)) return false;
		return isRightTrunc(n/10, p);
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
