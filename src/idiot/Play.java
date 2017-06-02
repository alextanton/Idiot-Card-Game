package idiot;
import java.util.Scanner;

public class Play {
	
	public static void main(String[] args){
		boolean c = true;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome...");
		while(c){
			System.out.println("Wanna play?(y/n)");
			String wannaPlay = s.nextLine();
			if(wannaPlay.toLowerCase().equals("y")){
				c = false;
			} else if(wannaPlay.toLowerCase().equals("n")){
				System.exit(0);
			}
		}
		s.close();
		Game g = new Game();
		g.deal();
		g.showHand();
	}
	
}
