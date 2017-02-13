package src;

public class Main {

	public static void main(String[] args) {
		Cauliflower C = new Cauliflower();
		
		System.out.println(C.isEdible());
		System.out.println(C.getColor());
		
		Iris I = new Iris();
		System.out.println(I.getColor());
		System.out.println(I.isEdible());
		
		
		
		
		char[] dash = new char[10];
		for (int x=0;x<10;x++)
			dash[x]='-';
		
	}

}
