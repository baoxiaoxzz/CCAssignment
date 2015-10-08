
public class Solution01 {
	public static void main(String[] args) {
		System.out.println("N = 1000000000, M = 10011, i = 2, j = 6 :");
		System.out.println(Integer.toBinaryString(insertMintoN(0x00000013, 0x00000200, 2, 6)));
	}

	static int insertMintoN(int m, int n, int i, int j) {
		// Use a mask to clear bits j through i in n.For example,assuming 8
		// bits,i=2,j=5.Result:11000011
		int allOnes = ~0;// all 1s
		// 1s before position j,then 0s.left is 11000000
		int left = allOnes << (j + 1);
		// set all the bits are 1 after position i. right is 00000011
		int right = ((1 << i) - 1);
		// merge right and left,so all bits are 1 except for the bits between i
		// and j. mask=11000011
		int mask = left | right;
		// clear bits j through i then put m into there
		int nCleared = n & mask;// clear bits j through i
		int mShifted = m << i;// move m into the position where bits j through i
		return nCleared | mShifted;// operation OR
	}
}
