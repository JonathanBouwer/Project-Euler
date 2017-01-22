import java.util.ArrayList;
public class Main{
	public static void main(String[] args){
		int m = 1000000;
		int p = 1000000;
		long sum = 0;
		long t = System.currentTimeMillis();
		for(int k=2;k<=p;k++){
			if(k%10000==0){
				System.out.printf("M(%d,%d,s)\n",m,k);
				System.out.println(System.currentTimeMillis()-t);
			}
			int start = k/2!=0?k/2: 1;
			ArrayList<Integer> factors = factorize(k);
			for(Integer f : factors){
				int s = k-f.intValue();
				int val = m-s;
				int n = val+k-s;
				sum+=sum(n)-sum(val);
			}
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis()-t);
	}
	
	public static long sum(long n){
		return n*(n+1)/2;
	}
	
	public static ArrayList<Integer> factorize(int n){
		ArrayList<Integer> out = new ArrayList<Integer>();
		out.add(1);
		for(int i =2; i*i<=n; i++){
			if(n%i==0){
				out.add(i);
				if(i*i!=n)out.add(n/i);
			}
		}
		return out;
	}
}