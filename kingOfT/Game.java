package kingOfT;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
private final int NUMBER_OF_REROLLS = 3;
private final int NUMBER_OF_DICE = 6;
private TokyoArea board;
private Window window;

public void cleanUp() {
	ArrayList<Monster> killed = new ArrayList<Monster>();
	for(Monster m: board.getMonsters()){
		if (m.getHealth()<=0){
			draw(m.getName() + " was killed!");
			killed.add(m);
		}
		if (m.getVP() >= 20){
			win(m);
		}
	}
	board.removeMonsters(killed);
	if (board.getMonsters().size() == 1) {
		win(board.getMonsters().get(0));
	}
	board.advanceMonsterTurn();
}


private void win(Monster m) {
	System.out.println(m.getName() + " WINS!");
	System.exit(0);
}
private Boolean someRerolled(Boolean[] choices) {
	Boolean someTrue = false;
	for (Boolean c :choices) {
		someTrue = someTrue || c;
	}
	return someTrue;
} 
public void takeTurn() {
	System.out.println(board.getCurMon().getName() + "'S TURN");
	DiceSet dice = new DiceSet(NUMBER_OF_REROLLS,NUMBER_OF_DICE);
	dice.rollDice();
	System.out.println(dice.stateRender(window));
	while(dice.getRollsLeft()>0) {
		Boolean[] rerolls = chooseDice(NUMBER_OF_DICE);
		if (!someRerolled(rerolls)){
			break;
		}
		dice.rollDice(rerolls);
		draw(dice.stateRender(window));
	}
	handleDice(board.getCurMon(),dice);
	cleanUp();
	for (Monster m : board.getMonsters()) {
		draw(m.stateRender());
	}
	draw(board.stateRender());

}
private void draw(String string) {
	System.out.println(string);
}

private void handleDice(Monster monster, DiceSet die) {
	int energy = die.countState(0);
	int claws = die.countState(4);
	int hearts = die.countState(5);
	
	//Add points for numbers
	for (int d = 1; d <= 3; d++){
		int dCount = die.countState(d);
		if (dCount  >= 3) {
			monster.gainVictory(d + Math.max(0, dCount-3));
			
		}
	}

	monster.gainEnergy(energy);
	
	boolean inTokyo = board.inTokyo(monster);

	//Heal if not in tokyo;
	if (!inTokyo){
		monster.gainHealth(hearts);
	}
	
	//Hit monsters not in tokyo, if you're in tokyo
	if (inTokyo && claws > 0) {
		for (Monster hitMon : board.getMonstersNotInTokyo()){
			hitMon.gainHealth(-1*claws);
			
		}
	}
	
	//Hit monsters in tokyo if you're in tokyo
	if (!inTokyo && claws > 0) {
		for (Monster hitMon : board.getMonstersInTokyo()){
			hitMon.gainHealth(-1*claws);
			boolean hitMonLeft = PromptToLeave(hitMon);
			if (hitMonLeft) {
				board.RemoveFromTokyo(hitMon);
			}
		}
		if(board.tokyoHasSpace()){
			board.AddToTokyo(monster);
		}
	}
	
}

private boolean PromptToLeave(Monster hitMon) {
	if (hitMon.getHealth() <= 0) {
		return true; //Asking dead monsters to leave is impolite
	}
	System.out.println(hitMon.getName() + ": Do you want to leave Tokyo? Y/N");
	Scanner scansworth = new Scanner(System.in);
	String next = scansworth.next();
	while (!((next.contains("Y") || next.contains("N")))){
            System.out.println("Invalid input! Enter a valid response!");
            next = scansworth.next();
	}
	return next.contains("Y");
}


public Boolean[] chooseDice(int diceNum){
	Boolean[] responses = new Boolean[diceNum];
	Scanner scansworth = new Scanner(System.in);
    System.out.printf("Enter the dice to reroll: (1-%d) or Q to stop rolling\n", diceNum);
    String next = scansworth.next();
    for (Integer i = 1; i<=diceNum; i++) {
    	if (!next.contains("Q")){
    	responses[i-1] = next.contains(i.toString());
    	} else {
    		responses[i-1] = false;
    	}
    }
	return responses;
}
public Game (int num_of_monsters, String[] names, Window win) {
	ArrayList<Monster> monsters = new ArrayList<Monster>(num_of_monsters);
	for (int i= 0; i <num_of_monsters; i++){
		Monster mon = new Monster(names[i]);
		monsters.add(mon);
	}
	board = new TokyoArea(monsters);
	window = win;
}
}
