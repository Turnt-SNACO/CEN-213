package def;

public class Armor extends Item{
	private int defense;
	public Armor(String name, int weight, int defense) {
		super(name, weight);	this.defense=defense;
	}
	public int getDefense(){
		return defense;
	}
	public String examine(){
		return ("This is a "+super.getName()+" with weight "+super.getWeight()+" and defense "+defense+". It is Armor.");
	}
}
