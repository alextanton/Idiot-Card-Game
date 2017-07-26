package idiot;
import java.util.Scanner;

public class Play {
	
	public static void main(String[] args){
		boolean c = true;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome...");
		Game g = new Game();
		System.out.println("Dealing the cards...");
		g.start();
		System.out.println("Face Up Cards...");
		g.showHand(g.player1.faceUp);
		System.out.println("Your Hand...");
		g.showHand(g.player1.hand);
		//start gameplay
		System.out.println("Your turn player1...");
		g.showOptions();
		while(c){
			System.out.println("What is your choice: ");
			String action = s.nextLine();
			try{
				g.commands.get(action.charAt(0)).run();
			} catch(Exception e){
				continue;
			}
			g.printCardsInDiscard();
		}
	}
	
}
