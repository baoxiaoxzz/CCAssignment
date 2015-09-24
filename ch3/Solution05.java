public class Solution05 {

	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(6);
		stack.push(5);
		System.out.println("The origianl stack is : ");
		stack.print();
		System.out.println();
		System.out.println("The sorted stack is : ");
		new Solution05().sort(stack).print();

	}
   public Stack sort(Stack ori){
	   Stack newStack=new Stack();
	   while(!ori.isEmpty()){
		   int temp=ori.pop();
		   while(!newStack.isEmpty() && newStack.top()>temp){
			   ori.push(newStack.pop());
		   }
		   newStack.push(temp);
	   }
	   return newStack;
   }
}
