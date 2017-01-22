import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		int size = 28124;
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for(int i=1;i<size;i++) if(divisorSum(i)>i) abundant.add(i);
		Integer[] ab = new Integer[abundant.size()];
		abundant.toArray(ab);
		long sum = 0;
		boolean[] isSum = new boolean[size];
		for(boolean b:isSum) b = false;
		//for(int i:ab) System.out.println(i);
		System.out.println();
		for(int j=0;j<ab.length;j++){
			for(int k=j; k<ab.length;k++){
				if(ab[k]+ab[j]<size){
					isSum[ab[k]+ab[j]] = true;
				}else{
					break;
				}
			}
		}
		
		for(int i=0;i<size;i++) if(!isSum[i]){ sum+=i; }//System.out.println(i);}
		System.out.println(sum);
	}
	
	public static int divisorSum(int n){
		int sum = 0;
		for(int i=1; i<n/2+1;i++) if(n%i==0)sum+=i;
		return sum;
		
	}
}