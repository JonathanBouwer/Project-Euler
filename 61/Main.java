import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ListIterator;
public class Main{
	public static void main(String[] args){
		long t = System.nanoTime();
		ArrayList<ArrayList<Integer>> types = new ArrayList<ArrayList<Integer>>();
		types.add(genNums(0.5,0.5));
		types.add(genNums(1,0)); 
		types.add(genNums(1.5,-0.5)); 
		types.add(genNums(2,-1)); 
		types.add(genNums(2.5,-1.5)); 
		types.add(genNums(3,-2)); 
		/*
		int[][][] count = count(types);
		
		boolean removed = true;
		while(removed){
			removed = false;
			int aNum = 0;
			for(ArrayList<Integer> a:types){ 
				ListIterator<Integer> li = a.listIterator();
				while(li.hasNext()){
					Integer i = li.next();
					int prefix = i/100;
					int suffix = i%100;
					if(!containsOutside(count[prefix][1], aNum)||!containsOutside(count[suffix][0], aNum)){
						count[prefix][0][aNum]--;
						count[suffix][1][aNum]--;
						li.remove();
						removed = true;
					}
				}
				aNum++;
			}
		}
		*/
		ArrayList<ArrayList<Vertex>> graph = new ArrayList<ArrayList<Vertex>>();
		int counts = 0;
		for(ArrayList<Integer> a:types){ 
			ArrayList<Vertex> b = new ArrayList<Vertex>();
			for(int i:a){
				b.add(new Vertex(i,counts));
			}
			graph.add(b);
			counts++;
		}
		counts = 0;
		int incount = 0;
		for(ArrayList<Vertex> a:graph){ 
			for(Vertex v:a){
				incount = 0;
				for(ArrayList<Vertex> b:graph){ 
					if(counts!=incount){
						for(Vertex w:b){
							if(v.suffix==w.prefix) w.v.add(v);
						}
					}
					incount++;
				}
			}
			counts++;
		}
		
		
		ArrayDeque<ArrayDeque<Vertex>> stack = new ArrayDeque<ArrayDeque<Vertex>>(); 
		ArrayList<Vertex> a = graph.get(5);
		for(Vertex v:a){
			ArrayDeque<Vertex> l = new ArrayDeque<Vertex>();
			l.push(v);
			stack.push(l);
		}
		
		while(!stack.isEmpty()){
			ArrayDeque<Vertex> l = stack.pop();
			/*for(Vertex w:l){
				System.out.print(w.prefix+""+w.suffix+" ");
			}*/
			//System.out.println();
			if(l.size()==6){
				if(l.peekFirst().prefix!=l.peekLast().suffix){
					continue;
				}
				int sum = 0;
				for(Vertex w:l){
					sum+=Integer.parseInt(w.prefix+""+w.suffix);					
				}
				System.out.println(sum);
				break;
				
			}
			out:
			for(Vertex v:l.peek().v){
				for(Vertex w:l) if(w.type==v.type) continue out;
				ArrayDeque<Vertex> lnew = new ArrayDeque<Vertex>();
				lnew.addAll(l);
				lnew.push(v);
				stack.push(lnew);
			}
		}
		//print(types,count);
		System.out.println((System.nanoTime()-t)/1000000.0+" milliseconds");
	}
	
	public static void print(ArrayList<ArrayList<Integer>> types, int[][][] count){
		for(int i=0;i<count.length;i++) System.out.printf("%02d ",i);
		System.out.println();
		System.out.println();
		
		for(int j=0;j<6;j++){
			for(int i=0;i<count.length;i++) System.out.printf("%02d ",count[i][0][j]);
			System.out.println();		
			for(int i=0;i<count.length;i++) System.out.printf("%02d ",count[i][1][j]);
			System.out.println();
			System.out.println();
		}
		
		for(ArrayList<Integer> a:types){ 
			for(int i:a){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(ArrayList<Integer> a:types){ 
			System.out.println(a.size());
		}
	}
	
	public static boolean containsOutside(int[] a, int n){
		for(int i=0;i<a.length;i++){
			if(i==n) continue;
			if(a[i]!=0) return true;
		}
		return false;
	}
	
	public static int[][][] count(ArrayList<ArrayList<Integer>> types){
		int[][][] count = new int[100][2][6];
		int arrayListNum = 0;
		for(ArrayList<Integer> a:types){ 
			for(int i:a){
				int prefix = i/100;
				int suffix = i%100;
				count[prefix][0][arrayListNum]++;
				count[suffix][1][arrayListNum]++;
			} 
			arrayListNum++;
		}
		return count;
	}

	
	public static ArrayList<Integer> genNums(double a, double b){
		ArrayList<Integer> q = new ArrayList<Integer>();
		int n=1;
		while(a*n*n+b*n<10000){
			int val = (int)Math.round(a*n*n+b*n);
			if(val>999) q.add(val);
			n++;
		}
		return q;
	}
}

class Vertex{
	int prefix;
	int suffix;
	int type;
	ArrayList<Vertex> v = new ArrayList<Vertex>();
	
	public Vertex(int i, int t){
		prefix = i/100;
		suffix = i%100;
		type = t;
	}
}
