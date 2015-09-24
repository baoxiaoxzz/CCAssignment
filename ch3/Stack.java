public class Stack {
	private int stackCapacity;
	private int[] data;
	private int size;
	
	public Stack(int size){
		stackCapacity=size;
		data=new int[size];
		this.size=0;
	}
	public Stack(){
		stackCapacity=100;
		data=new int[stackCapacity];
		this.size=0;
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
	    return value;	
	}
	
	/*push element into stack*/
	public void push(int value){
		if(isFull()) return ;//if stack is full
		size++;
		data[getTopIndex()]=value;
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
	/*get the size of stack*/
	public int getSize() {
		return size;
	}
	public int top() {
		return data[getTopIndex()];
	}
	
	public void print() {
		for(int i=0;i<size-1;i++){
		       System.out.print(data[i]+"-> ");
		}
		System.out.print(data[size-1]);
	}
}


