
public class Solution06 {

	public static void main(String[] args) {
		System.out.println("x = 29 , y= 15");
		System.out.println("The number of flipping to convert x to y is : " + numberOfConversion(29, 15));
	}

	/*
	 * Because 1 in the operation XOR means a bit that two number are different.
	 * Therefore,if we want to find out number of different bits of two numbers,
	 * we only need to count the number of bits in x^y that are 1.
	 */
	public static int numberOfConversion(int x, int y) {
		int count = 0;
		//operation i & (i-1) will flip the rightmost bit which is 1 to 0
		for (int i = x ^ y; i != 0; i = i & (i - 1)) {
			count++;
		}
		return count;
	}
}
