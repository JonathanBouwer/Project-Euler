import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count  = 0;
		while(sc.hasNext()){
			String[] player1 = new String[5];
			String[] player2 = new String[5];
			
			for(int i=0;i<5;i++){
				player1[i] = sc.next();
				//System.out.println(player1[i]);
			}
			for(int i=0;i<5;i++){
				player2[i] = sc.next();
			}
			
			Hand p1 = new Hand(player1);
			Hand p2 = new Hand(player2);
			//for(Card c: p1.cards) System.out.println("C"+c.value);
			try{
				if(p1.compareTo(p2)>0) count++;
			}catch(Exception e){
				System.out.print("Broke on ");
				for(int i=0;i<5;i++) System.out.print(player1[i]+" ");
				for(int i=0;i<5;i++) System.out.print(player2[i]+" ");
				e.printStackTrace();
				break;
			}
		}
		System.out.println(count);
	}
}

class Hand{
	Card[] cards;
	public Hand(String[] hand){
		cards = new Card[5];
		for(int i=0;i<5;i++){
			cards[i] = new Card(hand[i]);
		}
		Arrays.sort(cards);
	}
	
	public int compareTo(Hand other){
		int r1 = rank(), r2 = other.rank();
		if(r1>r2) return 1;
		if(r2>r1) return -1;
		//tested 10,9,8,7,6,5,4,3,2,1
		if(r1==9||r1==6||r1==5||r1==1) return compareHighest(other);
		if(r1==8||r1==4||r1==2){
			int n=4;
			if(r1==4) n =3;
			if(r1==2) n=2;
			int ret = Integer.compare(findNPairVal(n,false),other.findNPairVal(n,false));
			if(ret==0) return compareHighest(other);
			return ret;
		}if(r1==7){
			int ret = Integer.compare(findNPairVal(3,false),other.findNPairVal(3,false));
			if(ret==0) ret = Integer.compare(findNPairVal(2,false),other.findNPairVal(2,false));
			return ret;
		}if(r1==3){
			int ret = Integer.compare(findNPairVal(2,false),other.findNPairVal(2,false));
			if(ret==0) ret = Integer.compare(findNPairVal(2,true),other.findNPairVal(2,true));
			return ret;
		}
		return 0; 
	}
	
	public int compareHighest(Hand other){
		int i=4;
		while(Integer.compare(cards[i].value,other.cards[i].value)==0) i--;
		return Integer.compare(cards[i].value,other.cards[i].value);
	}
	
	public int findNPairVal(int size, boolean end){
		int[] dupes = new int[13];
		Arrays.fill(dupes,0);
		for(Card c:cards) dupes[c.value-2]++;
		if(!end) for(int i=0;i<13;i++) if(dupes[i]==size) return i;
		else for(int j=12;j>=0;j--) if(dupes[j]==size) return j;
		return 0;
	}
	
	public int rank(){
		//check if flush
		boolean flush = true;
		for(int i=1;i<5;i++){
			if(cards[i].suit!=cards[i-1].suit){
				flush = false;
				break;
			}
		}
		//check if straight
		boolean straight = true;
		for(int i=1;i<5;i++){
			if(cards[i].value!=cards[i-1].value+1){
				straight = false;
				break;
			}
		}
		//check duplicates
		int[] dupes = new int[13];
		Arrays.fill(dupes,0);
		for(Card c:cards){
			//System.out.println(c.value);
			dupes[c.value-2]++;
		}
		boolean FourofKind=false;
		boolean ThreeofKind=false;
		boolean TwoPairs=false;
		boolean Pair=false;
		for(int i:dupes){
			if(i==4) FourofKind=true;
			if(i==3) ThreeofKind=true;
			if(i==2&&Pair) TwoPairs=true;
			if(i==2) Pair = true;			
		}
		if(straight&&flush&&cards[4].value==14) return 10;
		if(straight&&flush) return 9;
		if(FourofKind) return 8;
		if(Pair&&ThreeofKind) return 7;
		if(flush) return 6;
		if(straight) return 5;
		if(ThreeofKind) return 4;
		if(TwoPairs) return 3;
		if(Pair) return 2;
		return 1;
	}
}

class Card implements Comparable<Card>{
	public int suit;//0-Hearts,1-Diamonds,2-Clubs,3-Spades
	public int value;
	
	public Card(String s){
		char c1 = s.charAt(0);
		char c2 = s.charAt(1);
		switch(c1){	
			case 'T' : 	value = 10;
						break;
			case 'J' : 	value = 11;
						break;
			case 'Q' : 	value = 12;
						break;
			case 'K' : 	value = 13;
						break;
			case 'A' : 	value = 14;
						break;	
			default  :  value = c1-48;
		}
		switch(c2){
			case 'H' : 	suit = 0;
						break;
			case 'D' : 	suit = 1;
						break;
			case 'C' : 	suit = 2;
						break;
			default  :  suit = 3;
		}
		//System.out.println("C"+value+" "+c1);
	}
	
	public int compareTo(Card other){
		return Integer.compare(value, other.value);
	}
}
