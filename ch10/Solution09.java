
public class Solution09 {

	public static void main(String[] args) {
	int[][] array={{15,20,40,85},
			{20,35,80,95},
			{30,55,95,105},
			{40,80,100,120}			 
	};
	System.out.println(findE(array,55));
	}
	static /*from the element located at first row and last column*/
   boolean findE(int[][] matrix,int value){
	   int row=0;
	   int column=matrix[0].length-1;
	   while(row<matrix.length && column >=0){
		   if(matrix[row][column]==value){
			   return true;
		   }else if(matrix[row][column]<value){
			   row++;
		   }else{
			   column--;
		   }
	   }
	   return false;
   }
}
