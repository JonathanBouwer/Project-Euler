import java.util.ArrayList;
import java.util.HashMap;
public class Main{
	public static void main(String[] args){
		long t = System.nanoTime();
		int size = 100000000;
		ArrayList<Integer> primes = generatePrimes(size);
		System.out.printf("%.3f milliseconds\n",(System.nanoTime()-t)/1000000.0);
		ArrayList<HashMap<Integer,Integer>> factors = new ArrayList<HashMap<Integer,Integer>>();
		factors.add(new HashMap<Integer,Integer>());
		factors.add(new HashMap<Integer,Integer>());
		for(int i=2; i<size;i++){
			factors.add(factorize(i,primes,factors));
			if(i%500000==0) System.out.printf("%d: %.3f milliseconds\n",i,(System.nanoTime()-t)/1000000.0);
		}
		
		
		//for(int j =0;j<size;j++) printFactors(j,primes,factors.get(j));
		
		System.out.printf("%.3f milliseconds",(System.nanoTime()-t)/1000000.0);
	}	
	
	public static void printFactors(int j, ArrayList<Integer> primes, HashMap<Integer,Integer> pr){
		System.out.print(j+": ");
		boolean used = false;
		for(int i:primes){
			if(pr.get(i)!=null) {
				if(pr.get(i)!=0){ 
					if(used) {
						System.out.print("*"+i+"^"+pr.get(i));
					}else{
						System.out.print(i+"^"+pr.get(i));
						used = true;
					}
				}
			}
		}
		System.out.println();
	}
	
	public static HashMap<Integer,Integer> factorize(int n, ArrayList<Integer> primes, ArrayList<HashMap<Integer,Integer>> factors){
		if(isPrime(n,primes)){
			HashMap<Integer,Integer> out = new HashMap<Integer,Integer>();
			out.put(n,1);
			return out;
		}
		for(int i: primes){
			if(n%i==0){
				n/=i;		
				HashMap<Integer,Integer> out = new HashMap<Integer,Integer>(factors.get(n));
				if(out.get(i)!=null) out.put(i,out.get(i)+1);
				else out.put(i,1);
				return out;
			}
		}
		System.out.println("FATAL ERROR");
		return factors.get(0);
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