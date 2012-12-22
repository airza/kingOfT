package kingOfT;

/**
 * @see the required variables used to controll the monsters  
 */

import java.util.ArrayList;
import java.util.Collections;
/**
 * This class is used to control the monsters behavior while they are in tokyo or while a monster is trying to get into tokyo. It uses @see arraylists. 
 *  It is also used to move the monsters between different "areas" on the board. @exception the only two places where the monsters should be is in 
 *  Tokyo or not. There is two strips of white that signify this. 
 *  This class also is in controll of four player and six player logic controlling. @param mons 
 *  
 */
public class TokyoArea {
private Monster tokyoMon = null;
private Monster tokyoBayMon = null;
private ArrayList<Monster> notInTokyo;
private ArrayList<Monster> monsters;

public int monsterCount(){
	return monsters.size();
}
public Monster getCurMon(){
	return monsters.get(0);
}
public Boolean inTokyo(Monster mon){
	return !notInTokyo.contains(mon);
}
public TokyoArea (ArrayList<Monster> mons) {
	notInTokyo = new ArrayList<Monster>(mons);
	monsters = new ArrayList<Monster>(mons);
	Collections.shuffle(monsters);
}

public ArrayList<Monster> getMonsters() {
	return monsters;
}
public void advanceMonsterTurn() { 
    Monster tempMon = monsters.get(0);
    monsters.remove(0);
	monsters.add(tempMon);
}
public ArrayList<Monster> getMonstersInTokyo(){
	//we could probably just store these in an array, oh well
	ArrayList<Monster> monsInTokyo = new ArrayList<Monster>();
	if (tokyoMon!= null ){
		monsInTokyo.add(tokyoMon);
	} 
	if (tokyoBayMon != null) {
		monsInTokyo.add(tokyoBayMon);
	}
	return monsInTokyo;
}
public ArrayList<Monster> getMonstersNotInTokyo(){
	return notInTokyo;
}
public void AddToTokyo(Monster mons) {
	if (monsterCount() <=4) {
		
		//begin 4-player logic
		assert(tokyoMon == null);
		tokyoMon = mons;
	} else {
		
		//begin 5-6 player logic
		//player should get placed in tokyo if available, but if not, tb
		assert(tokyoMon == null || tokyoBayMon == null);
		if (tokyoMon == null && tokyoBayMon == null) {
			tokyoMon = mons;
		} else {
			tokyoBayMon = mons;
		}
	}
	notInTokyo.remove(mons);
}
public boolean tokyoHasSpace() {
	//check if there is empty space depending on game size
	if (monsterCount() > 4) {
		return (tokyoMon == null ) || (tokyoBayMon == null);
	} else {
		return (tokyoMon == null);
	}
}
public void RemoveFromTokyo(Monster m) {
	//this has the exact same effect in 4 or 6 player, and no matter what
	//state t/tb is in.
	assert(m == tokyoMon || m ==tokyoBayMon);
	
		if (m==tokyoMon) {
			tokyoMon = tokyoBayMon;
			tokyoBayMon = null;
		} else {
			tokyoBayMon = null;
		}
	notInTokyo.add(m);
}
public String stateRender() {
		//todo move to view
		StringBuilder str = new StringBuilder();
		for (Monster m : getMonstersInTokyo()){
			str.append(m.getName()+" is in tokyo!\n");
		}
		for (Monster m: getMonstersNotInTokyo()){
			System.out.printf(m.getName() + " is not in tokyo!\n");
		}
		return str.toString();
}
public void removeMonsters(ArrayList<Monster> killed) {
	//throw out monsters that are dead
	for (Monster m : killed){
		if (m == tokyoMon) {
			tokyoMon = null;
		} else if (m == tokyoBayMon) {
			tokyoBayMon = null;
		} else {
			notInTokyo.remove(m);
		}
		monsters.remove(m);
	}
}
public void removeMonsters(Monster killed) {
		if (killed == tokyoMon) {
			tokyoMon = null;
		} else if (killed == tokyoBayMon) {
			tokyoBayMon = null;
		} else {
			notInTokyo.remove(killed);
		}
		monsters.remove(killed);
}
}
