package def;

public class Food extends Item{
	private int nutrition, quantity;
	//Constructor
	public Food(String name, int weight, int nutrition, int quantity) {
		super(name, weight);	this.nutrition=nutrition;	this.quantity=quantity;
	}
	//Set a new quantity for the food item
	public void setQuantity(int newQuantity){
		this.quantity=newQuantity;
	}
	//Returns an integer value for quantity of the food item
	public int getQuantity(){
		return quantity;
	}
	//Returns an integer value for the nutrition value of the food item
	public int getNutrition(){
		return nutrition;
	}
	//Returns a thorough description of all item attributes
	public String examine(){
		return ("This is a(n) "+super.getName()+" with weight "+super.getWeight()+" and nutrition value "+ nutrition+". There are "+quantity+" in your inventory.");
	}

}
