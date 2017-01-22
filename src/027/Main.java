import java.util.ArrayList;
public class Main{
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args){
		long t = System.currentTimeMillis();
		generatePrimes();
		int[] p = new int[primes.indexOf(997)+1];
		for(int i=0; i<p.length;i++) p[i] = primes.get(i);
		int a = 0;
		int b = 0;
		int maxlen=0;

		
		for(int i=-999; i<1000; i++){
			for(int j:p){
				int cur = 0;
				int val = cur*cur+i*cur+j;
				while(isPrime(val)){
					cur++;
					val = cur*(cur+i)+j;
				}
				if(cur>maxlen){
					maxlen = cur;
					a = i;
					b = j;
					//System.out.println("n^2+"+a+"n+"+b+" lists "+maxlen+" primes");
				}				
			}
		}
		
		System.out.println(a*b);
		System.out.println((System.currentTimeMillis()-t)+" Milliseconds");
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