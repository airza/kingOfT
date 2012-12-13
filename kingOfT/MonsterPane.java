package kingOfT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Array;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonsterPane {
	
	public JPanel panel;
	public int intStart =0;
	//public JButton test = new JButton();
	
	//static MonsterGUI mons = new MonsterGUI();
	
	//Monster mon = new Monster("");
	String[] anArray = new String[24];
	JLabel[] JLabels = new JLabel[24];
	Game game;
	String test= "this shouldnt happen";
	
	public MonsterPane(){
		
		for(int i = 0; i < 6; i++) {
             JLabels[i] = new JLabel();
             anArray[i] = new String(" ");
            JLabels[i].setVisible(true);
            JLabels[i].setText(anArray[i]);
            
         }
	
		
		
		
	}
	public JPanel getPanel() {
		/** 
		 * Returns JPanel  to a class
		 */
		
		setPanel();
		
		
		return panel;
	}
	
	
	public void setPanel(){	
		
		panel = new JPanel();
		
		
		
		
		
		GridLayout box = new GridLayout(6,1);
		panel.setLayout(box);
		panel.setVisible(true);
		panel.setMinimumSize(new Dimension(100,500));
		for(int i = 0; i < 6; i++) {
			JLabels[i].setText(i+"");
			panel.add(JLabels[i]);
		}
	    panel.setLocation(600, 400);
		
	}
	public void resetValues(String t){
		System.out.println(t);
		test=t;
			JLabels[1].setText(t);
			
		
	}
}
	
	
	

