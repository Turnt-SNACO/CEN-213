public class Main {

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println("Perfect squares:");
		System.out.println("Sqrt(25) = "+s.root(25));
		System.out.println("Sqrt(4) = "+s.root(4));
		System.out.println("Sqrt(729) = "+s.root(729));
		System.out.println("Non-perfect Squares:");
		System.out.println("Sqrt(30) = "+s.root(30));
		System.out.println("Sqrt(50) = "+s.root(50));
		System.out.println("Sqrt(3412) = "+s.root(3412));
	}

}
