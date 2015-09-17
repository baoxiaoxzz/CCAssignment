import java.util.Scanner;

public class Solution04 {

	public static void main(String[] args) {
		System.out.println("Please input k:");
		Scanner sc = new Scanner(System.in);
		int k=Integer.parseInt(sc.nextLine());
		LinkedList list = new LinkedList();
		init(list);//Initialize the list
		
		System.out.println("Initial list is:");
        list.print();
        partList(list,k);
        System.out.println("New list is:");
        list.print();
	}

	private static void partList(LinkedList list, int k) {
		Node linkNode=list.getFirst();
		Node front=list.getFirst();
		Node rear=list.getFirst();
		while(linkNode!=null){
			Node next=linkNode.getNext();
			if(linkNode.getData()<k){
				linkNode.setNext(front);//insert the node at head
				front=linkNode;
			}else{
				rear.setNext(linkNode);//insert the node at rear
				rear=linkNode;
			}
			linkNode=next;//go to the next node
		}
		rear.setNext(null);
		list.setFirst(front);//the head of linkedlist has changed
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
