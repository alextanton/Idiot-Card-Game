package idiot;

import idiot.Deck;

public class Game {
    Deck discard = new Deck(true);
	Deck draw = new Deck(false);
	Player player1 = new Player();
	Computer computer = new Computer();
	
	private void deal(){
		this.player1.faceDown.putCards(draw.getCard(), draw.getCard(), draw.getCard());
		this.computer.faceDown.putCards(draw.getCard(), draw.getCard(), draw.getCard());
		this.player1.faceUp.putCards(draw.getCard(), draw.getCard(), draw.getCard());
		this.computer.faceUp.putCards(draw.getCard(), draw.getCard(), draw.getCard());
		this.player1.hand.putCards(draw.getCard(), draw.getCard(), draw.getCard());
		this.computer.hand.putCards(draw.getCard(), draw.getCard(), draw.getCard());
	}
	
	public void start(){
		draw.shuffle();
		deal();
	}
	
	public void play(){
		Card c = this.draw.getCard();
		System.out.println(c.toString());
		discard.discard(c);
		if(checkForFour()){
			this.discard.blowItUp();
		}
	}
	
	public void showHand(Hand h){
		for(Card temp : h.getAll()){
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
