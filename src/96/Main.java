import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[][] test = {{0,0,3,0,2,0,6,0,0},
						{9,0,0,3,0,5,0,0,1},
						{0,0,1,8,0,6,4,0,0},
						{0,0,8,1,0,2,9,0,0},
						{7,0,0,0,0,0,0,0,8},
						{0,0,6,7,0,8,2,0,0},
						{0,0,2,6,0,9,5,0,0},
						{8,0,0,2,0,3,0,0,9},
						{0,0,5,0,1,0,3,0,0}};
	while(sc.hasNext()){
			System.out.print(sc.next());
			System.out.println(" "+sc.next());
			long t = System.currentTimeMillis();
			int[][] grid = new int[9][9];
			for(int i=0;i<9;i++){
				String s = sc.next();
				for(int j=0;j<9;j++){
					grid[i][j] = s.charAt(j)-48;
				}
			}
			int[][] empties = findEmpties(grid);
			printGrid(grid);
			grid = solveGrid(grid,empties,0);
			printGrid(grid);
			System.out.println(System.currentTimeMillis()-t);
			sum+=100*grid[0][0];
			sum+=10*grid[0][1];
			sum+=grid[0][2];
		}
		System.out.println(sum); 
		
	}
	
	public static int[][] solveGrid(int[][] grid, int[][] empties, int p) {
		if(p==empties.length) return grid;
		int[][] temp = new int[9][9];
		for(int i=0;i<9;i++) for(int j=0;j<9;j++) temp[i][j] = grid[i][j];
		
		int x = empties[p][0];
		int y = empties[p][1];
		
		for(int i=1;i<10;i++) {
			temp[y][x] = i;
			//for(int j=0;j<p;j++) System.out.print(" ");
			//System.out.printf("(%d,%d):%d\n",x,y,i);
			if(isValid(temp)) {
				
				//System.out.println("Valid");
				//printGrid(temp);
				temp = solveGrid(temp, empties, p+1);
				if(p+1==empties.length) return temp;
				int newx = empties[p+1][0];
				int newy = empties[p+1][1];
				if(temp[newy][newx]!=0) break;
			}
		}
		if(!isValid(temp)) temp[y][x]=0;
		else if(!isComplete(temp)) temp[y][x]=0;
		return temp;
	}
	
	public static int[][] findEmpties(int[][] grid){
		int count = 0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j]==0){ count++;}
			}
		}
		int[][] out = new int[count][2];
		count = 0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j]==0){
					
					out[count][0] = j;
					out[count][1] = i;
					count++;
				}
			}
		}
		return out;
	}
	
	public static void printGrid(int[][] grid){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++) System.out.print(grid[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isValid(int[][] grid){
		boolean isValid=true;
		//rows
		for(int i=0;i<9;i++) isValid=isValid&&isValidRange(grid,0,i,8,i);
		//cols
		for(int j=0;j<9;j++) isValid=isValid&&isValidRange(grid,j,0,j,8);
		//blocks
		for(int i=0;i<3;i++) for(int j=0;j<3;j++) isValid=isValid&&isValidRange(grid,3*i,3*j,3*i+2,3*j+2);
		return isValid;
	}
	
	public static boolean isComplete(int[][] grid){
		for(int i=0;i<9;i++) for(int j=0;j<9;j++) if(grid[i][j]==0) return false;
		return true;
	}
	
	public static boolean isValidRange(int[][] grid, int xstart, int ystart, int xend, int yend){
		int[] used = {-10,0,0,0,0,0,0,0,0,0};
		int xpos,ypos;
		for(int i=ystart;i<=yend;i++){
			for(int j=xstart;j<=xend;j++){
				used[grid[i][j]]++;
				if(used[grid[i][j]]>1) return false;
			}
		}
		return true;
	}
}
