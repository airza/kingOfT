package kingOfT;

import java.util.ArrayList;
import java.util.Collections;

public class TokyoArea {
private Monster tokyoMon = null;
private Monster tokyoBayMon = null;
private ArrayList<Monster> notInTokyo;
private ArrayList<Monster> monsters;
private Monster curMon;

public int monsterCount(){
	return monsters.size();
}
public Monster getCurMon(){
	return curMon;
}
public Boolean inTokyo(Monster mon){
	return !notInTokyo.contains(mon);
}
public TokyoArea (ArrayList<Monster> mons) {
	notInTokyo = mons;
	monsters = mons;
	Collections.shuffle(monsters);
	curMon = monsters.get(0);
}

public ArrayList<Monster> getMonsters() {
	return monsters;
}
public void advanceMonster() { 
    int	size = monsterCount();
	int curMonIndex = monsters.indexOf(curMon);
	curMonIndex = (curMonIndex + 1) % (size-1);
	curMon = monsters.get(curMonIndex);
}
public void RemoveFromTokyo (Monster mons) {
	if (tokyoMon == mons) {
		notInTokyo.add(mons);
		if (tokyoBayMon == null) {
			tokyoMon = null;
		} else {
			tokyoMon = tokyoBayMon;
			tokyoBayMon = null;
		}
	} else if (tokyoBayMon == mons) {
		notInTokyo.add(mons);
		tokyoBayMon = null;
	}
}
public void KillMonster(Monster mons, Monster curMon) {
	
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
	if (monsterCount() > 4) {
		if (tokyoMon == null) {
			
		}
	}
}
public boolean tokyoHasSpace() {
	if (monsterCount() > 4) {
		return (tokyoMon == null ) || (tokyoBayMon == null);
	} else {
		return (tokyoMon == null);
	}
}
public void removeMonster(Monster m) {
	monsters.remove(m);
	if (tokyoMon == m){
		tokyoMon = tokyoBayMon;
		tokyoBayMon = null;
	}
	}
}
