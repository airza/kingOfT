package kingOfT;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Array;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonsterPane {
	public Monster mons = new Monster("A");
	public JPanel panel= new JPanel();
	int intStart =0;
	JLabel[] JLabels = new JLabel[6];
	
	public String test ="Testing 123"; // "this shouldnt happen under public class monsterpane";
	int idk=0;
		
	public MonsterPane(){
		for(int i = 0; i < 6; i++) {
			JLabels[i] = new JLabel();          
         }	
	}
	public void getInformation(String t){
		test = t;
		//System.out.println("MonsterPane.getInformation " + test);
	}
	public JPanel getPanel() {
		/** 
		 * Returns JPanel  to a class
		 */
		//System.out.println("MonsterPane.getPanel " + test);
		//setPanel();
		return panel;
	}
	public void setPanel(){	
		
		//System.out.println("in setpanel monster pane " + test);
		 
	
		for(int i = 0; i < 6; i++) {
			
			panel.add(JLabels[i]);
			
			//System.out.println(test + " " + i);
			JLabels[i].setText(test);
			
			}
			GridLayout box = new GridLayout(6,1);
			panel.setLayout(box);
			panel.setVisible(true);
			panel.setMinimumSize(new Dimension(100,500));		
			
		
		
	}
	public JPanel updateValues(){
		System.out.println("In the updateValues method of MonsterPane");
		return panel;
	}
}
	
	
	

