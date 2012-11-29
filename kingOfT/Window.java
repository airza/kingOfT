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
	TokyoPane tokyoPane;
	public void drawDice(){
		dicePane.drawDice();
	}
	public void drawArea(){
		tokyoPane.draw();
	}
	public void setDice(DiceSet dice) {
		dicePane.setDice(dice);	
	}
	public Boolean[] getUnselectedDice() {
		return dicePane.checkToggleState(false);
	}
	public void write(String text) {
		System.out.println(text);
	}
	public void setTokyoArea(TokyoArea tokyoArea){
		tokyoPane.setTokyoArea(tokyoArea);
	}
	public Window() {
	JFrame frame = new JFrame("HI");
	JPanel layout = new JPanel();
	dicePane = new DicePane();
	layout.add(dicePane.getPanel());
	tokyoPane = new TokyoPane();
	layout.add(tokyoPane.notTokyoAreaHolder);
	layout.add(tokyoPane.tokyoAreaHolder);
	BoxLayout topLayout = new BoxLayout(layout,BoxLayout.X_AXIS);
	frame.add(layout);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,600));
	}
	public void setMainButtonListener(ActionListener l) {
		dicePane.getOkButton().addActionListener(l);
	}


}
