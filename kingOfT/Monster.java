package kingOfT;

public class Monster {

	
	private int health;
	private int vp;
	private int energy;
	private String name;
	public Boolean inTokyo;
	//private ArrayList<cards> cards;
	
	
	public void takeDamage (int damage) {
		health -= damage;
	}
	public int getHealth(){
		return health;
	}
	public void gainHealth (int heal) {
		health  = Math.max(10, health+heal);
	}
	
	public void gainVictory(int points){
		vp += points;
	}
	public void gainEnergy (int en) { 
		energy += en;
	}
	public Monster(String itsName) {
		name = itsName;
		energy = 0;
		health = 10;
		vp = 0;
	}
	public boolean isDead() {
		return health<=0;
	}
}
