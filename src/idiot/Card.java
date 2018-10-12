package idiot;

public class Card {
	private int suit;
	private int num;

	public Card(int suit, int num){
		this.suit = suit;
		this.num = num;
	}


	int getSuit(){
		return this.suit;
	}

	public int getNum(){
		return this.num;
	}
	
	String cardAsReadable(){
		return Numbers.m.get(this.num) + " of " + Suits.values()[this.suit];
	}

}
