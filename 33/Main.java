public class Main{
	public static void main(String[] args){
		for(int i=1; i<10; i++){
			for(int j=1;j<10; j++){
				for(int k =1; k<10; k++){
					for(int l=1;l<10;l++){
						if(!((i==k)||(i==l)||(j==k)||(j==l))) break;
						double val = ((10*i+j)*1.0)/((10*k+l)*1.0);
						double v1=i/(k*1.0), v2=i/(l*1.0), v3=j/(k*1.0), v4=j/(l*1.0);
						if((val>0.99)) break;
						if((val==v1)) System.out.println(i+""+j+"/"+k+""+l);
						if((val==v2)) System.out.println(i+""+j+"/"+k+""+l);
						if((val==v3)) System.out.println(i+""+j+"/"+k+""+l);
						if((val==v4)) System.out.println(i+""+j+"/"+k+""+l);
					}
				}
			}
		}
	}
}//16/64, 19/95, 26/65, 49/98
