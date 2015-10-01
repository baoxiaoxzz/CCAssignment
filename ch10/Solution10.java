import java.util.Random;

public class Solution10 {
	static int N=10;
public class RankNode{
	public int leftSize=0;
	public RankNode left,right;
	public int data=0;
	public RankNode(int v){
		data=v;
	}
	public void insert(int value) {
		if(value<=data){
			if(left==null){
				left=new RankNode(value);
			}else{
				left.insert(value);
			}
			leftSize++;
		}else{
			if(right==null){
				right=new RankNode(value);
			}else{
				right.insert(value);
			}
		}
	}
	public int getRank(int value) {
		if(value==data){
			return leftSize;
		}else if(value<data){
			if(left==null) return -1;//value is not found in the tree
			else return left.getRank(value);
		}else{
			int rightRank=right==null?-1:right.getRank(value);
			if(rightRank==-1) return -1;//value is not found in the tree
			return leftSize+1+rightRank;//1 is current RankNode
		}
	}
}
	public static void main(String[] args) {
		  System.out.println("Integers stream is :");
		  RankNode r=new Solution10(). new RankNode(20);
		  Random rand = new Random();	
		  int value=0;
		  for (int i = 0; i < N; i++){
				 int d = rand.nextInt(100);
				 r.insert(d);
				 if(i==N/2){
					 value=d;
				 }
				 System.out.print(d+"  ");
		  }
		  System.out.println();
		  System.out.println(value+"'s Rank is :"+r.getRank(value));
	}

}
