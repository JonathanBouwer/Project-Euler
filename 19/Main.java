public class Main{
	public static void main(String[] args){
		int year=1901;
		int day = 2;//0-Sun 1-Mon etc
		int count = 0;
		while(year<2001){
			for(int i=0;i<12;i++){
				System.out.println((i+1)+ " "+year+": "+day);
				if(i==1){
					if((year%4==0)){
						day = (day+29)%7;
					}else{
						day = (day+28)%7;
					}
				}else if((i==3) || (i==5) || (i==8) || (i==10)){
					day = (day+30)%7;
				}else{
					day = (day+31)%7;
				}
				
				if(day == 0){ count++;}
			}
			year++;
		}
		System.out.println(count);
	}
	
}