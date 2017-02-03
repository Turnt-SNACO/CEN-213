package def;

public class Armor extends Item{
	private int defense;
	//Constructor
	public Armor(String name, int weight, int defense) {
		super(name, weight);	this.defense=defense;
	}
	//Returns an integer value for the defense rating of the armor
	public int getDefense(){
		return defense;
	}
	//Returns a thorough description of all item attributes
	public String examine(){
		return ("This is a "+super.getName()+" with weight "+super.getWeight()+" and defense "+defense+". It is Armor.");
	}
}
