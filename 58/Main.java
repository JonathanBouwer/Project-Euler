import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		int total = 5;
		ArrayList<Integer> primes = generatePrimes(1000000);
		int v = 0;
		int val = 4;
		double count = 3;
		for(int i=4;count/total>0.1;i++){
			//System.out.println(i*i);
			
			if(i%2==1){
				v = i*i-val;
				//System.out.println(v);
				if(isPrime(v,primes)) count++;
				//vals[k] = i*i
				total++;
				total++;
				System.out.println(count+"/"+total+"=" +(count/total)+" "+(val+1));
				val+=2;
			}else{
				v= i*i+1-val;
				if(isPrime(v,primes)) count++;
				//System.out.println(v);
				total++;
				v = i*i+1;	
				if(isPrime(v,primes)) count++;	
				//System.out.println(v);
				total++;		
			}
		}
		//for(int l:vals) System.out.println(l);		
		//for(Integer i:primes) System.out.println(i);
		System.out.println(count/total+" "+total+" "+(val+1));
	}
	
	public static ArrayList<Integer> generatePrimes(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(2);
		p.add(3);
		int c = 1;
		while(6*c+1<=n){
			if(isPrime(6*c-1,p)) p.add(6*c-1);
			if(isPrime(6*c+1,p)) p.add(6*c+1);
			c++;
		}
		return p;
	}
	
	public static boolean isPrime(int n, ArrayList<Integer> p){
		if(n==1||n==0) return false;
		for(Integer i:p){
			if(i*i>n) break;
			if(n%i==0) return false;
		}
		return true;
	}
}
