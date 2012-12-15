package kingOfT;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonsterPane {
	/*public Monster monsA = new Monster("A");
	public Monster monsB = new Monster("B");
	public Monster monsC = new Monster("C");
	public Monster monsD = new Monster("D");
	public Monster monsE = new Monster("E");
	public Monster monsF = new Monster("F"); */

	public JPanel panel= new JPanel();
	
	int intStart =0;
	JLabel[] JLabels = new JLabel[6];
	public String test = "";
	int idk=0;
	
	
		
	public MonsterPane(){
		for(int i = 0; i < 6; i++) {
			JLabels[i] = new JLabel();  
			JLabels[i].setText("");
         }	
	}
	/*public void getInformation(String t){
		if(idk==6){
		idk=0;
		}
		test[idk] = t;
		//System.out.println("MonsterPane.getInformation " + test);
	}*/

	public JPanel getPanel() {
		/** 
		 * Returns JPanel  to a class
		 */
		GridLayout box = new GridLayout(6,1);
		panel.setLayout(box);
		panel.setVisible(true);
		panel.setMinimumSize(new Dimension(100,500));		
		for(int i = 0; i<6; i++){
			panel.add(JLabels[i]);
		}
		
		setPanel(test);
		
		return panel;
	}
	public void setPanel(String t){	
		//Window win = new Window();
			test = t;
			for(int i = 0; i<6;i++){
				JLabels[i].setText(test);
			}
			
			draw(test, "x");
			
		
		 
	}
	public void draw(String test, String name) {
		if(intStart==6)
			intStart=0;
			if(name.compareToIgnoreCase("A")==0)
				JLabels[0].setText(test);
			if(name.compareToIgnoreCase("B")==0)
				JLabels[1].setText(test);
			if(name.compareToIgnoreCase("C")==0)
				JLabels[2].setText(test);
			if(name.compareToIgnoreCase("D")==0)
				JLabels[3].setText(test);
			if(name.compareToIgnoreCase("E")==0)
				JLabels[4].setText(test);
			if(name.compareToIgnoreCase("F")==0)
				JLabels[5].setText(test);
			if(intStart==6)
				JLabels[0].setText("THIS SHOULDN'T HAPPEN. RESET intStart");
			
			intStart++;
			
		}
	}
		

	
	
	

