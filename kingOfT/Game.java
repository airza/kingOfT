package kingOfT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
public ArrayList<Monster> monsters;
public Monster curMon;
private final int NUMBER_OF_REROLLS = 3;
private final int NUMBER_OF_DICE = 6;
public void cleanUp() {
	for(Monster m: monsters){
		if (m.getHealth()<=0){
			lose(m);
		}
		if (m.getHealth() >= 20){
			win(m);
		}
	}
	int nextMon = (monsters.indexOf(curMon) + 1) % (monsters.size() + 1);
	curMon = monsters.get(nextMon);
}
public Monster getMonsterInTokyo(){
	for (Monster m: monsters){
		if (m.inTokyo) {
			return m;
		}
	}
	return null;
}

private void win(Monster m) {
	
}
private void lose(Monster m) {
	monsters.remove(m);
}
public void takeTurn() {
	DiceSet dice = new DiceSet(NUMBER_OF_REROLLS,NUMBER_OF_DICE);
	dice.rollDice();
	while(dice.getRollsLeft()>0) {
		Boolean[] rerolls = chooseDice(NUMBER_OF_DICE);
		dice.rollDice(rerolls);
		draw(dice.toString());
	}
		handleDice(curMon,dice);
		cleanUp();
}
private void draw(String string) {
	System.out.println(string);
}
private void handleDice(Monster monster, DiceSet die) {
	// TODO Auto-generated method stub
	
}
public Boolean[] chooseDice(int diceNum){
	Boolean[] responses = new Boolean[diceNum];
	Scanner scansworth = new Scanner(System.in);
	for (int i=0; i<diceNum; i++){
		System.out.printf("Reroll this die? (%d)\n",i);
			responses[i] = (scansworth.next("[YN]")) == "Y" ? true : false;
	}
	return responses;
}
public Game (int num_of_monsters, String[] names) {
	monsters = new ArrayList<Monster>();
	for (int i= 0; i <num_of_monsters; i++){
		Monster mon = new Monster(names[i]);
		monsters.add(mon);
	}
	Collections.shuffle(monsters);
	curMon = monsters.get(0);
}
}
