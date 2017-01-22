import java.util.TreeSet;

public class Main{
	public static void main(String[] args){
		TreeSet<Frac> fracs = new TreeSet<Frac>();
		int size = 1000000;
		Frac tos = new Frac(3L, 7L);
		Frac twos = new Frac(2L, 7L);
		for(long i=2; i<=size;i++){
			for(long j=299999*i/700000;j<=3*i/7;j++){
				Frac f = new Frac(j,i);
				fracs.add(f);
			}
			if(i%1000==0) System.out.println(i);
		}
		Frac prev = null;
		
		for(Frac f:fracs){
			//System.out.println(f);
			if(f.equals(tos)){ 
				System.out.println("\n"+prev);
				break;
			}
			
			prev = f;
		}
	}
	
}

class Frac implements Comparable<Frac>{
	long n,d;
	
	public Frac(long num, long denom){
		n=num;
		d=denom;
		long g = gcd(n,d);
		n/=g;
		d/=g;
	}

	private long gcd(long a, long b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	public Frac add(Frac o){
		return new Frac(n*o.d+o.n*d, d*o.d);
	}
	
	public Frac invert(){
		return new Frac(d,n);
	}
	
	public String toString(){
		return n+"/"+d;
	}
	
	public boolean equals(Frac o){
		return n==o.n&&d==o.d;
	}
	
	public int compareTo(Frac o){
		if(this.equals(o)) return 0;
		long k = n*o.d-o.n*d;
		if(k>0) return 1;
		return -1;
	}
}
