public class Main{
	public static void main(String[] args){
		int[] n = new int[10001];
		for(int i=1; i<=10000; i++){
			for(int j=1; j<i; j++){
				double sum = i+j+Math.hypot(i,j);
				if(sum>10001) break;
				if(sum%1==0) n[(int)sum]++;
			}
		}
		int max = 0;
		int val = 0;
		for(int i=0; i<10001; i++){
			if(n[i]>max){
				max = n[i];
				val = i;
				System.out.println(i+" : "+max);
			}
		}
	}
}

