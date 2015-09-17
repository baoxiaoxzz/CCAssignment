
/**
 * @author xiaobao
 *
 */
public class Solution05 {

	public static void main(String[] args) {
		System.out.println("pale, ple -> "+isOneEdit("pale","ple"));
		System.out.println("pales, pale -> "+isOneEdit("pales","pale"));
		System.out.println("pale, bale -> "+isOneEdit("pale","bale"));
		System.out.println("pale, bae -> "+isOneEdit("pale","bae"));
	}
    private static boolean isOneEdit(String x,String y){
	   if(x.length()==y.length()){
		   return isReplace(x, y);
	   }else if(x.length()-y.length()==1){//x is one longer than y
		   return isInsert(x,y);
	   }else if(y.length()-x.length()==1){//y is one longer than x
		   return isInsert(y,x);
	   }
	   return false;
   }
   private static boolean isInsert(String x, String y) {//x is longer than y
	   int xPointer=0;
	   int yPointer=0;
	   while(xPointer<x.length()&&yPointer<y.length()){
		   if(x.charAt(xPointer)!=y.charAt(yPointer)){
			   if(xPointer!=yPointer){//if already has a different character
				   return false;
			   }
			   xPointer++;
		   }
		   xPointer++;
		   yPointer++;
	   }
	return true;
}
   private static boolean isReplace(String x,String y){
	   boolean isDif=false;
	   for(int i=0;i<x.length();i++){
		   if(x.charAt(i)!=y.charAt(i)){
			   if(isDif){//already has difference
				   return false;
			   }
			   isDif=true;
		   }
	   }
	   return true;
   }
}
