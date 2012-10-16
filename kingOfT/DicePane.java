	package kingOfT;
	import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;


public class DicePane {
	final int MAX_PLAYERS = 6;
	final int DICE_TYPES = 6;
	JFrame frame;
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
	public JFrame getFrame() {
		return frame;
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

	frame = new JFrame("dice");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	diceButtons = new JButton[DICE_TYPES];
	for (Integer i = 0; i<DICE_TYPES; i++) {
		diceButtons[i] = makeButton(i);
		frame.add(diceButtons[i]);
	}
	BoxLayout box = new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS);
	frame.setLayout(box);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(100,500));
	
	}
	}
