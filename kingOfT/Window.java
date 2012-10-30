package kingOfT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window {
	public static Boolean askYNQuestion(String text){
		return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,text,null,JOptionPane.YES_NO_OPTION);
	}
	JButton[] diceButtons;
	DicePane dicePane;
	JTextArea log;
	public void drawDice(){
		dicePane.drawDice();
	}
	public void setDice(DiceSet dice) {
		dicePane.setDice(dice);	
	}
	public Boolean[] getUnselectedDice() {
		return dicePane.checkToggleState(false);
	}
	public void write(String text) {
		System.out.println(text);
		log.append(text+"\n");
	}
	public Window() {
	log = new JTextArea();
	log.setLineWrap(true);
	log.setSize(500, 200);
	JScrollPane scrollbox = new JScrollPane();
	scrollbox.add(log);
	scrollbox.setSize(500,200);
	log.setEnabled(false);
	log.setDisabledTextColor(Color.BLACK);
	log.setBackground(Color.WHITE);
	JFrame frame = new JFrame("HI");
	dicePane = new DicePane();
	frame.add(scrollbox);
	frame.add(dicePane.getPanel());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,600));
	}
	public void setMainButtonListener(ActionListener l) {
		dicePane.getOkButton().addActionListener(l);
		
	}


}
