	package kingOfT;
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kingOfT.Game.RollButtonListener;


public class DicePane {
	/*
	 * This object manages the buttons which control whether dice are or aren't selected.
	 */
	private JPanel panel;
	private DiceSet dice;
	private Game game;
	private JButton[] diceButtons;
	private JButton okButton;
	private DiceToggleListener toggle = new DiceToggleListener();
	class DiceToggleListener implements ActionListener {
		/*toggles the border on click (which is how the game determines
		 * if the die is locked in or not
		 */
		public void actionPerformed(ActionEvent e) {
			JButton parent = (JButton) e.getSource();
			parent.setBorderPainted(!parent.isBorderPainted());
	    }
	}
	
	public void drawDice(){
		//called when the dice state has changed and the frame needs to be
		//updated
		for (Integer i = 0; i <GameConstants.DICE_NUM; i++) {
			diceButtons[i].setIcon(diceImages[dice.getIndexState(i)]);
		}
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setDice(DiceSet d) {
		dice = d;
	}
	private JButton makeButton(int i) {
		//todo this function has no particularly good reason to exist
		JButton button = new JButton(diceImages[i]);
		button.setSize(100,100);
		button.setBorder(BorderFactory.createLineBorder(Color.red));
		return button;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	final ImageIcon diceImages[] = {
			new ImageIcon("Pictures/lightning.png"),
			new ImageIcon("Pictures/1.png"),
			new ImageIcon("Pictures/2.png"),
			new ImageIcon("Pictures/3.png"),
			new ImageIcon("Pictures/wham.png"),
			new ImageIcon("Pictures/heart.png"),
	};
	public Boolean[] checkToggleState(Boolean state){
		//returns which buttons aren't and are pressed depending on what it's passed
		Boolean[] states = new Boolean[GameConstants.DICE_NUM];
		for (int i = 0; i< GameConstants.DICE_NUM; i++) {
			states[i] = diceButtons[i].isBorderPainted() == state;
		}
		return states;
	}
	public void enableDicetoggling ( Boolean turnOn) {
		//turns on and off interactivity for buttons (for future when they
		//shouldn't be rolled during card purchases.
		if (turnOn) {
			for (JButton b: diceButtons){
				b.addActionListener(toggle);
			}
		
		} else {
			for (JButton b: diceButtons){
				b.removeActionListener(toggle);
			}
		}
	}
	public DicePane() {
	//make a new panel, add some dice to it, and center them.
	panel = new JPanel();
	diceButtons = new JButton[GameConstants.DICE_NUM];
	okButton  = new JButton("ROLL!");
	for (Integer i = 0; i<GameConstants.DICE_NUM; i++) {
		diceButtons[i] = makeButton(i);
		panel.add(diceButtons[i]);
	}
	panel.add(okButton);
	BoxLayout box = new BoxLayout(panel,BoxLayout.X_AXIS);
	panel.setLayout(box);
	panel.setVisible(true);
	panel.setMinimumSize(new Dimension(100,500));
	enableDicetoggling(true);
}
	public JButton getOkButton() {
		return okButton;
		
	}
	}

