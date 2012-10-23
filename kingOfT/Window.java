package kingOfT;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.*;

public class Window {

	JButton[] diceButtons;
	DicePane dicePane;
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
