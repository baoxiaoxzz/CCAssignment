
public class Solution07 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		init(list1,list2);//Initialize the list
	    list1.print();
	    list2.print();
		System.out.println("list1 and list2 are intersection :" + isIntersection(list1,list2));
		
	}
	
	private static boolean isIntersection(LinkedList list1,LinkedList list2){
		if(list1.getFirst()==null || list2.getFirst()==null) return false;
		 Node rear1=list1.getLast();
		 Node rear2=list2.getLast();
		 int size1=list1.getSize();
		 int size2=list2.getSize();
		 if(rear1!=rear2) {
			 return false;//if the last nodes are different,then there is no intersection
		 }
		 //Node point to the head of the node
		  Node  shortNode =size1<size2?list1.getFirst():list2.getFirst();
		  Node longNode =size1<size2?list2.getFirst():list1.getFirst();
		  //move the pointer of longer list to make two lists have same node to compare
		  longNode=getKthNode(longNode,Math.abs(size2-size1));
		  
		  while(shortNode!=longNode){//judge if nodes are the same
			  shortNode=shortNode.getNext();
			  longNode=longNode.getNext();
		  }
		  
		  if(shortNode==null){//if shortNode = null when break while loop,then there is no intersection
			  return false;
		  }
		  return true;
	}

	private static Node getKthNode(Node first, int n) {
		Node cur=first;
		while(n>0 && cur!=null){
			cur=cur.getNext();
			n--;
		}
		return cur;
	}

	private static void init(LinkedList list1,LinkedList list2) {
		list1.add(new Node(0));
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
        list2.add(list1.getFirst().getNext().getNext().getNext());
        list2.add(list1.getFirst().getNext().getNext().getNext().getNext());
        list2.add(list1.getFirst().getNext().getNext().getNext().getNext().getNext());
        list2.add(list1.getFirst().getNext().getNext().getNext().getNext().getNext().getNext());
	}

}
