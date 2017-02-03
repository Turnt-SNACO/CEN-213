package def;

public class Food extends Item{
	private int nutrition, quantity;
	public Food(String name, int weight, int nutrition, int quantity) {
		super(name, weight);	this.nutrition=nutrition;	this.quantity=quantity;
	}
	public void setQuantity(int newQuantity){
		this.quantity=newQuantity;
	}
	public int getQuantity(){
		return quantity;
	}
	public int getNutrition(){
		return nutrition;
	}
	public String examine(){
		return ("This is a(n) "+super.getName()+" with weight "+super.getWeight()+" and nutrition value "+ nutrition+". There are "+quantity+" in your inventory.");
	}

}
