
public class Main{
	public static void main(String[] args){
		long t = System.currentTimeMillis();

		int sum =0;
		int[] pows = {0,1,32,243,1024,3125,7776,16807,32768,59049};
		for(int i=2;i<999999;i++){
			char[] s = (""+i).toCharArray();
			int part = 0;
			for(char c:s) part+=pows[c-48];
			if(part==i){
				sum+=i;
				System.out.println(i);
			}
		}
		System.out.println(sum);
		
		
		System.out.println((System.currentTimeMillis()-t)+" Milliseconds");
	}	
}