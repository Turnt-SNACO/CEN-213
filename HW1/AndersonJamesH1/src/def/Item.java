package def;

public class Item {
	private int weight;
	private String name;
	public Item(String name, int weight){
		this.name=name;	this.weight=weight;
	}
	public String getName(){
		return this.name;
	}
	public int getWeight(){
		return this.weight;
	}
	public String examine(){
		return ("This is a "+name+" with weight "+weight+".");
	}
}
