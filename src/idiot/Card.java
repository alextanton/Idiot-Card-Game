package idiot;

public class Card {
	private int suit;
	private String ability;
	private int num;
	
	public Card(int suit, int num, String ability){
		this.suit = suit;
		this.ability = ability;
		this.num = num;
	}
	
	public int getSuit(){
		return this.suit;
	}
	
	public String getAbility(){
		return this.ability;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public String cardAsReadable(){
		return Numbers.values()[this.num] + " of " + Suits.values()[this.suit];
	}
}
