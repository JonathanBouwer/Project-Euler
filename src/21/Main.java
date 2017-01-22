public class Main{
	public static void main(String[] args){
		int[] sums = new int[10000];
		for(int i =0; i<10000; i++) sums[i] = divisorSum(i+1);
		int sum = 0;
		for(int i =1; i<10000; i++){
			if((sums[i]<10000)&&(sums[sums[i]-1] == i+1)&&(i!=sums[i]-1)) sum+=i+1;	
		}
		System.out.println(sum);
		System.out.println(sums[220]);
		System.out.println(sums[219]);
		System.out.println(sums[284]);
		System.out.println(sums[283]);
	}
	
	public static int divisorSum(int n){
		int sum = 0;
		for(int i=1; i<n/2+1;i++) if(n%i==0)sum+=i;
		return sum;
		
	}
}