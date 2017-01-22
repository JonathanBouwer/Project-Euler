import java.util.ArrayList;
import java.util.Collections;
public class Main{
	public static void main(String[] args){
		int max = 0;
		for(double a=0;a<7;a++){
			for(double b=a+1;b<8;b++){
				for(double c=b+1;c<9;c++){
					for(double d=c+1;d<10;d++){
						ArrayList<Double> vals = new ArrayList<Double>();
						vals.add(a);
						vals.add(b);
						vals.add(c);
						vals.add(d);
						vals = count(vals);
						Collections.sort(vals);
						int n = max(vals);
						if(n>max){
							max = n;
							System.out.printf("%.0f %.0f %.0f %.0f=",a,b,c,d);
							System.out.println(n);
							//for(Double p:vals) System.out.println(p);
						}
					}
				}
			}
		}
	}
	
	public static int max(ArrayList<Double> v){
		if(v.get(0)-1>1e-6) return 0;
		int count =1;
		while(count<v.size()&&v.get(count)-v.get(count-1)-1<1e-6){
			count++;
		}
		return count;
	}
	
	public static ArrayList<Double> count(ArrayList<Double> vals){
		ArrayList<Double> ret = new ArrayList<Double>();
		
		if(vals.size()==1) return vals;
		for(int i=0;i<vals.size();i++){
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int j=0;j<vals.size();j++){
				if(i!=j){
					temp.add(vals.get(j));
				}
			}
			
			for(int j=0;j<temp.size();j++){
				ArrayList<Double> temp1 = new ArrayList<Double>(temp);
				temp1.set(j,temp1.get(j)+vals.get(i));
				ret.addAll(count(temp1));
				temp1 = new ArrayList<Double>(temp);
				temp1.set(j,temp1.get(j)-vals.get(i));
				ret.addAll(count(temp1));
				temp1 = new ArrayList<Double>(temp);
				temp1.set(j,temp1.get(j)*vals.get(i));
				ret.addAll(count(temp1));
				if(vals.get(i)!=0){
					temp1 = new ArrayList<Double>(temp);
					temp1.set(j,temp1.get(j)/vals.get(i));
					ret.addAll(count(temp1));
				}
			}
		}
		
		ArrayList<Double> retur = new ArrayList<Double>();
		for(double  i:ret){
			if(!retur.contains(i)&&i>0&&i%1==0) retur.add(i);
		}
		
		return retur;
	}
}