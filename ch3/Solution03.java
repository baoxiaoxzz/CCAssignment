import java.util.ArrayList;

public class Solution03 {

	public static void main(String[] args) {
		SetofStacks ss=new Solution03().new SetofStacks();
		for(int i=1;i<=11;i++){
			ss.push(i);
		}
		System.out.println("SetofStacks pop : " + ss.pop());
	}

	class SetofStacks extends Stack{
		private ArrayList<Stack> stackSet=new ArrayList<Stack>();	
		/*push*/
		public void push(int value){
			Stack lastStack=stackSet.size()==0?null:stackSet.get(stackSet.size()-1);
			if(lastStack!=null && !lastStack.isFull()){//push into the last stack
				lastStack.push(value);
			}else{//creat a new stack
				Stack newStack=new Stack(10);
				newStack.push(value);
				stackSet.add(newStack);
			}
		}
		/*pop*/
		public int pop(){
			Stack lastStack=stackSet.size()==0?null:stackSet.get(stackSet.size()-1);
			if(lastStack==null) return -1;
			int value=lastStack.pop();
			if(lastStack.getSize()==0) stackSet.remove(stackSet.size()-1);//if last of the stack is empty,then delete
			return value;	
		}
	}
	
}
