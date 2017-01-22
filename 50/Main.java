import java.util.ArrayList;
public class Main{
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args){
		long t = System.currentTimeMillis();
		generatePrimes();
		Integer[] p = new Integer[primes.size()];
		primes.toArray(p);
		//for(Integer i:p) System.out.println(i);
		boolean br = false;
		for(int i=p.length; i>0; i--){
			for(int j=0; j<p.length-i; j++){
				long k = sumArray(p,j,i);
				if(k==-1) break;
				if(isPrime(k)){
					System.out.println(k+": "+i+" primes starting at"+p[j]);
					br = true;
					break;
				}
			}
			if(br) break;
		}
		
		System.out.println((System.currentTimeMillis()-t)+" Milliseconds");
	}	
	
	public static long sumArray(Integer[] A, int start, int len){
		long sum = 0;
		if(start+len>A.length) return -1;
		for(int i=start; i<start+len; i++){
			if(sum>1000000) return -1;
			sum+= A[i];
		}
		return sum;
	}
	
	public static void generatePrimes(){
		primes.add(2);
		primes.add(3);
		for(int i=1;6*i-1<1000000;i++){
			if(isPrime(6*i-1)) primes.add(6*i-1);
			if(isPrime(6*i+1)) primes.add(6*i+1);
		}
	}
	
	public static boolean isPrime(long n){
		for(int i:primes){
			if(i>Math.sqrt(n)+1) break;
			if(n%i==0) return false;
		}
		return true;
	}
}