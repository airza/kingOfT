package kingOfT;



public class MainLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Window();
		final int PLAYER_NUM = 4;
		final String[] NAMES = {"A","B","C","D"};

		Game game = new Game(PLAYER_NUM,NAMES);
		while (true) {
		game.takeTurn();
		}
	}
}
