import java.util.ArrayList;
import java.util.TreeSet;
public class Main{
	public static void main(String[] args){
		ArrayList<Integer> primes = generatePrimes(7100);
		TreeSet<Integer> t = new TreeSet<Integer>();
		int count = 0;
		int size = 50000000;
		for(int i:primes){
			int p = i*i;
			for(int j:primes){
				int l = p+j*j*j;
				for(int k:primes){
					int q = l+k*k*k*k;
					if(q>=size) break;
					count++;
					t.add(q);
					//if(!t.add(q)) System.out.println(q+" dupe");
					//System.out.printf("%d^2+%d^3+%d^4=%d\n",i,j,k,q);
				}
				if(l>=size) break;
			}
			if(p>=size) break;
		}
		System.out.println(t.size());
		System.out.println(count);
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
