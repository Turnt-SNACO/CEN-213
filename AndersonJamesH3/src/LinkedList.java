
public class LinkedList {
	private Node origin=null;
	private Node end=null;
	private int size=0;
	public LinkedList(){}
	
	//appends a node to the end of the list
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
	
	//sets the next node of the node behind the current node to be equal to the next node of the current
	//effectively deleting from the list
	public void deleteNode(Node node){
		if (node!=origin)
			node.getPrevious().setNext(node.getNext());
		else
			origin=node.getNext();
		if (node!=end)
			node.getNext().setPrevious(node.getPrevious());
		else
			end=node.getPrevious();
		size--;
	}
	
	//searches for nod ebased on content and returns the node
	public Node findNode(String content){
		Node current = origin;
		while(current.getNext()!=null){
    		if (current.getContent()==content)
    			return current;
    		else
    			current=current.getNext();
		}
		return null;
	}
	
	//effectively deletes the list because all add or insert functions have a base case
	//checking if origin is null or end is null
	public void deleteList(){
		origin=null;
		end=null;
	}
	
	//iterates forward through the list and returns a string that it comma delimited containing the content of each node.
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
	
	//iterates backwards through the list and returns a string that it comma delimited containing the content of each node.
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
	
	//returns the size of the list
	public int getSize(){
		return size;
	}
	
	//inserts node "insert" before node "node"
	public void insertBefore(Node insert, Node node){
		if (node==origin)
			origin=insert;
		else{
			insert.setPrevious(node.getPrevious());
			node.getPrevious().setNext(insert);
		}
		node.setPrevious(insert);
		insert.setNext(node);
		size++;
	}
	
	//inserts node "insert" after node "node"
	public void insertAfter(Node insert, Node node){
		if (end==node)
			end=insert;
		else
			insert.setNext(node.getNext());
		node.setNext(insert);
		insert.setPrevious(node);
		size++;
	}
	
	//inserts node into list in alphabetical order.
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
				if (node.getContent().compareTo(current.getContent())>0){
					if (current==end){
						addToEnd(node);
						break;
					}
					else
						current=current.getNext();
				}
				else {
					insertBefore(node, current);
					break;
				}
			}
		}
		//does not need a size increment of size because it invokes the insertBefore and insertAfter 
		//methods to perform the actual insertion which both contain a size increment.
	}

}
