
public class Main{
	public static void main(String[] args){
		StringBuilder s = new StringBuilder(1000010);
		int i=0;
		while(s.length()<1000010){
			i++;
			s.append(i);
			//System.out.println(s);
		}
		
		char[] c = s.toString().toCharArray();
		int out = 1;
		out*=(c[0]-48);
		out*=(c[9]-48);
		out*=(c[99]-48);
		out*=(c[999]-48);
		out*=(c[9999]-48);
		out*=(c[99999]-48);
		out*=(c[999999]-48);
		System.out.println(out);
		
	}
}
