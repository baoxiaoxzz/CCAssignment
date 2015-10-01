import java.util.Scanner;

public class Solution03 {

	public static void main(String[] args) {
		int[] array={16,17,20,21,26,28,2,4,5,6,7,11,15};
		System.out.println("array : ");
		print(array);
		System.out.println();
		System.out.println("input x: ");
	    Scanner sc =new Scanner(System.in);
	    int x=sc.nextInt();	    
		System.out.println("Index : "+search(array,0,array.length-1,x));
			

	}
	 private static void print(int[] array) {
			for(int a:array){
				System.out.print(a+"  ");
			}	
	}
	static int search(int array[],int low,int high,int x){
		 int mid=(low+high)/2;
		 if(x==array[mid]){
			 return mid;
		 }
		 if(high<low){
			 return -1;
		 }
		 //divide from the middle element,one of the side must be ordered
		 if(array[low]<array[mid]){//left is ordered
			 if(x>=array[low] && x<array[mid]){
				 return search(array,low,mid-1,x);//recursive search left
			 }else{
				 return search(array,mid+1,high,x);//recursive search right
			 } 
		 }else if(array[mid]<array[high]){//right is ordered
			 if(x>array[mid] && x<=array[high]){
				 return search(array,mid+1,high,x);//recursive search right
			 }else{
				 return search(array,low,mid-1,x);//recursive search left
			 } 
		 }else if(array[low]==array[mid]){//the elements of left are all the same
			 if(array[mid]!=array[high]){//the rightmost elment is differnt
				 return search(array,mid+1,high,x);   
			 }else{//search both sides
				 int record=search(array,low,mid-1,x);
				 if(record==-1){
					 return search(array,mid+1,high,x);  
				 }else{
					 return record;
				 }		 
			 }
			 
		 }
		 return -1;
	 }

}
