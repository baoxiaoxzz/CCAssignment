public class Node {
	    private Node next;
	    private int data;
	    private Solution01.State state;

	    public Node() {
	    	
	    }
	    
	    public Node(int d) {
	        data = d;
	    }

	    public Solution01.State getState(){
			return this.state;
		}
	    
	    public void setState(Solution01.State state){
	    	this.state=state;
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

		public Node[] getAdjacent() {
			return null;
		}
}
