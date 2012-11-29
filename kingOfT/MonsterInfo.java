package kingOfT;

import java.awt.GridLayout;
import javax.swing.*;

public class MonsterInfo extends JFrame{
	//imports all nessasery packages for the gui


	//creates all nessasery parts of the GUI including JLabels and int for the background code. 
	private JLabel health;
	private JLabel dest;
	private JLabel wham;
	private int whampoint = 0;
	private int destpoint=0;
	public int healthprecent=100; 
	//creates and instaties the GUI and JLabels with there starting values. 
	public void Monsters(){
		
		setLayout(new GridLayout(3,1));
		health = new JLabel("Health: 0");
		dest =  new JLabel("Destruction: 0");
		wham=new JLabel("Wham: 0");	
		add(health);
		add(dest);
		add(wham);
	}
	//Calculates the points and displayes them on the screen and keeps track of the score. 
	//THIS IS THE ONLY METHOD NESSASERY TO COMPLETE THIS.
	public void monsterInfo(int whamsgained, int destingained, int healthlostpercent)
	{
		healthprecent = healthlostpercent; 
		destpoint+=destingained;
		whampoint+=whamsgained; 
		health.setText("Health: " + healthprecent);
		dest.setText("Destruction: "+destpoint);
		wham.setText("Wham: " + whampoint);	
		
	}
	
	

}


