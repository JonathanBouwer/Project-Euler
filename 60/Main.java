import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		long t = System.currentTimeMillis();
		ArrayList<Integer> primes = generatePrimes(10000);
		
		out:
		for(Integer i:primes){
			for(Integer j:primes){
				if(i.compareTo(j)<0) {
					ArrayList<Integer> a = new ArrayList<Integer>();
					a.add(i);
					a.add(j);
					if(!hasProperty(a,primes)) continue;
					System.out.printf("%5d\t%5d\n",i,j);
					for(Integer k:primes){
						if(j.compareTo(k)<0) {
							ArrayList<Integer> b = new ArrayList<Integer>(a);
							b.add(k);							
							if(!hasProperty(b,primes)) continue;
							System.out.printf("%5d\t%5d\t%5d\n",i,j,k);
							for(Integer l:primes){
								if(k.compareTo(l)<0){ 
									ArrayList<Integer> c = new ArrayList<Integer>(b);
									c.add(l);
									if(!hasProperty(c,primes)) continue;
									System.out.printf("%5d\t%5d\t%5d\t%5d\n",i,j,k,l);
									for(Integer m:primes){
										if(l.compareTo(m)<0){ 
											ArrayList<Integer> d = new ArrayList<Integer>(c);
											d.add(m);
											if(!hasProperty(d,primes)) continue;
											System.out.printf("%5d\t%5d\t%5d\t%5d\t%5d\n",i,j,k,l,m);
											System.out.println("Found");
											break out;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(System.currentTimeMillis()-t);
		
	}
	
	public static boolean hasProperty(ArrayList<Integer> x, ArrayList<Integer> p){
		Integer[] vals = new Integer[x.size()];
		x.toArray(vals);
		for(int i=0; i<vals.length-1; i++){
			if(!hasProperty(vals[i], vals[vals.length-1],p)) return false;
		}
		return true;
	}
	
	public static boolean hasProperty(int x, int y, ArrayList<Integer> p){
		return isPrime(Integer.parseInt(x+""+y),p)&&isPrime(Integer.parseInt(y+""+x),p);
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
