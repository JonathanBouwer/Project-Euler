public class Main{
	public static void main(String[] args){
		long t = System.currentTimeMillis();
		String[] s = generate("0123456789");
		System.out.println((System.currentTimeMillis()-t)+" Milliseconds");
		System.out.println(s[23]);
	}	
	
	public static String[] generate(String s){
		String[] ret = new String[fact(s.length())];
		
		if(s.length()==1) ret[0] = s;
		else{
			char[] a = s.toCharArray();
			int pos = 0;
			for(char c:a){
				String n = "";
				for(char p:a) if(p!=c) n=n+p;
				String[] nS= generate(n);
				for(String q:nS){
					ret[pos] = c+q;
					pos++;
				}				
			}
		}
		return ret;
	}
	
	public static int fact(int n){
		int p = 1;
		for(int i=1; i<=n ; i++) p*=i;
		return p;
	}
}