public class Main{
	public static void main(String[] args){
		int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
		
		for(int i=3; i<9999999; i++){
			char[] ch = (""+i).toCharArray();
			int sum = 0;
			for(char c:ch) sum+=fact[c-48];
			if(i==sum) System.out.println(i);
		}
	}	
}