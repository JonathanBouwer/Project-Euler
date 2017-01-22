import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		long t = System.nanoTime();
		double max = 0.0;
		for(int i=1;i<1000;i++){
			ArrayList<Integer> c = genRelativePrimes(i);
			double cur = i/(double)c.size();
			if(cur>max){
				max = cur;
				System.out.printf("%d/phi(%d)=%.3f\n",i,i,cur);
			}	
			if(i%1000==0) System.out.println(i);
		}
		System.out.println("Notice this is simply 1*2*3*5*7*11*...");
		int i = 1;
		int c = 0;
		int[] primes = {2,3,5,7,11,13,17,23};
		System.out.print("1");
		while(i<1000000){ i*=primes[c];c++;if(i<1000000)System.out.print("*"+primes[c-1]);}
		i/=primes[c-1];
		System.out.println("="+i);
		System.out.printf("Time: %.3f milliseconds\n",(System.nanoTime()-t)/1000000.0);
	}
	
	public static ArrayList<Integer> genRelativePrimes(int n){
		ArrayList<Integer> out = new ArrayList<Integer>();
		out.add(1);
		for(int i=2;i<n;i++){
			boolean shouldAdd = true;
			for(int j=2;j<=i;j++){
				if(i%j==0&&n%j==0) shouldAdd=false;
			}
			if(shouldAdd) out.add(i);
		}
		return out;
	}
}
