
public class Node {
	    private Node next;
	    private int data;

	    public Node() {
	    	
	    }
	    
	    public Node(int d) {
	        data = d;
	    }

	    public int getData() {
	        return data;
	    }

	    public void setData(int d) {
	    	data = d;
	    }
	    
	    public Node getNext() {
	        return next;
	    }

	    public void setNext(Node next) {
	        this.next = next;
	    }

	    @Override
	    public String toString() {
	        return data + "";
	    }
}
