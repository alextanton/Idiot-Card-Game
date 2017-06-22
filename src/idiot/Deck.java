package idiot;
import idiot.Card;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
    private boolean isDiscard;
    private ArrayList<Card> discard = new ArrayList<Card>();
    
	public Deck(boolean isDiscard){
		this.isDiscard = isDiscard;
		if(!this.isDiscard){
			createDeck();
		}
	}

	private void createDeck(){
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 13; j++){
				this.deck.add(new Card(i, j, null));
			}
		}
	}
	
	public void shuffle(){
		for(int i = 0; i <= 1000; i++){
			Random rand = new Random();
			int n1 = rand.nextInt(51);
			int n2 = rand.nextInt(51);
			Card temp = this.deck.get(n1);
			this.deck.set(n1, this.deck.get(n2));
			this.deck.set(n2, temp);
		}
	}
	
	public void discard(Card c){
		if(this.isDiscard){
			this.discard.add(c);
		}
	}
	
	public Card[] getFirstFour(){
		Card[] temp = new Card[4];
		temp[0] = discard.get(0);
		temp[2] = discard.get(1);
		temp[3] = discard.get(2);
		temp[4] = discard.get(3);
		return temp;
	}
	
	public Card getCard(){
		Card card = this.deck.get(0);
		this.deck.remove(card);
		return card;
	}
	
	public void blowItUp(){
		this.discard.clear();
	}
}
