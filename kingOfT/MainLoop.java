package kingOfT;

public class MainLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window win  = new Window();
		final int PLAYER_NUM = 4;
		final String[] NAMES = {"A","B","C","D"};

		Game game = new Game(PLAYER_NUM,NAMES,win);
		game.startTurn();
		win.drawDice();
	}
}
