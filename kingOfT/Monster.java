package kingOfT;

public class Monster implements Cloneable{

	
	private int health;
	private int vp;
	private int energy;
	private String name;
	//private ArrayList<cards> cards;
	//kokokokokok
	
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
	
	public String getName() {
		return name;
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
	public String stateRender() {
		StringBuilder str = new StringBuilder();
		str.append("Name: "+name+"\n");
		str.append("HP: "+name+"\n");
		str.append("Energy: "+energy+"\n");
		str.append("VP: "+vp+"\n");
		return str.toString();
	}
}
