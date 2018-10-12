package idiot;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
    private boolean isDiscard;
    private ArrayList<Card> discard = new ArrayList<Card>();
    
	Deck(boolean isDiscard){
		this.isDiscard = isDiscard;
		if(!this.isDiscard){
			createDeck();
		}
	}
	
	public Card get(int i){
		return this.discard.get(i);
	}
	
	private void createDeck(){
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 13; j++){
				this.deck.add(new Card(i, j));
			}
		}
	}
	
	void shuffle(){
		ArrayList<Card> shuffledDeck = new ArrayList<>();

		while (shuffledDeck.size() <= this.deck.size()) {
			int index = (int) (Math.random() * deck.size());
			shuffledDeck.add(this.deck.get(index));
		}
		this.deck = shuffledDeck;
	}
	
	public void discard(Card c){
		if(this.isDiscard){
			this.discard.add(c);
		}
	}

	public Card getTopDiscard(){
		Card card = this.discard.get(this.discard.size());
		return card;
	}
	
	public Card getCard(){
		Card card = this.deck.get(0);
		this.deck.remove(card);
		return card;
	}

	int getSize(){
		if(this.isDiscard){
			return this.discard.size();
		} else{
			return this.deck.size();
		}
	}
}
