
public class Solution08 {

	public static void main(String[] args) {
		int[][] matrix = {{1,11,0,1111,11111,111111},
                {2,22,222,2222,22222,222222},
                {3,33,333,3333,33333,333333},
                {4,44,444,0,44444,444444},
                {5,55,555,5555,55555,0},
                {6,66,666,6666,66666,666666}};
		System.out.println("Original array is :");
        printMatrix(matrix);
        System.out.println();
        setZero(matrix, matrix.length);
        printMatrix(matrix);
	}
	public static void setZero(int[][] matrix, int n) {
		boolean[] markRow=new boolean[matrix.length];
		boolean[] markCol=new boolean[matrix[0].length];
		for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==0){//if element = 0,flag its row and column
                	markRow[i]=true;
                	markCol[j]=true;
                }
            }
        }
		for(int i=0;i<matrix.length;i++){
			if(markRow[i]){
				setRowZero(matrix,i);//set all the elements in row i are 0
			}
		}
		for(int j=0;j<matrix[0].length;j++){
			if(markCol[j]){
				setColZero(matrix,j);//set all the elements in column j are 0
			}
		}
	}
	 private static void setColZero(int[][] matrix,int col) {
		 for (int i=0;i<matrix.length;i++) {
			 matrix[i][col]=0;
		 }
	}
	private static void setRowZero(int[][] matrix,int row) {
		for (int i=0;i<matrix[0].length;i++) {
			 matrix[row][i]=0;
		 }
	}
	private static void printMatrix(int[][] matrix) {
	        for (int i=0;i<matrix.length;i++) {
	            for (int j=0;j<matrix[0].length;j++) {
	                System.out.printf("%8d",matrix[i][j] );
	            }
	            System.out.println();
	        }
	    }

}
