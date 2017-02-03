package def;

public class Item {
	private int weight;
	private String name;
	//Constructor
	public Item(String name, int weight){
		this.name=name;	this.weight=weight;
	}
	//Returns a string with the name of the item
	public String getName(){
		return this.name;
	}
	//Returns an integer value of the weight of the item
	public int getWeight(){
		return this.weight;
	}
	//Returns a thorough description of all item attributes
	//This will be overloaded by subclasses as subclasses will have more attributes than an "Item"
	public String examine(){
		return ("This is a "+name+" with weight "+weight+".");
	}
}
