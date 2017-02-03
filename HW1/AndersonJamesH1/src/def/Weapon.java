package def;

public class Weapon extends Item{
	private int damage;
	//Constructor
	public Weapon(String name, int weight, int damage) {
		super(name, weight);
		this.damage=damage;
	}
	//Returns damage int
	public int getDamage(){
		return damage;
	}
	//Returns a thorough description of all item attributes
	public String examine(){
		return("This is a "+super.getName()+" with weight "+super.getWeight()+" and damage "+damage+".  It is a weapon.");
	}

}
