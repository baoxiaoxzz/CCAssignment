

public class Solution01 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		init(list);//Initialize the list
		
		System.out.println("Initial list is:");
        list.print();
        removeDuplicates(list);
        System.out.println("New list is:");
        list.print();
	}
	private static void init(LinkedList list) {//Initialize the list
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(2));
        list.add(new Node(1));
        list.add(new Node(5));
        list.add(new Node(6));	
	}
	private static void removeDuplicates(LinkedList list) {
		Node curr=list.getFirst();
        if(curr == null  ) {
            return; // 0 node in the list has no duplicates
        }
        while(curr != null) {//remove the same value nodes
        	Node mover=curr;
            while(mover.getNext() != null) {
                // if curr and mover.next values are the same,  then delete mover.next
                if(mover.getNext().getData()==curr.getData()) {
                	mover.setNext(mover.getNext().getNext());
                }else{
                	mover=mover.getNext();
                }
            }
            curr = curr.getNext();
        }
    }
}
