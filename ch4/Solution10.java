  
public class Solution10 {
	
	
	boolean checkSubtree(TreeNode bTree,TreeNode sTree){
		if(sTree==null){//The empty tree is a subtree
			return true;
		}
		if(bTree==null){//big tree is empty and not found 
			return false;
		}else if(bTree.getData()==sTree.getData() && matchTree(bTree,sTree)){
			return true;
		}
		return (checkSubtree(bTree.getLeft(),sTree) || checkSubtree(bTree.getRight(), sTree));
	}

	private boolean matchTree(TreeNode bTree, TreeNode sTree) {
		if(sTree==null && bTree==null){
			return true;//all match
		}else if(bTree==null ||sTree==null){
			return false;//big tree empty& subtree still not found
		}else if(bTree.getData()!=sTree.getData()){
			return false;//data does not match
		}else{
			return (matchTree(bTree.getLeft(),sTree.getLeft()) && matchTree(bTree.getRight(), sTree.getRight()));
		}
	}

}
