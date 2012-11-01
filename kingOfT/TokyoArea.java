package kingOfT;

import java.util.ArrayList;
import java.util.Collections;

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
	if (monsterCount() > 4) {
		return (tokyoMon == null ) || (tokyoBayMon == null);
	} else {
		return (tokyoMon == null);
	}
}
public void RemoveFromTokyo(Monster m) {
	assert(m == tokyoMon || m ==tokyoBayMon);
		tokyoMon = tokyoBayMon;
		tokyoBayMon = null;
	notInTokyo.add(m);
}
public String stateRender() {
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
