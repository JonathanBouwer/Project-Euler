public class Main{
	public static void main(String[] args){
		int count = 0;
		double prevX = 0.0, prevY = 10.1, curX = 1.4, curY= -9.6;
		while(true){
			if(curX>-0.01&&curX<0.01&&curY>0){
				break;
			}
			double mTan = -4*curX/curY;
			double mLine = (curY-prevY)/(curX-prevX);
			
			double thetaL = Math.atan(mLine);
			double thetaT = Math.atan(mTan);
			double Dtheta = thetaL-thetaT;
			double thetaNew = thetaT-Dtheta;
			double m = Math.tan(thetaNew);
			double newX = 0.0;
			double a = 4+m*m;
			double b = -2*m*m*curX+2*m*curY;
			double c = m*m*curX*curX-2*m*curX*curY+curY*curY-100;
			System.out.println(thetaNew*180/Math.PI+" "+a+" "+b+" "+c);
			newX = (-b+Math.sqrt(b*b-4*a*c))/2*a;
			if(newX-curX<1e-3) newX = (-b-Math.sqrt(b*b-4*a*c))/2*a;
			double newY = m*(newX-curX)+curY;
			System.out.printf("%.6f,%.6f\n",newX,newY);
			prevX=curX;
			prevY=curY;
			curX=newX;
			curY=newY;
			count++;
		}
		System.out.println(count);
	}
}