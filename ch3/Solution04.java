public class Solution04 {

	public static void main(String[] args) {
		MyQueue my=new Solution04().new MyQueue();
		        my.add(1);
		        my.add(2);
		        my.add(3);
		        my.remove();
		        System.out.println("The first element of Myqueue is : " + my.getFirstElementofQueue());
		        System.out.println("The size of Myqueue is : " + my.size());
	}
class MyQueue{
	Stack stackPush,stackPop;
	public MyQueue(){
		stackPush=new Stack();
		stackPop=new Stack();
	}
	
	public void add(int value){
		//stackPush has the newest elements on top
		stackPush.push(value);
	}
	
	public int remove(){
		moveToStackPop();
		return stackPop.pop();//pop the element push the earliest
	}
	
	public int getFirstElementofQueue(){
		moveToStackPop();
		return stackPop.top();//return the element push the earliest
	}
	
	private void moveToStackPop(){
		if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
	}
	
	public int size(){
		return stackPop.getSize()+stackPush.getSize();
	}
}
}
