public class Main{

	public static void main(String []Args){
		int x=1,y=1,total=0;
		while(y<4000000){
			
			int temp = y;
			y=x+y;
			x=temp;
			System.out.print(x+", ");
			if(x%2==0){
				total+=x;
			}
		}
		System.out.println("\n"+total);
	}
}