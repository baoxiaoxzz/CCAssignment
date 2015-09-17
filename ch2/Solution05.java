
public class Solution05 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		init(list1,list2);//Initialize the list
		
		System.out.println("Two lists are:");
        list1.print();
        list2.print();
        System.out.println("Sum list is:");
        Node result=sumList(list1.getFirst(),list2.getFirst(),0);
        list1.print(result);//print the result
	}

	private static Node sumList(Node node1,Node node2,int accumulate) {
		if(node1==null&&node1==null&&accumulate==0){
			return null;
		}
		Node sum=new Node();//The first node of the reult
		int temp=accumulate;//The result of each step
		if(node1!=null){
			temp+=node1.getData();//carry of the previous step plus data of node1
		}
		if(node2!=null){
			temp+=node2.getData();//carry of the previous step plus data of node1 plus data of node2
		}
		sum.setData(temp%10); //The unit of the result
		if(node1!=null || node2!=null){
			Node next=sumList(node1==null?null:node1.getNext(),node2==null?null:node2.getNext(),temp>=10?temp/10:0);//temp/10 is the carry of this step
			sum.setNext(next);//The next node of the result
		}
		return sum;
	}

	private static void init(LinkedList list1,LinkedList list2) {
		list1.add(new Node(7));
        list1.add(new Node(1));
        list1.add(new Node(6));
        list2.add(new Node(5));
        list2.add(new Node(9));
        list2.add(new Node(2));
		
	}
}
