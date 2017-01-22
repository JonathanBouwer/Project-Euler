public class Main{
	public static void main(String[] args){
		int size = 10000000;
		int[] vals = new int[size];
		vals[1] = 1;
		vals[89] = 89;
		for(int i=2;i<size;i++){
			int current = squ(i);
			//System.out.println(current);
			while(true){
				//System.out.println(current);
				if(current<size){
					if(vals[current]!=0){
						vals[i] = vals[current];
						//System.out.printf("%d:%d\n",i,vals[i]);
						break;
					}
					
				}
				current=squ(current);
			}
		}
		int count = 0;
		for(int i:vals) if(i==89) count++;
		System.out.println(count);
	}
	
	public static int squ(int n){
		int out = 0;
		while(n>0){
			out+=(n%10)*(n%10);
			n/=10;
		}
		return out;
	}
}
