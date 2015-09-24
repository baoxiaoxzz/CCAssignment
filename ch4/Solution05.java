public class Solution05 {
  boolean isBST(TreeNode tn){
	  return isBST(tn,null,null);
  }
  
  boolean isBST(TreeNode tn,Integer min,Integer max){
	  if(tn==null){
		  return true;
	  }
	  
	  if((max!=null && tn.getData()>max)|| (min!=null && tn.getData()<=min)){
		  return false;
	  }
	  
	  if(!isBST(tn.getLeft(),min,tn.getData())||!isBST(tn.getRight(),tn.getData(),max)){
		  return false;
	  }
	  return true;
  }
}
