public class Solution06 {
    TreeNode findSucessor(TreeNode tn){
    	if(null==tn){
    		return null;
    	}
    	
    	/* First ,we need to find the right subTree and find its leftmost node */
    	if(tn.getRight()!=null){
    		return leftMostNode(tn.getRight());
    	}else{
    	    /*Until tn is the left subTree,not the right subTree*/
    		while(tn.getParent()!=null && tn.getParent().getLeft()!=tn){
    			tn=tn.getParent();	
    		}
    	return tn.getParent();
         }
    }
    
    TreeNode leftMostNode(TreeNode tn){
    	if(tn==null){
    		return null;
    	}
    	while(tn.getLeft()!=null){
    		tn=tn.getLeft();
    	}
    	return tn;
    }
}
