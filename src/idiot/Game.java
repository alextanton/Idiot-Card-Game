package idiot;

import idiot.services.CardService;

import java.util.*;

public class Game {
	private Deck discard = new Deck(true);
	private Deck draw = new Deck(false);
	Player player1 = new Player();
	private Computer computer = new Computer();
	private CardService service = CardService.getInstance(draw, discard);

	private void deal() {

		this.player1.faceDown.putCards(this.getThreeCards());
		this.computer.faceDown.putCards(this.getThreeCards());
		this.player1.faceUp.putCards(this.getThreeCards());
		this.computer.faceUp.putCards(this.getThreeCards());
		this.player1.hand.putCards(this.getThreeCards());
		this.computer.hand.putCards(this.getThreeCards());
	}

	void start() {
		draw.shuffle();
		deal();
		this.discard.discard(this.draw.getCard());
	}

	void showOptions() {
		System.out.println("Here are your options:");
		System.out.println("[1] Show cards in hand");
		System.out.println("[2] Pick cards to put down");
		System.out.println("[3] Show faceup cards");
		System.out.println("[4] Show top card");
	}

	void showHand(Hand h) {
		for (Card temp : h.getAll()) {
			System.out.println("[" + h.cards.indexOf(temp) + "] " + Numbers.m.get(temp.getNum()) + " of " + Suits.values()[temp.getSuit()]);
		}
	}

	void pickCards(Hand hand) {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose what card(s) you would like to put down:");
		showHand(hand);
		int choice = s.hasNextInt() ? s.nextInt() : -1;
		if((choice < 0 || choice > hand.getAll().size()) || !canPlayCard(hand.cards.get(choice).getNum())){
			System.out.println("Invalid Selection");
			pickCards(hand);
		} else {
			try {
				if(service.handleCard(hand.cards.get(choice).getNum())){
					System.out.println("You played " + hand.cards.get(choice).cardAsReadable());
				}
				this.service.discardAndReplace(hand.cards.get(choice), hand);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private ArrayList<Card> getThreeCards(){
		return new ArrayList<>(Arrays.asList(this.draw.getCard(), this.draw.getCard(), this.draw.getCard()));
	}

	String showTopCardAsReadable(){
		return this.discard.get(this.discard.getSize() - 1).cardAsReadable();
	}
	private Card showTopCard(){
		return this.discard.get(this.discard.getSize() - 1);
	}

	private boolean canPlayCard(int c){
		boolean canPlayCard = false;
		Card currentCard = this.showTopCard();
		if(currentCard.getNum() == 5 && c <= currentCard.getNum()){
			canPlayCard = true;
		} else if(currentCard.getNum() <= c){
			canPlayCard = true;
		}
		return canPlayCard;
	}
}


