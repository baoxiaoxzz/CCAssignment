public class Solution04 {
	
int getHeight(TreeNode tn){
	if(tn==null){
		return 0;//height is 0
	}
	int lHeight=getHeight(tn.getLeft());//height of left subTree
	if(lHeight==-1){
		return -1;//not balanced
	}
	int rHeight=getHeight(tn.getRight());//height of right subTree
	if(rHeight==-1){
		return -1;//not balanced
	}
	/* current node balanced or not*/
	int hDiff=rHeight-lHeight;
	if(Math.abs(hDiff)>1){
		return -1;//not balanced
	}else{
		return Math.max(lHeight, rHeight)+1;
	}
}

boolean checkBalanced(TreeNode tn){
	if(getHeight(tn)==-1){
		return false;
	}else{
		return true;
	}
}
}
