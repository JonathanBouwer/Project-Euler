public class Main{
	public static void main(String[] args){
		int a=1, b=1;
		while(a+b+Math.sqrt(a*a+b*b)<=1000){
			while(a+b+Math.sqrt(a*a+b*b)<=1000){
				b++;
				if(a+b+Math.sqrt(a*a+b*b)==1000) System.out.println(a+" "+b+" "+Math.sqrt(a*a+b*b));
			}
			a++;
			b=a;
			if(a+b+Math.sqrt(a*a+b*b)==1000) System.out.println(a+" "+b+" "+Math.sqrt(a*a+b*b));
		}
		System.out.println();
	}
	
}