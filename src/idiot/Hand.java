package idiot;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public void putCards(Card c, Card cc, Card ccc){
		this.cards.add(c);
		this.cards.add(cc);
		this.cards.add(ccc);
	}
	
	public ArrayList<Card> getAll(){
		return this.cards;
	}
	 
}
