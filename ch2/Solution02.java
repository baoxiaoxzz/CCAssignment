import java.util.Scanner;

public class Solution02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input k :");
		int k=Integer.parseInt(sc.nextLine());
		LinkedList list = new LinkedList();
		init(list);//Initialize the list
		
		System.out.println("Initial list is:");
        list.print();
        getKthToLast(list.getFirst(),k);
	}

	private static int getKthToLast(Node head, int k) {
		 if(head==null){		
				return 0;	 
		 }
		 int itera=getKthToLast(head.getNext(), k) + 1;
			if(itera==k) {
					 System.out.println("The "+ k+ "th to last node is:"+head.getData());
			}
			return itera;
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
