public class Solution08 {

	//define a class to store the result
		class Result{
			public boolean isLoop;//whether is loop
			public Node startLoop;//the collisionspot of loop
			public Result(){
			}
			public Result(Node startLoop,boolean isLoop){
				this.isLoop=isLoop;
				this.startLoop=startLoop;
			}
		}

		public static void main(String[] args) {
			LinkedList list1 = new LinkedList();
			LinkedList list2 = new LinkedList();
			init(list1,list2);//Initialize the list
			
		//	System.out.print("list1 : ");
		//	list1.print();
			System.out.println("list1 is loop :" + isLoop(list1).isLoop);
			if(isLoop(list1).isLoop){
				System.out.println("The collisionspot is" + isLoop(list1).startLoop.getData());
			}
		//	System.out.print("list2 : ");
		//	list2.print();
			System.out.println("list2 is loop :" + isLoop(list2).isLoop);
			if(isLoop(list2).isLoop){
				System.out.println("The start point of loop is :" + isLoop(list2).startLoop.getData());
			}
		}

		private static Result isLoop(LinkedList list1) {
			Node slow=list1.getFirst();//slow takes k steps each time
			Node fast=list1.getFirst();//first takes 2k steps each time
			//the collision point is the size of loop - k steps before the start point of the loop
			while(fast!=null && fast.getNext()!=null){
				slow=slow.getNext();
				fast=fast.getNext().getNext();
				if(slow==fast){//find the meeting point
					break;
				}
			}
			
			if(fast==null ||fast.getNext()==null){//there is no loop
				return new Solution08().new Result(slow,false);
			}
			/*move fast to head of the link,slow still point to the meeting point.slow and fast are both k steps away
			 *from the start of the loop.Move them together at the same pace,then they will meet at the start of the loop*/
			fast=list1.getFirst();
			while(fast!=slow){
				slow=slow.getNext();
				fast=fast.getNext();
			}	
			return new Solution08().new Result(slow, true);
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
	        list2.add(new Node(3));//the meeting point
	        list2.add(new Node(2));
	        list2.add(new Node(9));
	        list2.add(new Node(5));
	        list2.getFirst().getNext().getNext().getNext().getNext().getNext().getNext().setNext( list2.getFirst().getNext().getNext().getNext());
		}

}
