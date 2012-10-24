	package kingOfT;
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DicePane {
	private final int DICE_NUM = 6;
	private final int DICE_TYPES = 6;
	private JPanel panel;
	private DiceSet dice;
	private Game game;
	private JButton[] diceButtons;
	private JButton okButton;
	private RollButtonListener rollListener;
	private OkButtonListener okButtonListener;
	class ButtonListener implements ActionListener {
		Integer element;
		public void actionPerformed(ActionEvent e) {
			JButton parent = (JButton) e.getSource();
			parent.setBorderPainted(!parent.isBorderPainted());
			System.out.println(element);
	    }
	    public ButtonListener(Integer i){
    		element = i;
    	}
	}
	class RollButtonListener implements ActionListener {
		DicePane pane;
		public void actionPerformed(ActionEvent e) {
			Boolean[] rolls = new Boolean[pane.DICE_NUM];
			for (int i = 0; i<pane.DICE_NUM; i++){
				rolls[i] = !pane.diceButtons[i].isBorderPainted();
			}
			pane.dice.rollDice(rolls);
			pane.drawDice();
			if(dice.getRollsLeft() == 0) {
				JButton parent = (JButton) e.getSource();
				parent.removeActionListener(this);
				game.handleDice(dice);
				parent.setText("OK");
				parent.addActionListener(okButtonListener);
			}
	    }
	    public RollButtonListener(DicePane p,Game g){
    		pane = p;
    		game = g;
    	}
	}
	class OkButtonListener implements ActionListener {
		DicePane pane;
		public void actionPerformed(ActionEvent e) {
			JButton parent = (JButton) e.getSource();
			game.endTurn();
			parent.removeActionListener(this);
			parent.setText("ROLL!");
			parent.addActionListener(rollListener);
			game.startTurn();
			pane.drawDice();
	    }
	    public OkButtonListener(DicePane p,Game g){
    		pane = p;
    		game = g;
    	}
	}
	
	public void drawDice(){
		for (Integer i = 0; i <DICE_NUM; i++) {
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
		button.addActionListener(new ButtonListener(i));
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

	public DicePane() {

	panel = new JPanel();
	diceButtons = new JButton[DICE_NUM];
	okButton  = new JButton("ROLL!");
	for (Integer i = 0; i<DICE_NUM; i++) {
		diceButtons[i] = makeButton(i);
		panel.add(diceButtons[i]);
	}
	panel.add(okButton);
	rollListener = new RollButtonListener(this,getGame());
	okButtonListener = new OkButtonListener(this,getGame());
	okButton.addActionListener(rollListener);
	BoxLayout box = new BoxLayout(panel,BoxLayout.X_AXIS);
	panel.setLayout(box);
	panel.setVisible(true);
	panel.setMinimumSize(new Dimension(100,500));
	
	}
	}

