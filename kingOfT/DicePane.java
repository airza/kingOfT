	package kingOfT;
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kingOfT.Game.RollButtonListener;


public class DicePane {

	private JPanel panel;
	private DiceSet dice;
	private Game game;
	private JButton[] diceButtons;
	private JButton okButton;
	private DiceToggleListener toggle = new DiceToggleListener();
	class DiceToggleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton parent = (JButton) e.getSource();
			parent.setBorderPainted(!parent.isBorderPainted());
	    }
	}
	
	public void drawDice(){
		for (Integer i = 0; i <GameConstants.DICE_NUM; i++) {
			diceButtons[i].setIcon(diceImages[dice.getIndexState(i)]);
		}
		System.out.println(dice.stateRender());
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setDice(DiceSet d) {
		dice = d;
	}
	private JButton makeButton(int i) {
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
		Boolean[] states = new Boolean[GameConstants.DICE_NUM];
		for (int i = 0; i< GameConstants.DICE_NUM; i++) {
			states[i] = diceButtons[i].isBorderPainted() == state;
		}
		return states;
	}
	public void enableDicetoggling ( Boolean turnOn) {
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

