import java.util.Arrays;
import java.util.ArrayList;
public class Main{
	public static void main(String[] args){
		//System.out.println(isPanDigital(39,186));
		ArrayList<Integer> products = new ArrayList<Integer>();
		int pos = 0;
		for(int i=1; i<100000;i++){
			for(int j=i; j<100000;j++){
				if((i+""+j+""+i*j).length() < 9) continue;
				if((i+""+j+""+i*j).length() > 9) break;
				if(isPanDigital(i,j)){
					System.out.printf("%d*%d=%d\n",i,j,i*j);
					if(!products.contains((Integer)i*j)){
						products.add(i*j);
						pos++;
					}
				}
			}
			//if(i%1000==0)System.out.println(i);
		}
		int sum = 0;
		for(int i:products){ System.out.println(i); sum+=i;}
		System.out.println(sum);
	}
	
	public static boolean isPanDigital(int l, int j){
		int product = l*j;
		char[] s = (l+""+j+""+product).toCharArray();
		if(s.length!=9) return false;
		Arrays.sort(s);
		//for(int i=0;i<9;i++) System.out.println(s[i]);		
		for(int i=0;i<9;i++){
			if(s[i]!=(i+1+48)) return false;
		}
		return true;
	}
}
