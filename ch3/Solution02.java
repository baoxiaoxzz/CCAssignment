
public class Solution02 {

	public static void main(String[] args) {
		StackwithMin sm=new Solution02().new StackwithMin(5);
		sm.push(3);
		sm.push(4);
		sm.push(2);
		sm.push(6);
		sm.push(5);
		System.out.println("The min element is : " + sm.min());

	}
class StackwithMin extends Stack{
	private int stackCapacity;
	private int[] data;
	private int size;
	private Stack minStack=new Stack(10);//store the min element
	
	public StackwithMin(int size){
		stackCapacity=size;
		data=new int[size];
		this.size=0;
		minStack.push(Integer.MAX_VALUE);
	}
	/* return min element*/
	public int min(){
		if(minStack.isEmpty()){
			System.out.println(minStack.getSize() );
			return -1;
		}else{
			return minStack.top();
		}
	}
	/*pop element from stack*/
	public int pop(){
		if(isEmpty()){
			return -1;
		}
	    int index=getTopIndex();
	    int value=data[index];//get the top element
	    data[index]=0;//clear original top element
	    size--;
	    if(value==min()){
	    	minStack.pop();
	    }
	    return value;	
	}
	
	/*push element into stack*/
	public void push(int value){
		if(isFull()) return ;//if stack is full
		size++;
		data[getTopIndex()]=value;
		if(value<min()){
			minStack.push(value);
		}
	}
	/*judge if the stack is full*/
	public boolean isFull() {
		return size==stackCapacity;
	}
	/*get the index of the top of the stack*/
	public int getTopIndex() {
		return size-1;
	}
	/*judge if the stack is empty*/
	public boolean isEmpty() {
		return size==0;
	}
}
}
