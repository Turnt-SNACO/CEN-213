package src;

public class Cauliflower extends Flower{
	//String for the color
	private String color;
	//Constructor
	Cauliflower(){
		super("Cauliflower");		color="White";
	}
	/*Returns color as a string
	 * method gets color of the Cauliflower
	 * @return the color of the Cauliflower
	 */
	public String getColor() {
		return color;
	}
	//Sets the color
	public void setColor(String color) {
		this.color = color;
	}
	/*Returns the edibility of Cauliflower
	 * @return A STRING DESCRIBING THE EDIBILITY OF CAULIFLOWER
	 */
	public String isEdible(){
		return("Cauliflower is edible.");
	}

}
