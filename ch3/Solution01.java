public class Solution01 {

	public static void main(String[] args) {
		FixedStack stack=new Solution01().new FixedStack(5);
		stack.push(0, 1);
		stack.push(1, 2);
		stack.push(2, 3);
		stack.pop(1);
		System.out.println("The size of stack 0: " + stack.size[0]);
		System.out.println("The size of stack 1: " + stack.size[1]);
		System.out.println("The size of stack 2: " + stack.size[2]);
	}
class FixedStack{
	private int stackCapacity;
	private int number=3;
	private int[] data;
	private int[] size;
	
	public FixedStack(int size){
		stackCapacity=size;
		data=new int[size*number];
		this.size=new int[number];
	}
	/*pop element from stack*/
	public int pop(int num){
		if(isEmpty(num)){
			return -1;
		}
	    int index=getTopIndex(num);
	    int value=data[index];//get the top element
	    data[index]=0;//clear original top element
	    size[num]--;
	    return value;	
	}
	
	/*push element into stack*/
	public void push(int num,int value){
		if(isFull(num)) return ;//if stack is full
		size[num]++;
		data[getTopIndex(num)]=value;
	}
	/*judge if the stack is full*/
	private boolean isFull(int num) {
		return size[num]==stackCapacity;
	}
	/*get the index of the top of the stack*/
	private int getTopIndex(int num) {
		int offset=num*stackCapacity;//get the previous stacks capacity
		int len=size[num];//get this stack size
		return len+offset-1;
	}
	/*judge if the stack is empty*/
	private boolean isEmpty(int num) {
		return size[num]==0;
	}
}
}
