package kingOfT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
private final int NUMBER_OF_REROLLS = 3;
private final int NUMBER_OF_DICE = 6;
private tokyoArea board;
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


private void win(Monster m) {
	
}
private void lose(Monster m) {
	monsters.remove(m);
}
public void takeTurn() {
	DiceSet dice = new DiceSet(NUMBER_OF_REROLLS,NUMBER_OF_DICE);
	dice.rollDice();
	System.out.println(dice.stateRender());
	while(dice.getRollsLeft()>0) {
		Boolean[] rerolls = chooseDice(NUMBER_OF_DICE);
		dice.rollDice(rerolls);
		draw(dice.stateRender());
	}
		handleDice(curMon,dice);
		cleanUp();
}
private void draw(String string) {
	System.out.println(string);
}

private void drawTokyo() {
	for (Monster m : getMonstersInTokyo()){
		System.out.printf("%s is in tokyo!\n",m.getName());
	}
	for (Monster m: getMonstersNotInTokyo()){
		System.out.printf("%s is not in tokyo!\n",m.getName());
	}
}
private void handleDice(Monster monster, DiceSet die) {
	int energy = die.countState(0);
	int claws = die.countState(4);
	int hearts = die.countState(5);
	for (int d = 1; d == 3; d++){
		int dCount = die.countState(d);
		if (dCount  >= 3) {
			monster.gainVictory(d + Math.max(0, dCount-3));
			
		}
	}
	monster.gainEnergy(energy);
	if (!monster.inTokyo) {
		monster.gainHealth(hearts);
	}
	
	if (!monster.inTokyo && claws > 0) {
		for (Monster hitMon : getMonstersInTokyo()){
			hitMon.gainHealth(-1*claws);
			
		}
	}
}

public Boolean[] chooseDice(int diceNum){
	Boolean[] responses = new Boolean[diceNum];
	Scanner scansworth = new Scanner(System.in);
	for (int i=0; i<diceNum; i++){
        System.out.printf("Reroll this die? Y\\N (%d)\n",i+1);

        // Give three chances to user for correct input.. 
        // Else fill this array element with false value..

        while (!scansworth.hasNext("[YN]")) {
            String next = scansworth.next();
            if(!(next == "Y" || next == "N")) {
            System.out.printf("Invalid input! Enter a valid response for die %d! \n",i+1);
            }
        }    
             /** User has entered valid input.. check it for Y, or N **/
             responses[i] = (scansworth.next()).equals("Y") ? true : false;
        // If User hasn't entered valid input.. then it will not go in the if  
        // then this element will have default value `false` for boolean..
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
