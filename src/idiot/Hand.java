package idiot;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	ArrayList<Card> cards = new ArrayList<>();
	
	void putCards(List<Card> cards){
		this.cards = (ArrayList<Card>)cards;
	}
	
	public ArrayList<Card> getAll(){
		return this.cards;
	}
	 
}
