package idiot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import idiot.Deck;

public class Game {
    Deck discard = new Deck(true);
	Deck draw = new Deck(false);
	Player player1 = new Player();
	Computer computer = new Computer();
	Map<Character, Runnable> commands = new HashMap<>();
	
	private void deal(){
		commands.put('1', () -> showHand(this.player1.hand));
		commands.put('2', () -> pickCards());
		commands.put('3', () -> System.out.println("Help"));
		commands.put('4', () -> System.out.println("Help"));
		commands.put('h', () -> showHand(this.player1.hand));
		
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
	
	public boolean checkForFour(){
		if(this.discard.getSize() >= 4){
			Card[] temp = this.discard.getFirstFour();
			for(int i = 0; i < 3; i++){
				if(temp[i] == temp[i+1]){
					continue;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public void showOptions(){
		System.out.println("Here are your options:");
		System.out.println("[1] Show cards in hand");
		System.out.println("[2] Pick cards to put down");
		System.out.println("[3] Show faceup cards");
		System.out.println("[4] Show top card");
	}
	
	public void showHand(Hand h){
		for(Card temp : h.getAll()){
			System.out.println("["+ h.cards.indexOf(temp) +"] " + Numbers.values()[temp.getNum()] + " of " + Suits.values()[temp.getSuit()]);
		}
	}
	
	public void pickCards(){
		Scanner s = new Scanner(System.in);
		System.out.println("Choose what card(s) you would like to put down:");
		showHand(this.player1.hand);
		String cards = s.nextLine();
		if(cards.length() == 0){
			System.out.println("Please choose a card");
			return;
		}
		Card[] arrCards = parseCardChoice(cards);
		this.discard.putDownCards(arrCards);
		if(this.checkForFour()){
			this.discard.blowItUp();
		}
	}
	
	public Card[] parseCardChoice(String c){
		c += " ";
		int i = 0;
		String[] cards = c.split(" ");
		Card[] cs = new Card[cards.length];
		for(String s : cards){
			int n = Integer.parseInt(s);
			cs[i] = this.player1.hand.cards.get(n);
			i++;
		}
		return cs;
	}
}

