	package kingOfT;
	import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DicePane {
	final int MAX_PLAYERS = 6;
	final int DICE_TYPES = 6;
	JPanel panel;
	class ButtonListener implements ActionListener {
	
		Integer element;
	
		public void actionPerformed(ActionEvent e) {
			System.out.println(element);
	    }
	    public ButtonListener(Integer i){
    		element = i;
    	}
	}
	JButton[] diceButtons;
	public void drawDice(DiceSet dice){
		for (Integer i = 0; i <DICE_TYPES; i++) {
			diceButtons[i].setIcon(diceImages[dice.getIndexState(i)]);
		}
		System.out.println(dice.stateRender());
	}
	public JPanel getPanel() {
		return panel;
	}
	private JButton makeButton(int i) {
		JButton button = new JButton(diceImages[i]);
		button.addActionListener(new ButtonListener(i));
		button.setSize(100,100);
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

	public DicePane() {

	panel = new JPanel();
	diceButtons = new JButton[DICE_TYPES];
	for (Integer i = 0; i<DICE_TYPES; i++) {
		diceButtons[i] = makeButton(i);
		panel.add(diceButtons[i]);
	}
	BoxLayout box = new BoxLayout(panel,BoxLayout.X_AXIS);
	panel.setLayout(box);
	panel.setVisible(true);
	panel.setMinimumSize(new Dimension(100,500));
	
	}
	}
