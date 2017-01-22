public class Main{
	static int[][] memo = new int[101][101];
	
	public static void main(String[] args){
		System.out.println(part(100,100)-1);
	}
	
	public static int part(int n, int m){
		if(memo[n][m]!=0) return memo[n][m];
		int sum=0;
		if(n<=1) return 1;
		if(m>n) return part(n,n);
		for(int i=1;i<=m;i++){
			sum+= part(n-i,i);
		}
		memo[n][m] = sum;
		return sum;
	}
}
