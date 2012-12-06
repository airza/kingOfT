package kingOfT;
/** 
 * imports all nessassery stuff for the class 
 */
import java.util.HashMap;
import java.util.Random;
/** 
 * Starts the class DiceSet 
 * @author Michael
 *
 */
public class DiceSet {
	/** 
	 * Declares all variables 
	 */
	private int rollsLeft;
	private int[] diceState;
	private int diceCount;
	private static final int NUMBER_OF_SIDES = 6;
	static private Random diceRoller = new Random();
	
	public void setState (int[] states) {
		/** 
		 * sets diceSet into an array
		 */
		diceState = states;
	}
	
	public int getIndexState(int index){
		/** 
		 * return statement for the setState method above 
		 */
		return diceState[index];
	}
	public int countState(int state){
		/** 
		 * Counts the dice and the state (clicked or not) of the dice 
		 */
		//count number of dice with given state
		
		int count = 0;
		for (int d :diceState) {
			if (d == state){
				count++;
			}
		}
		/** 
		 * returns the above statement
		 */
		return count;
	}
	public Boolean[] findState(int state){
		/** 
		 * returns an array that holds only the dice with true and then does the same for false. 
		 */
		//return an array with the same size as the dice with TRUE if the state is equal
		//and false otherwise.
		Boolean[] hasState = new Boolean[diceCount];
		for (int i = 0; i<state; i++) {
				hasState[i] = (diceState[i] == state);
		}
		return hasState;
	}
	public int getRollsLeft() {
		/** 
		 * returns the number of rolls left for a given class
		 */
		return rollsLeft;
	}
	
	public void setRollsLeft(int r) {
		this.rollsLeft = r;
	}
	public void rollDice(Boolean[] rolls) {
		/** 
		 * rolls all dice that have been clicked
		 */
		//for each die, the dice will be rolled if true.
		assert(rollsLeft != 0);
		assert(rolls.length == diceState.length);
		for(int i = 0; i< diceCount; i++){
			if (rolls[i] == true){
				diceState[i] = diceRoller.nextInt(NUMBER_OF_SIDES);
			}
		}
		/** 
		 * subtracts the number of rolls left by to. 
		 */
		rollsLeft--;
	}
	public void rollDice() {
		/** 
		 * Rolls all the dice(no need for this because it is never used. )
		 */
		//rolls all the dice!  this method is basically useless
		Boolean[] rolls = new Boolean[diceCount];
		for (int i =0 ; i < diceCount;i++){
			rolls[i] = true;
		}
		rollDice(rolls);
	}
	public DiceSet(int n, int s) {
		/** 
		 * Allows for other classes to access the data from this class and return it to be used 
		 * in sync. ie. if a class subtracts a roll this class finds out about it. 
		 */
	rollsLeft = n;
	diceCount = s;
	diceState = new int[s];
	rollDice();
	}
}
