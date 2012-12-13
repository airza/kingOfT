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
	
	final MonsterGUI mons = new MonsterGUI();
	String[] anArray = new String[24];
	JLabel[] JLabels = new JLabel[24];
	
	
	public MonsterPane(){
		
		for(int i = 0; i < 24; i++) {
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
		
		panel.setVisible(true);
		
		return panel;
	}
	public  void setLabels() {
		//mons.getValues();
		
		for(int i =intStart; i <=(intStart+4);i++){ 
			
			if(i==0|i==4|i==8|i==12|i==16|i==20){
				JLabels[i].setText("Name: " + anArray[i]);
			}
			else if(i==1| i==5|i==9|i==13|i==17|i==21){
				JLabels[i].setText("Health: " + anArray[i]);
			}
			else if(i==2|i==6|i==10|i==14|i==18|i==22){
				JLabels[i].setText("VP: " + anArray[i]);
			}
			else if(i==3|i==7|i==11|i==15|i==19|i==23){
				JLabels[i].setText("Energy: " + anArray[i]);
			}
			JLabels[i].setVisible(true);
			
		}
		
		
	}
	public void mons(String ii){
		for(int i = 0; i <=3; i++){
			anArray[i]=ii;	
		}
		intStart=mons.intStart();
	}
	public void setPanel(){	
		
		panel = new JPanel();
		
		mons.getValues();

		for(int i =1; i <=(23);i++){ 
			if(i==0|i==4|i==8|i==12|i==16|i==20){
				JLabels[i].setText("Name: " + anArray[i]);
			}
			else if(i==1| i==5|i==9|i==13|i==17|i==21){
				JLabels[i].setText("Health: " + anArray[i]);
			}
			else if(i==2|i==6|i==10|i==14|i==18|i==22){
				JLabels[i].setText("VP: " + anArray[i]);
			}
			else if(i==3|i==7|i==11|i==15|i==19|i==23){
				JLabels[i].setText("Energy: " + anArray[i]);
			}
			JLabels[i].setVisible(true);
			
		}
		
		
		
		GridLayout box = new GridLayout(6,4);
		panel.setLayout(box);
		panel.setVisible(true);
		panel.setMinimumSize(new Dimension(100,500));
		for(int i = 0; i < 24; i++) {
			panel.add(JLabels[i]);
		}
		setLabels();	
	    panel.setLocation(600, 400);
		
	}
}
	
	
	

