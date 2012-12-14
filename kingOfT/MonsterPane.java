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

	 
	Game game;
	String test= "this shouldnt happen";
	
	public MonsterPane(){		
		for(int i = 0; i < 6; i++) {
             
         }
	
		
		
		
	}
	public JPanel getPanel() {
		/** 
		 * Returns JPanel  to a class
		 */
		setPanel(test);
		return panel;
	}
	public void setPanel(String t){	
		
		panel = new JPanel();
		System.out.println(t);
		
		JLabel[] JLabels = new JLabel[6];
		
		for(int i = 0; i<6; i++)
			JLabels[i] = new JLabel();
		
		GridLayout box = new GridLayout(6,1);
		panel.setLayout(box);
		panel.setVisible(true);
		panel.setMinimumSize(new Dimension(100,500));
		
		for(int i = 0; i < 6; i++) {
			JLabels[i].setText(t);
			panel.add(JLabels[i]);
		}
		
		
	    //panel.setLocation(600, 400);
		
	}
	public JPanel resetValues(String t){
		System.out.println(t);
		test=t;
		
		
		//panel.repaint();
		
		
		
		//for(int i =0; i<6; i++){d
			//panel.remove(JLabels[i]);
			//panel.add(JLabels[i]);
			//this.JLabels[i]= new JLabel();
			//this.JLabels[i].setText("help me");
			
		//}
		return panel;
	}
}
	
	
	

