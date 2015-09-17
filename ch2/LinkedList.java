
public class LinkedList {
	private Node head;//The first element
	private Node lastNode;//The last element
	private int size;//The length of linkedlist
	

    public LinkedList() {
        lastNode=head;
        size=0;
    }
    
    public LinkedList(Node node) {
    	head=node;
        lastNode=head;
        size=0;
    }

    public boolean add(Node node) {
    	if(null==node){
    		throw new IllegalArgumentException("Node can not be null");
    	}
    	if(null==head){
    		head =node;//If there is no element in the set,then give the node to head
    	}else{
    		Node lastNode=getLast();
    		lastNode.setNext(node);//put the lastnode point to node
    	}
    	lastNode=node;//give the new node to the lastnode
    	size++;
    	return true;
    }

	public Node getFirst() {
		return head;
	}
	
	public void setFirst(Node node){
		head=node;
	}
    
    public Node getLast() {
		return lastNode;
	}

    public int getSize() {
		return this.size;
	}
    
    public void print(Node node) {
        if(node == null) {
            return;
        }
        if(node.getNext()==null){
        	 System.out.print(node.getData());
             print(node.getNext());
        }else{
        	 System.out.print(node.getData() + " -> ");
             print(node.getNext());
        }
    }

    public void print() {
        print(this.head);
        System.out.println();
    }
    
}
