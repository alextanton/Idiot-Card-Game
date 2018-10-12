package idiot;
import java.util.Scanner;

public class Play {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Game g = new Game();
		g.start();
		while(true){
			g.showOptions();
			System.out.println("What is your choice: ");
			String action = s.nextLine();
			try{
				switch(Integer.parseInt("" + action.charAt(0))) {
					case 2: g.pickCards(g.player1.hand);
						break;
					case 4: System.out.println(g.showTopCardAsReadable());
						break;
					case 1: g.showHand(g.player1.hand);
						break;
					case 3: g.player1.faceUp.cards.forEach((c) -> System.out.println(c.cardAsReadable()));
						break;
					default: System.out.println("ERROR");
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
}
