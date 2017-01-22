public class Main{
	public static void main(String[] args){
		int maxlen = 0;
		int[] precomp = new int[1000000];
		for(int i=0;i<1000000;i++){
			precomp[i]= 0;
		}
		precomp[1] = 1;
		for(int i=2; i<1000000; i++){
			long current = i;
			int count = 0;
			if(i%100000==0)System.out.println(i);
			while(i<1000000){
				int x = (int) current;
				if((current<999999)&&(precomp[x]!=0)){
					
					precomp[i] = precomp[x]+count;
					break;
				}else{
					current = nextCollatz(current);
					//System.out.println(current);
					count++;
				}
			
			}
		}
		int k = 0;
		for(int i:precomp){
			k++; 
			if(maxlen<i){
				maxlen=i; 
				System.out.println("new maxlen"+maxlen+" @"+k);
			}
		}
		System.out.println(maxlen);
	}
	
	public static long nextCollatz(long i){
		if(i%2==0) return i/2;
		return 3*i+1;
	}
	
}