public class Main {
	public static void main(String[]args){
		LinkedList l = new LinkedList();
		Node apple = new Node(0, "apple");
		Node ace = new Node(1, "ace");
		Node xylophone = new Node(2, "xylophone");
		Node bubblegum = new Node(3, "bubblegum");
		l.insertAlphabetically(apple);
		l.insertAlphabetically(xylophone);
		l.insertAlphabetically(bubblegum);
		l.insertAlphabetically(ace);
		System.out.println(l.printForward());
	}
}
