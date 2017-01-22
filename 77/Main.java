import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		int size = 100;
		ArrayList<Integer> primes = generatePrimes(size);
		
		int[][] count = new int[size][primes.size()];
		//coin change with prime coins
		out:
		for(int i=0;i<size;i++){
			for(int j=0; j<primes.size();j++){
				if(i==0) count[i][j]=1;
				else if(j==0){ if(i%primes.get(j)==0) count[i][j]=1; }
				else if(primes.get(j)>i) count[i][j] = count[i][j-1];
				else count[i][j] = count[i][j-1] + count[i-primes.get(j)][j];
				if(count[i][j]>5000){System.out.println(i); break out;}
			}
		}/*
		System.out.printf("%7d ",-1);
		for(int i:primes)System.out.printf("%7d ",i);
		System.out.println();
		for(int i=0;i<size;i++){
			System.out.printf("%7d ",i);
			for(int j=0; j<primes.size();j++){
				System.out.printf("%7d ",count[i][j]);
			}
			System.out.println();
		}
		*/
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