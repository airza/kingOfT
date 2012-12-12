package kingOfT;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class MonsterGUI {
	
	private String vP;
	private String energy;
	private String health; 
	private Monster mons;
	private JLabel healthj;
	private JLabel energyj;
	private JLabel VPj;
	
	public void MonsterGUI(){
		
	}
	public void setValues(){
		int Energy = mons.getEnergy();
		int VP = mons.getVP();
		int Health = mons.getHealth();
		String name = mons.getName();
		
		energy = "" + Energy;
		vP = "" + VP;
		health = "" + Health;
		healthj.setText(name);
		VPj.setText(vP);
		energyj.setText(energy);
		if(Health>0){
			healthj.setText(health);
		}
		
	}
	
	
}


