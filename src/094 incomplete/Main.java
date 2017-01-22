import java.util.ArrayList;

public class Main{
	static ArrayList<Integer> primes;
	public static void main(String[] args){
		long sum = 0;
		for(int i=2;i<=1.27e8;i++){
			if((i>3.5*1e7)&&(i<1.22*1e8)) continue;
			int v1 = 3*i-1;
			int v2 = 3*i+1;
			int v3 = i+1;
			int v4 = i-1;
			double d1 = Math.sqrt(v1)*Math.sqrt(v3);
			double d2 = Math.sqrt(v2)*Math.sqrt(v4);
			if(d1%1==0){
				sum+=3*i+1;
				System.out.printf("(%d,%d,%d)\n",i,i,i-1);
			}
			if(d2%1==0){
				sum+=3*i-1;
				System.out.printf("(%d,%d,%d)\n",i,i,i+1);
			}
		}
		System.out.println(sum);
	}
}