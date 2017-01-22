import java.util.ArrayList;
public class Main{
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String[] args){
		generatePrimes(1000000);
		ArrayList<Integer> used = new ArrayList<Integer>();
		used.add(2);
		for(Integer p:primes){
			if(!used.contains(p)&&!containsEven(p)){
				ArrayList<Integer> perms = genPerms(p);
				if(shouldAdd(perms)){
					for(Integer pe:perms) if(!used.contains(pe)) used.add(pe);
				}
				
			}
		}
		for(Integer i:used)System.out.println(i);
		System.out.println("Size :"+used.size());
	}
	
	public static ArrayList<Integer> genPerms(Integer n){
		String s = n.toString();
		ArrayList<String> sq = genPerms(s);
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(String st: sq) out.add(Integer.parseInt(st));
		return out;
	}
	
	public static ArrayList<String> genPerms(String s){
		ArrayList<String> st = new ArrayList<String>();
		st.add(s);
		if(s.length()==1) return st;
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		while(!sb.toString().equals(s)){
			sb.delete(0, sb.length());
			for(int i=1; i<c.length; i++) sb.append(c[i]);
			sb.append(c[0]);
			st.add(sb.toString());	
			c = sb.toString().toCharArray();		
		}
		return st;
	}
	
	public static boolean shouldAdd(ArrayList<Integer> n){
		for(Integer i:n) if(!isPrime(i)) return false;		
		return true;
	}
	
	public static boolean containsEven(Integer n){
		char[] c = n.toString().toCharArray();
		for(char ch:c) if((ch=='0')||(ch=='2')||(ch=='4')||(ch=='6')||(ch=='8')) return true;		
		return false;
	}
	
	public static void generatePrimes(int n){
		primes.add(2);
		primes.add(3);
		for(int i=1; 6*i+1<n;i++){
			if(isPrime(6*i-1)) primes.add(6*i-1);
			if(isPrime(6*i+1)) primes.add(6*i+1);
		}
	}
	
	public static boolean isPrime(int n){
		double d = Math.sqrt(n);
		int v = primes.get(0).intValue();
		for(int i=0; v<=d; i++){
			if(n%v==0) return false;
			v=primes.get(i).intValue();
		}
		return true;
	}
}
