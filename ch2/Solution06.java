
public class Solution06 {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();
		init(list1,list2,list3);//Initialize the list
		
		list1.print();
		System.out.println("is palindrome:" + isPalindrome(list1));
        list2.print();
        System.out.println("is palindrome:" + isPalindrome(list2));   
        list3.print();
        System.out.println("is palindrome:" + isPalindrome(list3));
	}

	private static boolean isPalindrome(LinkedList list) {
		if(list==null) return false;
		if(list.getSize()==1) return true;//list just has one element
		LinkedList oriLink=new LinkedList();//store the original list
		LinkedList reverseLink=new LinkedList();//the new linkedlist after reversing
		reverseLink(list,oriLink,reverseLink);//reverse the original link	
	//	reverseLink.print();
		Node node1=oriLink.getFirst();
		Node node2=reverseLink.getFirst();
		for(int i=0;i<list.getSize()/2;i++){//only need to compare the first half of the list
			if(node1.getData()==node2.getData()){
				node1=node1.getNext();
				node2=node2.getNext();
			}else{
				return false;
			}
		}
		return true;
	}
	
	private static void reverseLink(LinkedList list,LinkedList oriLink,LinkedList reverseLink) {
		Node linkNode=list.getFirst();//iterate the nodes of list
		Node first=list.getFirst();//use for reverse the list
		Node rear=list.getFirst();//store the first node of original list
		while(linkNode!=null){
			oriLink.add(new Node(linkNode.getData()));//copy the original link
			Node next=linkNode.getNext();
			linkNode.setNext(first);//insert the node at head in order to reverse the linkedlist
		    first=linkNode;//change the head of the list
			linkNode=next;// go to the next node in order to iterate next node of original linkedlist
		}
		rear.setNext(null);
		reverseLink.setFirst(first);//the head of linkedlist has changed
	}

	private static void init(LinkedList list1,LinkedList list2,LinkedList list3) {
		list1.add(new Node(0));
        list1.add(new Node(1));
        list1.add(new Node(2));
        list1.add(new Node(2));
        list1.add(new Node(1));
        list1.add(new Node(0));
        
        list2.add(new Node(5));
        list2.add(new Node(9));
        list2.add(new Node(2));
        list2.add(new Node(3));
        list2.add(new Node(2));
        list2.add(new Node(9));
        list2.add(new Node(5));
        
        list3.add(new Node(5));
        list3.add(new Node(9));
        list3.add(new Node(3));
        list3.add(new Node(3));
        list3.add(new Node(2));
        list3.add(new Node(9));
        list3.add(new Node(5));
        
        list3.add(new Node(1));
        list3.add(new Node(2));
        list3.add(new Node(3));
        list3.add(new Node(4));
        list3.add(new Node(5));
        list3.add(new Node(6));
        list3.add(new Node(7));		
	}

}

