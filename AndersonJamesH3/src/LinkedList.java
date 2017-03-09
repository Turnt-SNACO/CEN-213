
public class LinkedList {
	private Node origin=null;
	private Node end=null;
	private int size=0;
	public LinkedList(){}
	
	public void addToEnd(Node node) {
    	if (origin==null){  
    		origin=node;
    		end=node;
    	}else{
    		Node current = origin;
    		while(current.getNext()!=null){
    			current=current.getNext();
    		}
    		current.setNext(node);
    		node.setPrevious(current);
    		end=node;
    	}
    	size++;
    }
	public void deleteNode(Node node){
		if (findNode(node)!=null){
			//sets the next node of the node behind the current node to be equal to the next node of the current
			//effectively deleting from the list
			node.getPrevious().setNext(node.getNext());
			Node current=node;
			//Goes through the list and shifts ID values back one to accommodate for removed node
			while(current.getNext()!=null){

    			current=current.getNext();
    		}
			//makes sure the last link is shifted back as well
		}
	}
	public Node findNode(Node node){
        Node current = origin;
    	while(current.getNext()!=null){
    		if (current==node)
    			return current;
    		else
    			current=current.getNext();
    	}
    	if (current==node)
    		return current;
    	return null;	
    }
	public void deleteList(){
		origin=null;
		end=null;
	}
	public String printForward(){
		String list="";
		Node current=origin;
		while(current.getNext()!=null){
			list+=current.getContent()+", ";
    		current=current.getNext();
    	}
		list+=current.getContent();
		return list;
	}
	public String printReverse(){
		String list="";
		Node current=end;
		while(current.getPrevious()!=null){
			list+=current.getContent()+", ";
    		current=current.getPrevious();
    	}
		list+=current.getContent();
		return list;
	}
	public int getSize(){
		return size;
	}
	
	public void insertBefore(Node insert, Node node){
		if (node==origin)
			origin=insert;
		else{
			insert.setPrevious(node.getPrevious());
			node.getPrevious().setNext(insert);
		}
		node.setPrevious(insert);
		insert.setNext(node);
	}
	public void insertAfter(Node insert, Node node){
		if (end==node)
			end=insert;
		else
			insert.setNext(node.getNext());
		node.setNext(insert);
		insert.setPrevious(node);
	}
	
	public void insertAlphabetically(Node node){
		if (origin==null){
			origin=node;
			end=node;
		} else if (origin==end){
			if (node.getContent().compareTo(origin.getContent())>=0)
				insertAfter(node,origin);
			else
				insertBefore(node,origin);
		}
		else{
			Node current=origin;
			while (current!=null){
				if (node.getContent().compareTo(current.getContent())>0)
					current=current.getNext();
				else {
					insertBefore(node, current);
					break;
				}
			}
		}
	}
}
