public class Main {
	public static void main(String[]args){
		LinkedList l = new LinkedList();
		Node ace = new Node("ace");
		Node apple = new Node("apple");
		Node bubblegum = new Node("bubblegum");
		Node xylophone = new Node("xylophone");
		Node zebra = new Node("zebra");
		l.insertAlphabetically(apple);
		l.insertAlphabetically(xylophone);
		l.insertAlphabetically(bubblegum);
		l.insertAlphabetically(ace);
		System.out.println(l.printForward());
		System.out.println(l.printReverse());
		l.deleteNode(bubblegum);
		System.out.println(l.printForward());
		System.out.println(l.printReverse());
		l.insertAlphabetically(zebra);
		System.out.println(l.printForward());
		System.out.println(l.printReverse());
		l.addToEnd(new Node(0));
		System.out.println(l.printForward());
		System.out.println(l.printReverse());
	}
}
