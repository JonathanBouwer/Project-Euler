import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt()+1;
		int[][] arr = new int[size][size];
		
		int count = 0;
		for(int j=0;j<size;j++){
			for(int i=0;i<count;i++){
				arr[count][i] = sc.nextInt();
			}
			count++;
		}
		/*
		for(int j=0;j<size;j++){
			for(int i=0;i<j;i++){
				System.out.print(arr[j][i]+ " ");
			}
			System.out.println();
		}
		*/
		for(int i=size-2;i>=0;i--){
			for(int j=0;j<i;j++){
				arr[i][j] = arr[i][j]+ (arr[i+1][j]>arr[i+1][j+1]?arr[i+1][j]:arr[i+1][j+1]);
			}
		}
		/*
		for(int j=0;j<size;j++){
			for(int i=0;i<j;i++){
				System.out.print(arr[j][i]+ " ");
			}
			System.out.println();
		}
		*/
		System.out.println(arr[1][0]);
	}
}