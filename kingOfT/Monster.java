package kingOfT;

public class Monster{

	/**
	 * @see the required variables used to controll the monsters "points" 
	 */
	private int health;
	private int vp;
	private int energy;
	private String name;
	//private ArrayList<cards> cards;
	//kokokokokok
	/**
	 * 
	 * @param damage is sent by a class usually the Game 
	 * @param health sends the health back to the game class as well as the MonsterGUI class 
	 * @param heal is used if a monster gains health 
	 * @param points is used when calculating the VP points 
	 * @param energy is used when the monster gains energy 
	 * @exception the health, VP, and Energy are all used and accessed by the MonsterGUI class 
	 * @see the last four methods are used to see if a monster is dead and what to do if a monster is died; or
	 * decrease the standard amount of damage. 
	 * @exception the last method is used to return the VP 
	 * 
	 */
	
	
	public void takeDamage (int damage) {
		health -= damage;
	}
	public int getHealth(){
		return health;
	}
	public void gainHealth (int heal) {
		health  = Math.min(10, health+heal);
	}
	
	public void gainVictory(int points){
		vp += points;
	}
	public void gainEnergy (int en) { 
		energy += en;
	}
	public int getEnergy(){
		return energy;
	}
	
	public String getName() {
		return name;
	}
	public Monster(String itsName) {
		name = itsName;
		energy = 0;
		health = 100;
		vp = 0;
	}
	public boolean isDead() {
		return health<=0;
	}
	public String stateRender() {
		StringBuilder str = new StringBuilder();
		str.append("Name: "+name+"\n");
		str.append("HP: "+health+"\n");
		str.append("Energy: "+energy+"\n");
		str.append("VP: "+vp+"\n");
		return str.toString();
	}
	public int getVP() {
		return vp;
	}
}
