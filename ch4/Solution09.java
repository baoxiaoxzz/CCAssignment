import java.util.ArrayList;
import java.util.LinkedList;

public class Solution09 {
	/*find all possible ways to arrange lists.*/
	void arrangeLists(LinkedList<Integer> head,LinkedList<Integer> second,ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
		//if one list is empty,then add prefix and remainder to the result
		if(head.size()==0||second.size()==0){
			LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
			result.addAll(head);
			result.addAll(second);
			results.add(result);
			return;
		}
		/*Recurse with the first element of head added to the prefix,removing will change the head ,so need to put it back*/
		int first=head.removeFirst();
		arrangeLists(head, second, results, prefix);
		prefix.removeLast();
		head.addFirst(first);
		
		//The same as second
		int secondofHead =second.removeFirst();
		prefix.addLast(secondofHead);
		arrangeLists(head, second, results, prefix);
	    prefix.removeLast();
	    second.addFirst(secondofHead);
	}
	
	ArrayList<LinkedList<Integer>> allSeq(TreeNode node){
		ArrayList<LinkedList<Integer>> result =new ArrayList<LinkedList<Integer>>();
		
		if(node==null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix=new LinkedList<Integer>();
		prefix.add(node.getData());
		
		//Recurse on left and right subtress
		ArrayList<LinkedList<Integer>> leftSeq=allSeq(node.getLeft());
		ArrayList<LinkedList<Integer>> rightSeq=allSeq(node.getRight());
		
		//arrange all possible ways
		for(LinkedList<Integer> left:leftSeq){
			for(LinkedList<Integer> right:rightSeq){
				ArrayList<LinkedList<Integer>> arrange=new ArrayList<LinkedList<Integer>>();
				arrangeLists(left, right, result, prefix);
				result.addAll(arrange);
			}		
		}
		return result;
	}
}
