import java.util.Random;

public class Solution11 {
	class TreeNode{
		private int data;
		private  TreeNode left;
		private TreeNode right;
		private int size =0;
		public TreeNode(int data){
			this.data=data;
			size=1;
		}
		
		public TreeNode getLeft(){
			return left;
		}
		
		public TreeNode getRight(){
			return right;
		}
		
		public int getSize(){
			return size;
		}
		
		public int getData(){
			return data;
		}
	}
	
	public TreeNode getRandomNode(TreeNode tn){
		int lSize=tn.getLeft()==null?0:tn.getLeft().getSize();
		Random rd=new Random();
		int random=rd.nextInt(tn.getSize());
		if(random<lSize){
			return getRandomNode(tn.getLeft());
		}else if(random==lSize){
			return tn;
		}else{
			return getRandomNode(tn.getRight());
		}
	}
	
	public void insert(TreeNode tn,int value){
		if(value<=tn.data){
			if(tn.getLeft()==null){
				tn.left=new TreeNode(value);
			}else{
				insert(tn.left,value);
			}
		}else{
			if(tn.right==null){
				tn.right=new TreeNode(value);
			}else{
				insert(tn.right,value);
			}
		}
		tn.size++;
	}
}
