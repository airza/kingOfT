
	package kingOfT;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



	public class MonsterGUI {
		
		Monster mons =  new Monster(" ");
		MonsterPane panes = new MonsterPane();
		private String store= "";
		private String starting;
		private int intStart;
		
		
		public void MonsterGUI(){
			
			
		}
		
		public void getValues(){
			
			starting= mons.getName();
			if(starting==null)
				starting="A";
			if(starting.compareToIgnoreCase("A")==0){
				intStart=0;
			}
			if(starting.compareToIgnoreCase("B")==0){
				intStart=4;
			}
			if(starting.compareToIgnoreCase("C")==0){
				intStart=8;
			}
			if(starting.compareToIgnoreCase("D")==0){
				intStart=12;
			}
			if(starting.compareToIgnoreCase("E")==0){
				intStart=16;
			}
			if(starting.compareToIgnoreCase("F")==0){
				intStart=20;
			}
			
			
			for(int i =intStart; i <=(intStart+3);i++){
				if(i==0|i==4|i==8|i==12|i==16|i==20){
					store=" "+mons.getName();
				}
				else if(i==1| i==5|i==9|i==13|i==17|i==21){
					store=" "+mons.getHealth();
				}
				else if(i==2|i==6|i==10|i==14|i==18|i==22){
					store=" "+mons.getVP();
				}
				else if(i==3|i==7|i==11|i==15|i==19|i==23){
					store=" "+mons.getEnergy();
				}
				
			
			}
				
		}
		
		public int intStart(){
			return intStart;
		}
		
			
		
		
		
	}




