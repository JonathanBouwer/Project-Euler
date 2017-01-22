public class Main{
	public static void main(String[] args){
		int count = 0;
		int n = 10;
		while(count/(n*1.0)<0.99){
			n++;
			if(isBouncy(n)){
				count++;
				//System.out.println(n);
			}
		}
		System.out.println(n);
		System.out.println(count);
	}
	
	public static boolean isBouncy(int n){
		char[] ch = (n+"").toCharArray();
		if(ch.length==1) return false;
		return !isIncreasing(n) && !isDecreasing(n);
	}
	
	public static boolean isIncreasing(int n){
		char[] ch = (n+"").toCharArray();
		if(ch.length==1) return false;
		char prev = 47;
		for(char c:ch){
			if(prev>c) return false;
			prev =c;
		}
		return true;
	}
	
	public static boolean isDecreasing(int n){
		char[] ch = (n+"").toCharArray();
		char prev = 60;
		if(ch.length==1) return false;
		for(char c:ch){
			if(prev<c) return false;
			prev =c;
		}
		return true;
	}
}
