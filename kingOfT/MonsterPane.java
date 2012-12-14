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
	
	Game game;
	String test= "this shouldnt happen";
	int idk=0;
	// lkadsfjads;lfj a;lfkjads;lfka;lkadj;l
	public MonsterPane(){		
		for(int i = 0; i < 6; i++) {
			JLabels[i] = new JLabel();
          
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
		idk++;
		

		GridLayout box = new GridLayout(6,1);
		panel.setLayout(box);
		panel.setVisible(true);
		panel.setMinimumSize(new Dimension(100,500));
		
		
		
		for(int i = 0; i < 6; i++) {
			panel.add(JLabels[i]);
			idk++;
			System.out.println(t + " " + i+ " " + idk);JLabels[i].setText(t);
				
			if(t.compareTo("this shouldnt happen")==0&&idk<4){
				JLabels[i].setText("Testing asoldfjasdlkfj ");
			}
		}
		
	    //panel.setLocation(600, 400);
		
	}
	public JPanel updateValues(){
		
		return panel;
	}
}
	
	
	

