
public class Solution07 {

	public static void main(String[] args) {
		int[][] matrix = {{1,11,111,1111,11111,111111},
                {2,22,222,2222,22222,222222},
                {3,33,333,3333,33333,333333},
                {4,44,444,4444,44444,444444},
                {5,55,555,5555,55555,555555},
                {6,66,666,6666,66666,666666}};
		System.out.println("Original array is :");
        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix, matrix.length);
        printMatrix(matrix);
	}
	public static void rotateMatrix(int[][] matrix, int n) { 
		  for (int layer = n/2-1; layer >=0; layer--) {//starting from the innermost layer and working our way outwards
		    int first = layer; int last=n-layer-1;
		    for(int i = first; i < last; i++) {
		      int offset = i - first;
		      int top = matrix[first][i]; // save top
		      // left -> top
		      matrix[first][i] = matrix[last-offset][first];
		      // bottom -> left
		      matrix[last-offset][first] = matrix[last][last - offset];
		      // right -> bottom
		      matrix[last][last - offset] = matrix[i][last];
		      // saved top -> right
		      matrix[i][last] = top; 
		      }
		    }
		}
	 private static void printMatrix(int[][] matrix) {
	        for (int i=0;i<matrix.length;i++) {
	            for (int j=0;j<matrix[0].length;j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
}
