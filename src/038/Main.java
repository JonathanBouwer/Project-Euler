import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	public static void main(String[] args){
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(1);
		v.add(2);
		int toBeInserted = 3;
		int max = 0;
		System.out.println("SIZE: "+v.size());
		while(toBeInserted!=10){
			int cur = 1;
			while(Math.log10(cur)*v.size()<10){
				StringBuilder sb = new StringBuilder();
				for(Integer i:v){
					sb.append(i.intValue()*cur);
				}
				if(isPandigital(sb.toString())){
					System.out.println(cur+" : "+sb.toString());
					max = cur>max? cur:max;
				}
				cur++;
			}
			v.add(toBeInserted);
			toBeInserted++;
			System.out.println("SIZE: "+v.size());
		}
	}
	
	public static boolean isPandigital(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		char[] p = {49,50,51,52,53,54,55,56,57};
		return Arrays.equals(c, p);
	}
}
