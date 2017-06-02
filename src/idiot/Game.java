package idiot;
import java.util.ArrayList;

import idiot.Deck;

public class Game {
    Deck discard = new Deck(true);
	Deck draw = new Deck(false);
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public void deal(){
		for(int i=0;i<3;i++){
			hand.add(this.draw.getCard());
		}
	}
	
	public void play(){
		Card c = this.draw.getCard();
		System.out.println(c.toString());
		discard.discard(c);
		if(checkForFour()){
			this.discard.blowItUp();
		}
	}
	
	public void showHand(){
		for(Card temp : hand){
			System.out.println(Numbers.values()[temp.getNum()] + " of " + Suits.values()[temp.getSuit()]);
		}
	}
	
	public boolean checkForFour(){
		Card[] temp = this.discard.getFirstFour();
		for(int i = 0; i < 3; i++){
			if(temp[i] == temp[i+1]){
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
