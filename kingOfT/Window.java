package kingOfT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
/** start of window class
  */ 

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
		monsterInfo = text;
		System.out.println(text);
		
	}
	public String monsterInfo(){
		System.out.println(monsterInfo);
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
	monster = new MonsterPane();
	JFrame frame = new JFrame("HI");
	JPanel layout = new JPanel();
	dicePane = new DicePane();
	layout.add(dicePane.getPanel());
	layout.add(monster.getPanel());
	tokyoPane = new TokyoPane();
	layout.add(tokyoPane.notTokyoAreaHolder);
	layout.add(tokyoPane.tokyoAreaHolder);
	layout.add(tokyoPane.monsterInfo);
	frame.add(layout);
	//frame.add(monster.getPanel());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setMinimumSize(new Dimension(800,600));
	
	} 
	
	public void setMainButtonListener(ActionListener l) {
		dicePane.getOkButton().addActionListener(l);
	}
	/** 
	 * "turns on" main button listener  threw the dice pane class dicePane 
	 */


}
