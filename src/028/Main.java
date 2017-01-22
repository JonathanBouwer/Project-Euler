public class Main{
	public static void main(String[] args){
		int total = 1, current = 1, add = 2;
		while(current<1001*1001){
			for(int i =0; i<4; i++){
				current = current+add;
				total = total+current;				
			}
			add+=2;
		}
		System.out.println(total);
	}
	
}