package kingOfT;

import java.util.HashMap;
import java.util.Random;

public class DiceSet {
	private int rollsLeft;
	private int[] diceState;
	private int setSize;
	private static final int NUMBER_OF_SIDES = 6;
	static private Random diceRoller = new Random();
	
	/*This block contains the info to render the dice into text -
	we'll need to replace it with images in the final version*/
	private final static HashMap diceRenders = new HashMap();
	static {
		diceRenders.put(0,"E");
		diceRenders.put(1,"1");
		diceRenders.put(2,"2");
		diceRenders.put(3,"3");
		diceRenders.put(4,"X");
		diceRenders.put(5,"H");
		
	}
	
	public String stateRender() {
		//This should be handled by the view later?
		StringBuilder str = new StringBuilder();
		for (int i = 0; i<diceState.length; i++) {
			str.append(diceRenders.get(i));
		}
		return str.toString();
	}
	public int getRollsLeft() {
		return rollsLeft;
	}
	
	public void setRollsLeft(int r) {
		this.rollsLeft = r;
	}
	public void rollDice(Boolean[] rolls) {
		/*this should probably have more explosions if
		someone tries to roll while empty*/
		if (rollsLeft == 0) {
			return;
		}
		assert(rolls.length == diceState.length);
		for(int i = 0; i< setSize; i++){
			if (rolls[i] == true){
				diceState[i] = diceRoller.nextInt(NUMBER_OF_SIDES);
			}
		}
		rollsLeft--;
	}
	public DiceSet(int n, int s) {
	rollsLeft = n;
	setSize = s;
	}
}
