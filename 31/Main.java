import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		int[][] c = new int[201][8];
		int[] vals = {1,2,5,10,20,50,100,200};
		Arrays.fill(c[0],1);

		for(int i=1; i<201; i++){
			int max = 0;
			for(int j=0; j<vals.length; j++){
				int pos = i-vals[j];
				if(pos<0) break;
				c[i][0] = c[i][0]+c[pos][0];
			}	

		}
		System.out.println(c[200][7]);
	}
}