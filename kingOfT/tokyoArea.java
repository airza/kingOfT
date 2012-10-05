package kingOfT;

import java.util.ArrayList;

public class tokyoArea {
private Monster tokyoMon = null;
private Monster tokyoBayMon = null;
private ArrayList<Monster> notInTokyo;

public tokyoArea (ArrayList<Monster> mons) {
	notInTokyo = mons;
}
public RemoveFromTokyo (Monster mons) {
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
}
