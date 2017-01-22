import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		BigInteger num = new BigInteger("1");  
		BigInteger denom = new BigInteger("2");
		int count = 0;
		for(int i=0; i<1000;i++){
			//System.out.println(denom.add(num).toString()+"/"+denom.toString());		
			if(denom.add(num).toString().length()>denom.toString().length()) count++;
			BigInteger temp = denom;
			denom= denom.multiply(new BigInteger("2")).add(num);
			num=temp;		
		}
		System.out.println(count);
	}
}
