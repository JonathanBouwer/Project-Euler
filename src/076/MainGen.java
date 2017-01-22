import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainGen{
	public static void main(String[] args){
		TreeSet<ArrayList<Integer>> t = genPartitions(50);
		/*for(ArrayList<Integer>a : t){
			for(int i:a){
				System.out.print(i+" ");
			}
			System.out.println();
		}*/
		System.out.println(t.size()-1);
	}
	
	public static TreeSet<ArrayList<Integer>> genPartitions(int n){
		ArrayList<TreeSet<ArrayList<Integer>>> parts = new ArrayList<TreeSet<ArrayList<Integer>>>();
		TreeSet<ArrayList<Integer>> basecase = new TreeSet<ArrayList<Integer>>(new ArrayListComparator());
		ArrayList<Integer> one =  new ArrayList<Integer>();
		one.add(1);
		basecase.add(one);
		parts.add(basecase);
		parts = genParts(n,parts);
		return parts.get(n-1);
	}
	
	public static ArrayList<TreeSet<ArrayList<Integer>>> genParts(int n, ArrayList<TreeSet<ArrayList<Integer>>> parts){
		for(int i=2;i<=n;i++){//adding treesets
			System.out.println(i);
			TreeSet<ArrayList<Integer>> cur =  new TreeSet<ArrayList<Integer>>(new ArrayListComparator());
			ArrayList<Integer> c =  new ArrayList<Integer>();
			c.add(i);
			cur.add(c);
			for(int j=1;j<i;j++){//adding arraylists to treeset
				for(ArrayList<Integer> a : parts.get(i-1-j)){
					c=new ArrayList<Integer>(a);
					c.add(j);
					cur.add(c);
				}
			}
			parts.add(cur);
		}
		return parts;
	}
}

class ArrayListComparator implements Comparator<ArrayList<Integer>>{
	public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
		if(a1.size()-a2.size()!=0) return a1.size()-a2.size();
		ArrayList<Integer> a = new ArrayList<Integer>(a1);
		ArrayList<Integer> b = new ArrayList<Integer>(a2);
		Collections.sort(a);
		Collections.sort(b);
		for(int i=0; i<a.size();i++){
			if(a.get(i)!=b.get(i)) return a.get(i)-b.get(i);
		}
		return 0;
	}
	
	public boolean equals(ArrayList<Integer> a1,ArrayList<Integer> a2){
		return compare(a1,a2)==0;
	}
}
