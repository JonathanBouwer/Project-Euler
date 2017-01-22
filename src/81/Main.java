import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[80][80];
		for(int i=0; i<80; i++){
			for(int j=0;j<80;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int[][] b = new int[80][80];
		b[0][0] = a[0][0];
		for(int i=1; i<80; i++){
			b[i][0] = b[i-1][0]+a[i][0];
			b[0][i] = b[0][i-1]+a[0][i];
		}
		for(int i=1; i<80; i++){
			for(int j=1; j<80; j++){
				b[i][j] = Math.min(b[i-1][j],b[i][j-1])+a[i][j];
			}	
		}
		System.out.println(b[79][79]);
	}
	
}