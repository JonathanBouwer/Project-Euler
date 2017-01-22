import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		int val = 1;
		while(!hasProperty(val)) val++;
		System.out.println(val);
	}
	
	public static boolean hasProperty(int n){
		char[] c = (n+"").toCharArray();
		Arrays.sort(c);
		for(int i=2; i<7;i++){
			char[] ch = (i*n+"").toCharArray();
			Arrays.sort(ch);
			if(!Arrays.equals(ch, c)) return false;
		}
		return true;
	}
}
