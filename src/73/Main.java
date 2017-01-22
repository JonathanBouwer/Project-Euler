import java.util.TreeSet;

public class Main{
	public static void main(String[] args){
		TreeSet<Frac> fracs = new TreeSet<Frac>();
		int size = 12000;

		for(long i=2; i<=size;i++){
			for(long j=(i-1)/3;j<=(i+1)/2;j++){
				Frac f = new Frac(j,i);
				fracs.add(f);
			}
			if(i%1000==0) System.out.println(i);
		}
		boolean start = false;
		int count = 0;
		for(Frac f:fracs){
			if(f.n/(double)f.d>1.0/3) start = true; 
			if(f.n/(double)f.d>=1.0/2) break;
			if(start){
				//System.out.println(f);
				count++;
			}	
		}
		System.out.println(count);
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
