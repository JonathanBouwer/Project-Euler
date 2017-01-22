public class Main{
	public static void main(String[] args){
		int sum=0;
		for(int i =1; i<1000000;i++){
			if(isPalindrome(""+i)&&isPalindrome(backwardbase2(i))){
				sum+=i;
				System.out.println(i);
			}
		}	
		System.out.println(sum);
	}
	
	public static boolean isPalindrome(String s){
		StringBuilder sb = new StringBuilder(s);
		sb=sb.reverse();
		return sb.toString().equals(s);
	}
	
	public static String backwardbase2(int i){
		StringBuilder j = new StringBuilder();
		int o = i;
		while(i>0){
			j.append(i%2);
			i/=2;
		}
		//System.out.println(o+":"+j.toString());
		return j.toString();
	}
}
