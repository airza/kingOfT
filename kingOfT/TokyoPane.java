package kingOfT;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TokyoPane {
	private TokyoArea tokyoArea;
	private JPanel tokyoAreaHolder;
	private JPanel notTokyoAreaHolder;
	final ImageIcon icon[] = {
			new ImageIcon("Pictures/m1.png", "Monster 1"),
			new ImageIcon("Pictures/m2.png", "Monster 2"),
			new ImageIcon("Pictures/m3.png", "Monster 3"),
			new ImageIcon("Pictures/m4.png", "Monster 4"),
			new ImageIcon("Pictures/m5.png", "Monster 5"),
			new ImageIcon("Pictures/m6.png", "Monster 6")
	};
	public TokyoPane(TokyoArea tokyoArea) {
		this.tokyoArea = tokyoArea;
	}
	
	
}
