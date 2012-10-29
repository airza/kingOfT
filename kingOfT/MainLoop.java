package kingOfT;

public class MainLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int PLAYER_NUM = 4;
		final String[] NAMES = {"A","B","C","D"};
		Window win  = new Window();
		Game game = new Game(PLAYER_NUM,NAMES, win);
		win.setGame(game);
		game.startTurn();
		win.drawDice();
	}
}
