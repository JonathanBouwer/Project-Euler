import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNext()){
			String s = sc.next();
			if(isTriangular(sumN(s))){
				count++;
				System.out.println(s+" "+sumN(s));
			}
		}	
		System.out.println(count);
	}

	public static int sumN(String s){
		s=s.toLowerCase();
		char[] ch = s.toCharArray();
		int sum = 0;
		for(char c:ch) sum += c-96;
		return sum;
	}
	
	public static boolean isTriangular(int n){
		return Math.sqrt(1+8*n)%1==0;
	}
}