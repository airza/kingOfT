package kingOfT;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.*;

public class Window {

	JButton[] diceButtons;
	DicePane dicePane;
	public void pause(){
		System.out.println("Press enter key to continue...");
		Scanner scn = new Scanner(System.in);
		scn.nextLine();
	}
	public void drawDice(){
		dicePane.drawDice();
	}
	public Window() {

	JFrame frame = new JFrame("HI");
	dicePane = new DicePane();
	frame.add(dicePane.getPanel());
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,600));
	}
	public void setDice(DiceSet dice) {
		dicePane.setDice(dice);	
	}
}
