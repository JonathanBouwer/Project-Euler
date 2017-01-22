public class Main{

	static int[] p = new int[60000];
	public static void main(String[] args){
		long t = System.nanoTime();
		p[0]=1;
		for(int i=0;i<60000;i++) if(partition2(i)==0) System.out.println("p("+i+")="+p[i]);
		System.out.printf("%.3f milliseconds",(System.nanoTime()-t)/1e6);
	}

	public static int partition2(int n){
		//partition(n) = sum (-1^(abs(m)-1)*partition(n-k)) 
		//where k is the m'th generalized pentagonal number and m element of {0,1,-1,2,-2,...}
		//due to euler or something
		if(n==0) return 1;
		int cur = 1;
		int out = 0;
		int pent = pent(cur);
		while(pent<=n&&pent>0){
			if(Math.abs(cur)%2==1){
				out+=p[n-pent];
			}else{
				out-=p[n-pent];
			}
			if(cur<0) cur=cur*-1+1;
			else cur = -1*cur;
			pent = pent(cur);
		}
		
		p[n] = out%1000000;
		return p[n];
	}

	public static int pent(int n){
		return (3*n*n-n)/2;
	} 
}
