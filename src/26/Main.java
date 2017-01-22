import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		int max = 0;
		int mlen = 0;
		for(int i=2;i<1000;i++){
			
			int l = len(i);
			//System.out.println(i+" "+l);
			if(l>mlen){
				max = i;
				mlen = l;
				//System.out.println(l);
			}
		}
		System.out.println(max+" "+mlen);
	}
	
	public static int len(int i){
		ArrayList<Integer> prev = new ArrayList<Integer>();
		int cur = 1;
		while(cur<i) cur*=10;
		int z =0;
		while(true){
			if(cur==0) break;
			while(cur<i){cur*=10; z++; }
			if(prev.contains(cur%i)) return prev.size()-prev.indexOf(cur%i)+z;
			prev.add(cur%i);
			//System.out.println(cur%i);
			cur = cur%i*10;
		}
		return 0;
	}

}