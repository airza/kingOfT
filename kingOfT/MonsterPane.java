package kingOfT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MonsterPane {
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
			test = t;
			for(int i = 0; i<6;i++){
				JLabels[i].setText(test);
			}
			draw(test, "A","Z"); 
	}
	public void draw(String monsterInfo, String monsterName, String monsterTokyo) {
		if(intStart==6)
			intStart=0;
		
		String tokyo = monsterTokyo;
		String name = monsterName;
		test = monsterInfo;
		
		
			//JLabels[j-65].setText(test);
		
		
			
		if(name.compareToIgnoreCase("A")==0){
				JLabels[0].setText(test);
				JLabels[0].setForeground(Color.black);
				JLabels[0].setBackground(Color.black);
		}
			if(name.compareToIgnoreCase("B")==0){
				JLabels[1].setText(test);
				JLabels[1].setForeground(Color.black);
				JLabels[1].setBackground(Color.black);
			}
			if(name.compareToIgnoreCase("C")==0){
				JLabels[2].setText(test);
				JLabels[2].setForeground(Color.black);
				JLabels[2].setBackground(Color.black);
			}
			if(name.compareToIgnoreCase("D")==0){
				JLabels[3].setText(test);
				JLabels[3].setForeground(Color.black);
				JLabels[3].setBackground(Color.black);
			}
			if(name.compareToIgnoreCase("E")==0){
				JLabels[4].setText(test);
				JLabels[4].setForeground(Color.black);
				JLabels[4].setBackground(Color.black);
			}
			if(name.compareToIgnoreCase("F")==0){
				JLabels[5].setText(test);
				JLabels[5].setForeground(Color.black);
				JLabels[5].setBackground(Color.black);
			}
			if(intStart==6)
				JLabels[0].setText("THIS SHOULDN'T HAPPEN. RESET intStart"); 

			/*if(tokyo!="Z"){
				
				if(name.compareToIgnoreCase("A")==0){
					JLabels[0].setForeground(Color.blue);
					JLabels[0].setBackground(Color.lightGray);
				}
				if(name.compareToIgnoreCase("B")==0){
					JLabels[1].setForeground(Color.blue);
					JLabels[1].setBackground(Color.lightGray);
				}
					
				if(name.compareToIgnoreCase("C")==0){
					JLabels[2].setForeground(Color.blue);
					JLabels[2].setBackground(Color.lightGray);
				}
				if(name.compareToIgnoreCase("D")==0){
					JLabels[3].setForeground(Color.blue);
					JLabels[3].setBackground(Color.lightGray);
				}
					
				if(name.compareToIgnoreCase("E")==0){
					JLabels[4].setForeground(Color.blue);
					JLabels[4].setBackground(Color.lightGray);
				}
					
				if(name.compareToIgnoreCase("F")==0){
					JLabels[5].setForeground(Color.blue);
					JLabels[5].setBackground(Color.lightGray);
				}
					
			}
			*/
			intStart++; tokyo="";
			
		}
	}
		

	
	
	

