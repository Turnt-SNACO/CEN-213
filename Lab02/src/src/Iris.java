package src;

public class Iris extends Flower{
	//String for the color
	private String color;
	//Constructor
	Iris(){
		super("Iris");		color="Purple";
	}
	/*Returns color as a string
	 * method gets color of the Iris
	 * @return the color of the Iris
	 */
	public String getColor() {
		return color;
	}
	//Sets the color
	public void setColor(String color) {
		this.color = color;
	}
	/*Returns the edibility of Iris
	 * @return A STRING DESCRIBING THE EDIBILITY OF Iris
	 */
	public String isEdible(){
		return("Iris is not edible.");
	}

}
