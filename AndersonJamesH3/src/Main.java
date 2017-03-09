public class Main {
	public static void main(String[]args){
		LinkedList l = new LinkedList();
		Node apple = new Node("apple");
		Node ace = new Node("ace");
		Node xylophone = new Node("xylophone");
		Node bubblegum = new Node("bubblegum");
		l.insertAlphabetically(apple);
		l.insertAlphabetically(xylophone);
		l.insertAlphabetically(bubblegum);
		l.insertAlphabetically(ace);
		System.out.println(l.printForward());
		System.out.println(l.printReverse());
	}
}
