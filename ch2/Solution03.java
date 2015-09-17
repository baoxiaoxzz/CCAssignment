import java.util.Scanner;

public class Solution03 {

	public static void main(String[] args) {
		System.out.println("Please input to delete which node :");
		LinkedList list = new LinkedList();
		init(list);//Initialize the list
		
		System.out.println("Initial list is:");
        list.print();
        delNode(list.getFirst().getNext().getNext().getNext().getNext());
        System.out.println("New list is:");
        list.print();
	}

	private static boolean delNode(Node node) {
		if(node==null ){
			return false;
		}
		if(node.getNext()==null){//if node is the last node
			node=null;
			return true;
		}
		Node next=node.getNext();
		node.setData(next.getData());
		node.setNext(next.getNext());
		return true;
	}

	private static void init(LinkedList list) {
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

}
