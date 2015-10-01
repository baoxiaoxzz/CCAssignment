import java.util.List;
import java.util.Scanner;

public class Solution05 {

	public static void main(String[] args) {
		String[] str={"at","","","","ball","","","car","","","dad","",""};
		System.out.println("string array : ");
		print(str);
		System.out.println();
		System.out.println("input string: ");
	    Scanner sc =new Scanner(System.in);
	    String x=sc.nextLine();	    
		System.out.println("Index : "+search(str,x,0,str.length-1));
		
	}
   static int search(String[] str,String s,int low,int high){
	   if(str==null || s==null || s==""){
		   return -1;
	   }
	//   return search(str,s,0,str.length-1);
	   if(low>high) return -1;
	   int mid=(low+high)/2;
	   //if middle element is empty,then find the closet non-empty string
	   if(str[mid].isEmpty()){
		   int left=mid-1;
		   int right=mid+1;
		   while(true){
			   if(left<low && right>high){
				   return -1;
			   }else if(left>=low && !str[left].isEmpty()){
				   mid=left;
				   break;
			   }else if(right<=high && !str[right].isEmpty()){
				   mid=right;
				   break;
			   }
			   right++;
			   left--;
		   }
	   }
	   //search string
	   if(s.equals(str[mid])){
		   return mid;
	   }else if(str[mid].compareTo(s)>0){
		   return search(str,s,low,mid-1);
	   }else {
		   return search(str,s,mid+1,high);
	   }
   }
	 private static void print(String[] str) {
			for(String s:str){
				System.out.print(s+"  ");
			}	
	}
}
