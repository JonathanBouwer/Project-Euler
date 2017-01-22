import java.util.ArrayList;
import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		ArrayList<Integer> p = generatePrimes(7654321);
		//note 8 and 9 digit numbers which are pandigital are divisible by 3
		System.out.println("primes generated");
		//for(int i=0; i<1000; i++) if(isPandigital(i))System.out.println(i);
		//System.out.println("done");
		for(int j = p.size() - 1; j >= 0; j--){
			if(isPandigital(p.get(j))){System.out.println(p.get(j)); break;}
		}
	}
	
	public static boolean isPandigital(int n){
		if(n>987654321) return false;
		char[] c = (n+"").toCharArray();
		Arrays.sort(c);
		char[] e = new char[c.length];
		for(int i=0; i<e.length; i++){
			e[i] = ((i+1)+"").charAt(0);
		}
		return Arrays.equals(c,e);
	}
	
	public static ArrayList<Integer> generatePrimes(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		int prev = 100000;
		for(int i=1; 6*i+1<n;i++){
			if(isPrime(6*i-1, primes)) primes.add(6*i-1);
			if(isPrime(6*i+1, primes)) primes.add(6*i+1);
			//if(6*i+1>prev){ prev+=100000; System.out.println(6*i+1);}
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
