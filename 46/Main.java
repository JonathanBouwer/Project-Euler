import java.util.ArrayList;

public class Main{
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String[] args){
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		for(int i=9; ;i+=2){
			if(isPrime(i)){
				primes.add(i);
			}else if(!isGoldbach(i)){
				System.out.println("Breaking case: "+i+"!");
				break;
			}
			if(i%1001==0) System.out.println(i);
		}
	}
	
	public static boolean isGoldbach(int n){
		for(Integer p:primes){
			int v = p.intValue();
			for(int i=1;v+2*i*i<=n; i++){
				if(v+2*i*i==n){
					System.out.println(n+" = "+v+"+"+"2*"+i+"^2");
					return true;
				}
			}
		}
		return false;
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

