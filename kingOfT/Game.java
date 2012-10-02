package kingOfT;

import java.util.ArrayList;


public class Game {
public ArrayList<Monster> monsters;
public Monster currTurn;
public void cleanUp() {
	for(Monster m: monsters){
		if (m.health<=0){
			lose(m);
		}
		if (m.vp >= 20){
			win(m);
		}
	}
}
private void win(Monster m) {
	// TODO Auto-generated method stub
	
}
private void lose(Monster m) {
	// TODO Auto-generated method stub
	
}
}
