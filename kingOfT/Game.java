package kingOfT;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
private final int NUMBER_OF_REROLLS = 3;
private final int NUMBER_OF_DICE = 6;
private final int POINTS_FOR_TOKYO_START = 2;
private final int POINTS_FOR_TOKYO_ENTER = 1;
private TokyoArea board;
private Window window;

public Boolean askYNQuestion(String text){
	System.out.println(text);
	Scanner scansworth = new Scanner(System.in);
	String next = scansworth.next();
	while (!((next.contains("Y") || next.contains("N")))){
            System.out.println("Invalid input! Enter a valid response!");
        	System.out.println(text);
            next = scansworth.next();
	}
	return next.contains("Y");
}
public void cleanUp() {
	ArrayList<Monster> killed = new ArrayList<Monster>();
	ArrayList<Monster> winners = new ArrayList<Monster>();
	for(Monster m: board.getMonsters()){
		if (m.getHealth()<=0){
			draw(m.getName() + " was killed!");
			killed.add(m);
		}
		if (m.getVP() >= 20){
			winners.add(m);
		}
	}
	board.removeMonsters(killed);
	if (board.getMonsters().size() == 1) {
		winners.add(board.getMonsters().get(0));
	}
	if (winners.size() > 0) {
		for (Monster m: winners){
			draw(m.getName()+" Wins!");
		}
		System.exit(0);
	}
}


private void win(Monster m) {
	System.out.println(m.getName() + " WINS!");
	System.exit(0);
}
private Boolean someRerolled(Boolean[] choices) {
	//Find out if some dice were rerolled (The user doesn't have to keep rolling, otherwise
	Boolean someTrue = false;
	for (Boolean c :choices) {
		someTrue = someTrue || c;
	}
	return someTrue;
}

public void doRollsForTurn(DiceSet dice){
	dice.rollDice();
	window.drawDice();
	
while(dice.getRollsLeft()>0) {

	Boolean[] rerolls = chooseDice(NUMBER_OF_DICE);
	if (!someRerolled(rerolls)){
		break;
	}
	dice.rollDice(rerolls);
	window.drawDice();
}
}
public void takeTurn() {
	System.out.println(board.getCurMon().getName() + "'S TURN");
	if (board.getMonstersInTokyo().contains(board.getCurMon())){
		board.getCurMon().gainVictory(POINTS_FOR_TOKYO_START);
		cleanUp();
	}
	DiceSet dice = new DiceSet(NUMBER_OF_REROLLS,NUMBER_OF_DICE);
	window.setDice(dice);
	doRollsForTurn(dice);
	handleDice(dice);
	cleanUp();
	for (Monster m : board.getMonsters()) {
		draw(m.stateRender());
	}
	draw(board.stateRender());
	window.pause();
	board.advanceMonsterTurn();
}
private void draw(String string) {
	System.out.println(string);
}

public void handleDice(DiceSet die) {
	Monster curMon = board.getCurMon();
	int energy = die.countState(0);
	int claws = die.countState(4);
	int hearts = die.countState(5);
	
	//Add points for numbers
	for (int d = 1; d <= 3; d++){
		int dCount = die.countState(d);
		if (dCount  >= 3) {
			curMon.gainVictory(d + Math.max(0, dCount-3));
			
		}
	}

	curMon.gainEnergy(energy);
	
	boolean inTokyo = board.inTokyo(curMon);

	//Heal if not in tokyo;
	if (!inTokyo){
		curMon.gainHealth(hearts);
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
			board.AddToTokyo(curMon);
		}
	}
	cleanUp();
	
}

private boolean PromptToLeave(Monster hitMon) {
	if (hitMon.getHealth() <= 0) {
		return true; //Asking dead monsters to leave is impolite
	} else
		return askYNQuestion(hitMon.getName()+": Do you want to leave Tokyo?");

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
