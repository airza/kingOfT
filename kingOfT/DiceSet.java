package kingOfT;

import java.util.HashMap;
import java.util.Random;

public class DiceSet {
	private int rollsLeft;
	private int[] diceState;
	private int diceCount;
	private static final int NUMBER_OF_SIDES = 6;
	static private Random diceRoller = new Random();
	
	public void setState (int[] states) {
		diceState = states;
	}
	
	public int getIndexState(int index){
		return diceState[index];
	}
	public int countState(int state){
		//count number of dice with given state
		int count = 0;
		for (int d :diceState) {
			if (d == state){
				count++;
			}
		}
		return count;
	}
	public Boolean[] findState(int state){
		//return an array with the same size as the dice with TRUE if the state is equal
		//and false otherwise.
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
		//for each die, the dice will be rolled if true.
		assert(rollsLeft != 0);
		assert(rolls.length == diceState.length);
		for(int i = 0; i< diceCount; i++){
			if (rolls[i] == true){
				diceState[i] = diceRoller.nextInt(NUMBER_OF_SIDES);
			}
		}
		rollsLeft--;
	}
	public void rollDice() {
		//rolls all the dice!  this method is basically useless
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
