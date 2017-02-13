package src;

public class Flower {
	//Creates empty string for name 
	private String name;
	//Default constructor
	public Flower(){}
	//Constructor with name arg
	public Flower(String name){
		this.name=name;
	}
	/*Sets name as
	 * method sets name of the flower
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*Returns name as a string
	 * method gets name of the flower
	 * @return the name of the flower
	 */
	public String getName() {
		return name;
	}
}
