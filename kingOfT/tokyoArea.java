package kingOfT;

import java.util.ArrayList;

public class tokyoArea {
private Monster tokyoMon = null;
private Monster tokyoBayMon = null;
private ArrayList<Monster> notInTokyo;

public tokyoArea (ArrayList<Monster> mons) {
	notInTokyo = mons;
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
	if 
}
}
