public class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;
		public TreeNode(int value){
			this.value =value;
		}
		public int getData(){
			return this.value;
		}
		
		public TreeNode getLeft(){
			return this.left;
		}
		
		public TreeNode getRight(){
			return this.right;
		}
	
		public TreeNode getParent(){
			return this.parent;
		}
}
