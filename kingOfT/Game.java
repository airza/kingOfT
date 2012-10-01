package kingOfT;

import java.util.ArrayList;


public class Game {
public ArrayList<Monster> monsters;
public Monster currTurn;
public void cleanUp() {
	for(Monster m: monsters){
		if (m.health<=0){
		monsters.remove(m);
		}
		if (m.victoryPoints >= 20){
		
		}
	}
}
}
