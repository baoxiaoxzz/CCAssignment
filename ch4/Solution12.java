import java.util.HashMap;

public class Solution12 {
  int getNumOfPathsWithSum(TreeNode tn,int targetSum){
	  if(tn==null) return 0;
	  HashMap<Integer,Integer> count=new HashMap <Integer,Integer>();
	  increHT(count,0,1);//if target path starts at root
	  return getNumOfPathsWithSum(tn,targetSum,0,count);
  }
  
  int getNumOfPathsWithSum(TreeNode tn,int targetSum,int curSum,HashMap <Integer,Integer> count){
	  if(tn==null) return 0;
	  
	  curSum+=tn.getData();
	  increHT(count,curSum,1);//Add curSum
	  //Count paths at the current node and sum
	  int sum=curSum-targetSum;
	  int numOfPaths=count.containsKey(sum)?count.get(sum):0;
	  
	  //count left subTree and right subTree
	  numOfPaths+=getNumOfPathsWithSum(tn.getLeft(),targetSum,curSum,count);
	  numOfPaths+=getNumOfPathsWithSum(tn.getRight(),targetSum,curSum,count);
	  
	  increHT(count,curSum,-1);//decrease one path that sum=curSum
	  return numOfPaths;
  }
  
  void increHT(HashMap <Integer,Integer> ht,int key,int num ){
	  if(!ht.containsKey(key)){
		  ht.put(key,0);
	  }
	  ht.put(key, ht.get(key+num));
  }
}
