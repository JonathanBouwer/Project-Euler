import java.util.TreeSet;
public class Main{
	public static void main(String[] args){
		int count = 0;
		long time = System.nanoTime();
		for(int i=0;i<1000000;i++){
			if(chainLen(i)==60){
				count++;
			}	
		}
		System.out.println(count);
		System.out.printf("%.3f milliseconds\n", (System.nanoTime()-time)/1e6);
	}
	
	public static int chainLen(int n){
		TreeSet<Integer> t = new TreeSet<Integer>();
		while(t.add(n)){
			n=factSum(n);
		}
		return t.size();
	}
	
	public static int factSum(int n){
		int[] facts = {1,1,2,6,24,120,720,5040,40320,362880};
		int out = 0;
		while(n!=0){
			out+=facts[n%10];
			n/=10;
		}
		return out;
	}
}
