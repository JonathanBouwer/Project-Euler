import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int linenum = 0;
		int maxLine = 0;
		double max = 0;
		while(sc.hasNext()){
			linenum++;
			int x = sc.nextInt();
			int y = sc.nextInt();
			double ylnx = y*Math.log(x);
			if(ylnx>max){
				max = ylnx;
				maxLine = linenum;
				System.out.println(linenum+" "+x+","+y);
			}
		}
	}
}
