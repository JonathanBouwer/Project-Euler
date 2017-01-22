public class Main{
	public static void main(String[] args){
		int x = 50;
		int y = 50;
		int count = 0;
		for(int i=0;i<=x;i++){
			for(int j=0;j<=y;j++){
				for(int k=0;k<=x;k++){
					for(int l=0;l<=y;l++){
						if(i==k&&j==l) continue;
						if(i==0&&j==0) continue;
						if(k==0&&l==0) continue;
						if(k==i&&l<=j) continue;
						if(k<i) continue;
						//System.out.printf("(%d,%d),(%d,%d)\n",j,i,l,k);
						double s1 = dist(0,0,j,i);
						double s2 = dist(0,0,l,k);
						double s3 = dist(j,i,l,k);
						// System.out.printf("(0,0) to (%d,%d)=%.3f\n",j,i,s1);
						// System.out.printf("(0,0) to (%d,%d)=%.3f\n",l,k,s2);
						// System.out.printf("(%d,%d) to (%d,%d)=%.3f\n",j,i,l,k,s3);
						double max = Math.max(Math.max(s1,s2),s3);
						double min = Math.min(Math.min(s1,s2),s3);
						double mid = s1+s2+s3-min-max;
						//System.out.println(max+" "+Math.hypot(min,mid));
						if(Math.abs(max-Math.hypot(min,mid))<1e-6){
							//System.out.printf("(%d,%d),(%d,%d)\n",j,i,l,k);
							//System.out.println("yes");
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}	
	
	public static double dist(int x1, int y1, int x2, int y2){
		return Math.hypot(x2-x1,y2-y1);
	}
}