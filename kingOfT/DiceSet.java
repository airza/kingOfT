package kingOfT;

import java.util.HashMap;
import java.util.Random;

public class DiceSet {
	private int rollsLeft;
	private int[] diceState;
	private int diceCount;
	private static final int NUMBER_OF_SIDES = 6;
	static private Random diceRoller = new Random();
	
	/*This block contains the info to render the dice into text -
	we'll need to replace it with images in the final version*/
	private final static HashMap<Integer, String> diceRenders = new HashMap<Integer, String>();
	static {
		diceRenders.put(0,"E");
		diceRenders.put(1,"1");
		diceRenders.put(2,"2");
		diceRenders.put(3,"3");
		diceRenders.put(4,"X");
		diceRenders.put(5,"H");
		
	}
	public void setState (int[] states) {
		diceState = states;
	}
	public String stateRender() {
		//This should be handled by the view later?
		StringBuilder str = new StringBuilder();
		str.append("123456\n");
		for (int i = 0; i<diceState.length; i++) {
			str.append(diceRenders.get(diceState[i]));
		}
		return str.toString();
	}
	
	public int getIndexState(int index){
		return diceState[index];
	}
	public int countState(int state){
		int count = 0;
		for (int d :diceState) {
			if (d == state){
				count++;
			}
		}
		return count;
	}
	public Boolean[] findState(int state){
		Boolean[] hasState = new Boolean[diceCount];
		for (int i = 0; i<state; i++) {
				hasState[i] = (diceState[i] == state);
		}
		return hasState;
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
		for(int i = 0; i< diceCount; i++){
			if (rolls[i] == true){
				diceState[i] = diceRoller.nextInt(NUMBER_OF_SIDES);
			}
		}
		rollsLeft--;
	}
	public void rollDice() {
		Boolean[] rolls = new Boolean[diceCount];
		for (int i =0 ; i < diceCount;i++){
			rolls[i] = true;
		}
		rollDice(rolls);
	}
	public DiceSet(int n, int s) {
	rollsLeft = n;
	diceCount = s;
	diceState = new int[s];
	rollDice();
	}
}
