public class Main{
	public static void main(String[] args){
		long n = 1;
		for(int i=0;i<7830457;i++){
			n=n<<1;
			n%=100000000000L;
		}
		System.out.println(n*28433+1);
	}
}
