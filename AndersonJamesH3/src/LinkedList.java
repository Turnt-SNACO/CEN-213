
public class LinkedList {
	private Node origin=null;
	private int size=0;
	public LinkedList(){}
	
	public void insertAlphabetically(Node node){
		if (origin==null){
			origin=node;
		}else if (size>1){
			Node current = origin;
    		while(current.getNext()!=null){
    			char[] thisWord = current.getContent().toCharArray();
    			char[] nextWord = current.getNext().getContent().toCharArray();
    			int x=0;
    			while(true){
	    			if (thisWord[x]==nextWord[x]){
	    				x++;
	    			}else if(thisWord[x]>nextWord[x]){
	    				current=current.getNext();
	    				break;
	    			}else {
	    				current=current.getPrevious();
	    				break;
	    			}
    			}
    		}
    		node.setPrevious(current);
			node.setNext(current.getNext());
			node.setPrevious(origin);
			node.setNext(null);
			
			current.setNext(node);
			
			
		}else{
			char[] thisWord = node.getContent().toCharArray();
			char[] inList = origin.getContent().toCharArray();
			int x=0;
			while(true){
    			if (thisWord[x]==inList[x]){
    				x++;
    			}else if(thisWord[x]>inList[x]){
    				node.setPrevious(origin);
    				node.setNext(null);
    				origin.setNext(node);
    				break;
    			}else {
    				Node temp=origin;
    				origin=node;
    				origin.setNext(temp);
    				break;
    			}
			}
			
		}
	}
	public void deleteNode(Node node){
		if (findNode(node)!=null){
			//sets the next node of the node behind the current node to be equal to the next node of the current
			//effectively deleting from the list
			node.getPrevious().setNext(node.getNext());
			Node current=node;
			//Goes through the list and shifts ID values back one to accommodate for removed node
			while(current.getNext()!=null){
				current.setID(current.getID()-1);
    			current=current.getNext();
    		}
			//makes sure the last link is shifted back as well
			current.setID(current.getID()-1);
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
		String[] listArray=new String[size-1];
		Node current=origin;
		int x=0;
		while(current.getNext()!=null){
			listArray[x]=current.getContent();
    		current=current.getNext();
    		x++;
    	}
		listArray[x]=current.getContent();
		for (int y=size-1;y>0;y--){
			list+=listArray[y]+", ";
		}
		list+=listArray[0];
		return list;
	}
	public int getSize(){
		return size;
	}
}
