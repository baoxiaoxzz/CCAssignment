import java.util.ArrayList;
import java.util.LinkedList;

public class Solution03 {
	class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int value){
			this.value =value;
		}
	}
//use depth-first search
	void createDepthLinkedList(TreeNode root,ArrayList<LinkedList<TreeNode>> lists,int depth){
		if(root==null) return;
		LinkedList<TreeNode> depthList=null;
		if(lists.size()==depth){
			depthList=new LinkedList<TreeNode>();
			lists.add(depthList);//traverse depth in order,so we would visit 0,1...i-1,i in order
		}else{
			depthList=lists.get(depth);
		}
		depthList.add(root);
		createDepthLinkedList(root.left,lists,depth+1);
		createDepthLinkedList(root.right,lists,depth+1);
	}
	ArrayList<LinkedList<TreeNode>> createDepthLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists=new ArrayList<LinkedList<TreeNode>>();
		createDepthLinkedList(root,lists,0);
		return lists;
	}
	public static void main(String[] args) {
	}

}
