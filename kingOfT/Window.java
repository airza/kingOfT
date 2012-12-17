package kingOfT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
/** start of window class */ 
/*
 * @author School
 *
 */
public class Window {
	public static Boolean askYNQuestion(String text){
		/**
		 * Starts JPane
		 */
		return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,text,null,JOptionPane.YES_NO_OPTION);
	}
	/** 
	 * Adds all nessessary variables for the window to transport information to and from classes
	 */ 
	JButton[] diceButtons;
	DicePane dicePane;
	MonsterPane monster;
	JTextArea log;
	TokyoPane tokyoPane;
	public String monsterInfo;
	public void drawDice(){
		dicePane.drawDice();
		/** 
	 * Calls the drawDice method from the dicePane Class 
	 */
	}
	public void drawArea(){
		tokyoPane.draw();
		/** 
		 * calls the draw method from the tokyoPane
		 */
	}
	public void setDice(DiceSet dice) {
		dicePane.setDice(dice);	
		/** 
		 * Pases "dice" threw the setDice class in dicePane
		 */
	}
	public Boolean[] getUnselectedDice() {
		return dicePane.checkToggleState(false);
		/** 
		 * 
		 * Calls to see if the dice are selected and then returns the boolean logic of false 
		 * threw the checkToggleState method in dicePane
		 */
	}
	public void write(String text) {
		/** 
		 * Prints out "text" in the command line 
		 */
		System.out.println(text);
		
	}
	public String monsterInfo(){
		return monsterInfo;
	}
	public void setTokyoArea(TokyoArea tokyoArea){
		tokyoPane.setTokyoArea(tokyoArea);
		/** 
		 * passes tokyoArea threw setTokyoArea in the tokyoPane class
		 */
	}
	/** 
	 * Sets all the nessesary window stuff including the title bar and layots from the different classes. 
	 */
	public Window() {
	final JFrame frame = new JFrame("King Of Toyko");
	JPanel layout = new JPanel();
	dicePane = new DicePane();
	layout.add(dicePane.getPanel());
	monster = new MonsterPane();
	layout.add(monster.getPanel());
	tokyoPane = new TokyoPane();
	layout.add(tokyoPane.notTokyoAreaHolder);
	layout.add(tokyoPane.tokyoAreaHolder);
	frame.add(layout);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,375));
	frame.repaint();
	} 
	public void setMainButtonListener(ActionListener l) {
		dicePane.getOkButton().addActionListener(l);
	}
	
	/** 
	 * "turns on" main button listener  threw the dice pane class dicePane 
	 */
}
