import java.util.Scanner;
import java.util.ArrayList;
public class Main{
	public static void main(String[] args){
		ArrayList<Integer> in = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			in.add(sc.nextInt());
		}
		System.out.println((char)('A'^'*'));
		String s = "";
		for(int i='g';i<='g';i++){
			for(int j='o';j<='o';j++){
				for(int k='d';k<='d';k++){
					int p=0;
					boolean should = true;
					StringBuilder sb = new StringBuilder();
					//sb.append((char)i+""+(char)j+""+(char)k+" : ");
					for(Integer a:in){
						int val = k;
						if(p==0) val = i;
						if(p==1) val = j;
						char c = (char)( a.intValue()^val);
						if(!(32<=c&&c<126)){ should = false; break;}
						sb.append(c);						
						p++;
						p%=3;
					}
					s=sb.toString();
				}
			}
		}
		char[] c = s.toCharArray();
		int sum = 0;
		for(char ch:c) sum+=ch;
		System.out.println(s+"\n"+sum);
	}
	
}
