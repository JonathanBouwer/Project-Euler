import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
public class Main{
	public static void main(String[] args){
		long t = System.nanoTime();
		ArrayList<Long> cubes = new ArrayList<Long>();
		int length = 0;
		int finalCount = 3;
		boolean Found = false;
		long i = 1;
		while(!Found){
			cubes.clear();
			System.out.print(i);
			while((i*i*i+"").length() == length){
				cubes.add(i*i*i);
				i++;
			}
			System.out.println("-"+(i-1)+":"+length);
			length++;
			int count = 0;
			for(long c:cubes){
				System.out.println(Math.round(Math.pow(c,1/3.0)));
				for(long c2:cubes){
					if(isPerm(c+"",c2+"")){
						count++;
					}
				}
				if(count>=finalCount){
					//System.out.println(c);
					for(long c2:cubes){
						if(isPerm(c+"",c2+"")){
							System.out.println(c2);
						}
					}
					Found=true;
					break;
				}
				count = 0;
			}
			System.out.println((System.nanoTime()-t)/1000000.0+" milliseconds");
		}
		
	}
	
	public static boolean isPerm(String s1,String s2){
		if(s1.length()!=s2.length()) return false;
		//if(s1.equals(s2)) return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i=0; i<c1.length;i++){
			if(c1[i]!=c2[i]) return false;
		}	
		return true;
	}
	
	public static TreeSet<String> permute(String s){
		TreeSet<String> out = new TreeSet<String>();
		if(s.length()==1){out.add(s); return out;}
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++){
			//if(ch[i]==48) continue;
			StringBuilder temp = new StringBuilder();
			for(int j=0;j<ch.length;j++) if(i!=j) temp.append(ch[j]);
			for(String stt:permute(temp.toString())){
				out.add(ch[i]+stt);
			}
		}
		return out;
	}
	
}
