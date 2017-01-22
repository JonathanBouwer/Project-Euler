public class Main{
	public static void main(String[] args){
		long sum=0, squares=0;
		for(int i=1;i<=100;i++){
			sum+=i;
			squares+=i*i;
		}
		System.out.println(sum*sum-squares);
	}
	
}