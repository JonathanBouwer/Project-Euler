public class Main{
	public static void main(String[] args){
		long current = 1, count = 2;
		while(numfactors(current, false)<=500){
			current+=count;
			count++;
			//System.out.println(current);
		}
		System.out.println(current);
		System.out.println(numfactors(current, true));
	}
	
	public static int numfactors(long x, boolean print){
		int out = 0;
		for(int i =1; i<=Math.sqrt(x);i++){
			if(x%i==0){
				if(print) System.out.println(i + ","+ x/i+" , ");
				out++;
				out = i*i==x? out: out+1;
			}
		}
		return out;
	}
}