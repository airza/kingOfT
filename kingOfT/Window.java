package kingOfT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

class ButtonListener implements ActionListener {

	Integer element;
    public void actionPerformed(ActionEvent e) {
            System.out.println(element);
    }
    public ButtonListener(Integer i){
    	element = i;
    }
}

public class Window {

	JButton[] diceButtons;
	
	public void pause(){
		System.out.println("Press enter key to continue...");
		Scanner scn = new Scanner(System.in);
		scn.nextLine();
	}
	public void drawDice(DiceSet dice){
		for (Integer i = 0; i <DICE_TYPES; i++) {
			diceButtons[i].setIcon(diceImages[dice.getIndexState(i)]);
		}
		System.out.println(dice.stateRender());
	}
	private JButton makeButton(Container parent, int i) {
		JButton button = new JButton(diceImages[i]);
		button.addActionListener(new ButtonListener(i));
		button.setSize(100,100);
		parent.add(button);
		return button;
	}
	final ImageIcon diceImages[] = {
			new ImageIcon("Pictures/lightning.png"),
			new ImageIcon("Pictures/1.png"),
			new ImageIcon("Pictures/2.png"),
			new ImageIcon("Pictures/3.png"),
			new ImageIcon("Pictures/wham.png"),
			new ImageIcon("Pictures/heart.png"),
	};
	final int MAX_PLAYERS = 6;
	final int DICE_TYPES = 6;
	public Window() {

	JFrame frame = new JFrame("HI");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	diceButtons = new JButton[DICE_TYPES];
	for (Integer i = 0; i<DICE_TYPES; i++) {
		diceButtons[i] = makeButton(frame,i);
	}
	BoxLayout box = new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS);
	JLabel Console = new JLabel("CONSOLE");
	Console.setSize(100,500);
	Console.setLocation(0,100);
	frame.setLayout(box);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,600));
	
	}
}
