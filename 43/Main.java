import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		ArrayList<String> s = permute("0123456789");
		
		long sum = 0;
		System.out.println(System.currentTimeMillis()-start);
		for(String st:s) if(checkProperties(st)){ /*System.out.println(st);*/ sum+= Long.parseLong(st); }
		System.out.println(sum);
		System.out.println(System.currentTimeMillis()-start);
	}
	
	public static boolean checkProperties(String s){
		int[] prime = {2,3,5,7,11,13,17};
		char speed = s.charAt(3);
		if((speed!='0')||(speed!='2')||(speed!='4')||(speed!='6')||(speed!='8'))
		for(int i=0;i<7;i++){
			String st = "";
			for(int j = 1+i; j<1+i+3; j++) st = st+s.charAt(j);
			if(Long.parseLong(st)%prime[i]!=0) return false;
		}

		return true;
	}
	
	public static ArrayList<String> permute(String s){
		ArrayList<String> out = new ArrayList<String>();
		if(s.length()==1){ out.add(s); return out;}
		
		char[] ch = s.toCharArray();
		for(char c1:ch){
			StringBuilder sb = new StringBuilder();
			for(char c2:ch){
				if(c1!=c2) sb.append(c2);
			}
			ArrayList<String> temp = permute(sb.toString());
			for(String st:temp) out.add(c1+st);
		}
		
		return out;
	}
}
