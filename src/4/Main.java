public class Main{
	public static void main(String[] args){
		int max = 0;
		for(int i = 999; i>99; i--){
			for(int j = i; j>99; j--){
				if(isPalindrome(i*j)) if(i*j>max){ max = i*j; System.out.println(i+", "+j);}
			}
		}
		System.out.println(max);
	}
	
	public static boolean isPalindrome(int x){
		String s  = x+"";
		//System.out.println();
		for(int i=0; i<s.length(); i++){
			char a = s.charAt(i);
			char b = s.charAt(s.length()-i-1);
			//System.out.print(a+" "+b+", ");
			if(a!=b) return false;
		}
		
		return true;
	}
}