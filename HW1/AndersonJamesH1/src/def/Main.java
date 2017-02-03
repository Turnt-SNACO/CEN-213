package def;

public class Main {

	public static void main(String[] args) {
		//Object testing
		Weapon mace = new Weapon("mace", 5, 10);
		Item rope = new Item("rope", 2);
		System.out.println(mace.examine());
		System.out.println(rope.examine());

	}

}
