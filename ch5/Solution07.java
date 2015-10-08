
public class Solution07 {
	public static void main(String[] args) {
		System.out.println("n = 01011001111001 (binary representation)");
		System.out.println("Swap : " + Integer.toBinaryString(swapOddEvenBits(5753)));
	}

	/*
	 * step 1:mask all odd bits with 10101010 in binary (0xAAAAAAAA),then shift
	 *       them right by 1 to put them in the even spots .
	 * step 2:mask all even bits with 01010101 in binary (0x55555555),then shift 
	 *       them left by 1 to put them in the odd spots.
	 * step 3:merge two values.
	 */
	static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | (x & 0x55555555) << 1);
	}
}
