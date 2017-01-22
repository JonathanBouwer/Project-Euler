import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		ArrayList<Integer> pents = new ArrayList<Integer>();
		for(int i=1; i<2400; i++){
			pents.add(i*(3*i-1)/2);
		}
		for(int i:pents) System.out.println(i);
		for(int i=0;i<pents.size();i++){
			for(int j=i+1;j<pents.size();j++){
				if(pents.contains(pents.get(i)+pents.get(j))&&pents.contains(pents.get(j)-pents.get(i))){
					System.out.println(pents.get(i)+"-"+pents.get(j)+"="+(pents.get(j)-pents.get(i)));
				}
			}
		}
	}
}
