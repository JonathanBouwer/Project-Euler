import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		int max = 0;
		long l = System.currentTimeMillis();
		for(int i = 1; i<100;i++){
			for(int j=1;j<100;j++){
				BigInteger b = new BigInteger(i+"");
				int n = sum(b.pow(j).toString());
				max = n>max? n:max;
			}
		}
		System.out.println(max+"\n"+(System.currentTimeMillis()-l));
	}
	
	public static int sum(String s){
		char[] c = s.toCharArray();
		int sum = 0;
		for(char ch:c) sum+=ch-48;
		return sum;
	}
}
