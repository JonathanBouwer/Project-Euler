import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		long curMax = 1;
		int curPos = 0;
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
		long t = System.nanoTime();
		out:
		for(int i:primes){
			curMax*=i;
			long cur = curMax;
			//System.out.printf("%d : %d/%d\n",cur,R(cur),cur-1);
			if(curPos>=8){
				while(cur<curMax*primes[curPos+1]){
					cur+=curMax;
					int R = R(cur);
					System.out.printf("%d : %d/%d\n",cur,R,cur-1);
					if(R/(double)(cur-1) <15499/94744.0) break out;
				}
			}
			curPos++;
		}
		System.out.printf("%.3f millisecons\n",(System.nanoTime()-t)/1000000);
	}
	
	public static int R(long d){
		int count = 0;
		ArrayList<Long> factors = new ArrayList<Long>();
		for(long i=1;i<d;i++){
			if(sharesFactor(i,factors)) continue;
			long l = gcd(d,i);
			if(l==1) count++;
			else factors.add(i);
		}
		//for(long p:factors) System.out.println(p); 
		return count;
	}
	
	public static boolean sharesFactor(long i, ArrayList<Long> a){
		for(long n:a){
			if(i%n==0){
				return true;
			}
		}
		return false;
	}
	
	public static long gcd(long n, long m){
		if(m==0) return n;
		long k = gcd(m,n%m);
		return k;
	}
}
