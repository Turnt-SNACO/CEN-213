package def;

public class Weapon extends Item{
	private int damage;
	public Weapon(String name, int weight, int damage) {
		super(name, weight);
		this.damage=damage;
	}
	public int getDamage(){
		return damage;
	}
	public String examine(){
		return("This is a "+super.getName()+" with weight "+super.getWeight()+" and damage "+damage+".  It is a weapon.");
	}

}
