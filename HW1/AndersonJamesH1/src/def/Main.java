package def;

public class Main {

	public static void main(String[] args) {
		//Object testing
		//create a weapon with weight 5 and damage 10
		Weapon mace = new Weapon("mace", 5, 10);
		//create an item with weight 2
		Item rope = new Item("rope", 2);
		//create armor with weight 10 and defense 5
		Armor chain = new Armor("Chainmail", 10, 5);
		//create a food with weight 1, nutrition 2, quantity 4
		Food apple = new Food("apple", 1, 2, 4);
		
		//Test ALL methods for an Item, in this case the rope
		System.out.println("NAME: ROPE  WEIGHT: 2");
		System.out.println("NAME RETURN:    "+rope.getName());
		System.out.println("WEIGHT RETURN:    "+rope.getWeight());
		System.out.println("EXAMINE RETURN:    "+rope.examine());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		//Test ALL methods for a weapon, in this case the mace
		System.out.println("NAME: MACE WEIGHT: 5 DAMAGE: 10");
		System.out.println("NAME RETURN:    "+mace.getName());
		System.out.println("WEIGHT RETURN:    "+mace.getWeight());
		System.out.println("EXAMINE RETURN:    "+mace.examine());
		System.out.println("DAMAGE RETURN:    "+mace.getDamage());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		//Test ALL methods for armor, in this case chain
		System.out.println("NAME: CHAINMAIL WEIGHT: 10 DEFENSE: 5");
		System.out.println("NAME RETURN:    "+chain.getName());
		System.out.println("WEIGHT RETURN:    "+chain.getWeight());
		System.out.println("EXAMINE RETURN:    "+chain.examine());
		System.out.println("DEFENSE RETURN:    "+chain.getDefense());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		//Test ALL methods for food, in this case apple
		System.out.println("NAME: APPLE WEIGHT 1 NUTRITION 2 QUANTITY: 4");
		System.out.println("NAME RETURN:    "+apple.getName());
		System.out.println("WEIGHT RETURN:    "+apple.getWeight());
		System.out.println("EXAMINE RETURN:    "+apple.examine());
		System.out.println("NUTRITION RETURN:    "+apple.getNutrition());
		System.out.println("QUANTITY RETURN:    "+apple.getQuantity());
		System.out.println("SET NEW QUANTITY: 6");	apple.setQuantity(6);
		System.out.println("NEW QUANTITY RETURN:    "+apple.getQuantity());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}

}
