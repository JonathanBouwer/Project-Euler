import java.util.*;

public class Main{
	public static void main(String[] args){
		ArrayList<String> s = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			s.add(sc.next());
		}
		Collections.sort(s);
		/*
		System.out.println(s.get(937));
		char[] tempq = s.get(937).toCharArray();
		long xt = 0;
		for(char c:tempq){
			xt+=c-64;
			
		}
		System.out.println(xt);
		xt*=938;
		*/
		long sum = 0;
		for(int i=0;i<s.size();i++){
			char[] temp = s.get(i).toCharArray();
			long x = 0;
			for(char c:temp){
				x+=c-64;
			}
			x*=(i+1);
			sum+=x;
		}
		System.out.println(sum);
	}
	
}