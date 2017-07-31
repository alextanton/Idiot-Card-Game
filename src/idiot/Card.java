package idiot;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	private int suit;
	private String ability;
	private int num;
	public static ArrayList<String> faces = new ArrayList<String>(Arrays.asList("JACK", "11", "QUEEN", "12", "KING", "13", "ACE", "1"));

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

	public int cardToInt(){
		String snum = Integer.toString(this.getNum());
		if(Card.faces.contains(snum)){
			return Integer.parseInt(Card.faces.get(Card.faces.indexOf(snum)+1));
		} else{
			return this.getNum();
		}
	}

}
