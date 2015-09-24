

public class Solution02 {
class TreeNode{
	private int value;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int value){
		this.value =value;
	}
}
TreeNode createMiniBST(int arr[]){
	return creatMiniBST(arr,0,arr.length-1);
}

public TreeNode creatMiniBST(int[] arr, int begin, int end) {
	if (end<begin){
		return null;
	}
	int mid=(begin+end)/2;
	TreeNode tn=new TreeNode(arr[mid]);
	tn.left=creatMiniBST(arr, begin, mid-1);
	tn.right=creatMiniBST(arr, mid+1, end);
	return tn;
}

}
