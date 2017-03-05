public class Node {
	private Node previous,next;
	private int ID;
	private String content;
	public Node(int ID, String content){
		this.ID=ID;		this.content=content;
		this.next=null; this.previous=null;
	}
	public Node(){}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
