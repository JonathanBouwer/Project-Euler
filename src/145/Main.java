public class Main{
	public static void main(String[] args){
		int count = 0;
		long t = System.nanoTime();
		for(long i=1;i<1e9;i++){
			if(isReversable(i)){
				//System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
		System.out.println((System.nanoTime()-t)/1e6+" milliseconds");
	}
	
	public static boolean isReversable(long n){
		long rn = 0;
		long l = n;
		if(n%10==0) return false;
		while(l!=0){
			rn+=l%10;
			l/=10;
			rn*=10;
		}
		rn/=10;
		long k = n + rn;
		
		while(k>0){
			if(k%2==0) return false;
			k/=10;
		}
		//System.out.printf("%d+%d=%d\n",n,rn,n+rn);
		return true;
	}
}
