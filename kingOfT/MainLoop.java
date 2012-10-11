package kingOfT;

import java.awt.Dimension;

import javax.swing.JFrame;



public class MainLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window win  = new Window();
		final int PLAYER_NUM = 4;
		final String[] NAMES = {"A","B","C","D"};

		Game game = new Game(PLAYER_NUM,NAMES,win);
		while (true) {
		game.takeTurn();
		}
	}
}
