package kingOfT;

public class MainLoop {

	/**
	 * @param args starts the main loop for the game with monster "names" as A,B,C,D,E,F
	 * Initates the game method and draws the game board and starts the GUI 
	 */
	public static void main(String[] args) {
		//there should be some code here to handle beginning a new game, but there isn't
		final int PLAYER_NUM = 6;
		final String[] NAMES = {"A","B","C","D","E","F"};		
		Window win  = new Window();
		Game game = new Game(PLAYER_NUM,NAMES, win);
		game.startTurn();
		win.drawDice();
	}
}
