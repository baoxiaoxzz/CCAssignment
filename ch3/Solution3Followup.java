import java.util.ArrayList;

public class Solution3Followup {
 public class SetofStacks{
	 ArrayList<Stack> stacks=new ArrayList<Stack>();
	 public int capacity;
	 public SetofStacks(int capacity){
		 this.capacity=capacity;
	 }
	 
	 public Stack getLastStack(){
		 if(stacks.size()==0) return null;
		 return stacks.get(stacks.size()-1);
	 }
	 
	 public void push(int value){
		 Stack last=getLastStack();
		 if(last!=null && !last.isFull()){
			 last.push(value);
		 }else{
			 //new Stack
			 Stack stack=new Stack(capacity);
			 stack.push(value);
			 stacks.add(stack);
		 }
	 }
	 
	 public int pop(){
		 Stack last=getLastStack();
		 if(last==null) return -1;
		 int value =last.pop();
		 if(last.size==0){
			 stacks.remove(stacks.size()-1);
		 }
		 return value;
	 }
	 
	 public boolean isEmpty(){
		 Stack last=getLastStack();
		 return last==null || last.isEmpty();
	 }
	 
	 public int popAt(int index){
		 return moveLeft(index,true);
	 }
	 
	 public int moveLeft(int index,boolean isTop){//put the bottom element of next stack into the top of current stack
		 Stack stack=stacks.get(index);
		 int remove;
		 if(isTop) remove=stack.pop();
		 else{
			 remove=stack.removeBottom();//delete the bottom element
		 }
		 if(stack.isEmpty()){
			 stacks.remove(index);
		 }else if(stacks.size()>index+1){
			 int value=moveLeft(index+1,false);
			 stack.push(value);
		 }
		 return remove;
	 }
 }
 class Stack{
	 private int capacity;
	 public Node top,bottom;
	 public int size=0;
	 
	 public Stack(int capacity){
		 this.capacity=capacity;
	 }
	 
	 public boolean isFull(){
		 return capacity==size;
	 }
	 
	 public void join(Node above,Node below){
		 if(below!=null) below.above=above;
		 if(above!=null) above.below=below;
	 }
	 
	 public boolean push(int value){
		 if(size>=capacity) return false;
		 size++;
		 Node node=new Node(value);
		 if(size==1) bottom=node;
		 join(node,top);
		 top=node;
		 return true;
	 }
	 
	 public int pop(){
		 Node t=top;
		 top=top.below;
		 size--;
		 return t.value;
	 }
	 
	 public boolean isEmpty(){
		 return size==0;
	 }
	 
	 public int removeBottom(){
		 Node b=bottom;
		 bottom=bottom.above;
		 if(bottom!=null) bottom.below=null;
		 size--;
		 return b.value;
	 }
 }
class Node {
	    public Node below,above;
	    public int value;

	    public Node() {
	    	
	    }
	    
	    public Node(int d) {
	        value = d;
	    }

	    public int getData() {
	        return value;
	    }

	    public void setData(int d) {
	    	value = d;
	    }
}

}
