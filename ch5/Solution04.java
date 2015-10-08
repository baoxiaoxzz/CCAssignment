
public class Solution04 {

	public static void main(String[] args) {
		System.out.println("n = 11011001111100 (binary representation)");
		System.out.println("The next number is : " + Integer.toBinaryString(getNext(13948)));
		System.out.println("The previous number is : " + Integer.toBinaryString(getPrevious(0x0000367C)));
	}

	/*
	 * Assume the rightmost non-trailing zero is called position p. num1 is the
	 * number of ones to the right of p. num0 is the number of zeros to the
	 * right of p. step 1:Flip rightmost non-trailing zero step 2:Clear bits to
	 * the right of p step 3:Add num1-1(step 1 already add one 1) ones on the
	 * right.
	 */
	static int getNext(int n) {
		// first calculate num0 and num1
		int tem = n;
		int num0 = 0;// number of zeros to the right of p
		int num1 = 0;// number of ones to the right of p
		while (((tem & 1) == 0) && (tem != 0)) {// calculate num0
			num0++;
			tem >>= 1;// next bit
		}
		while ((tem & 1) == 1) {// calculate num1
			num1++;
			tem >>= 1;// next bit
		}
		/*
		 * rule out two situation a.the leftmost bits are the first non-trailing
		 * zero,then there is no bigger number with the same number of 1s, in
		 * this case num0+num1 = 32,for example,111..00...00 b.the rightmost
		 * bits are the only non-trailing zero,then there is no smaller number
		 * with the same number of 1s, in this case num0+num1= 0,for
		 * example,000..11...11
		 */
		if (num0 + num1 == 32 || num0 + num1 == 0) {
			return -1;
		}
		int p = num0 + num1;// position of rightmost non-trailing zero
		n |= (1 << p);// Flip rightmost non-trailing zero
		n &= ~((1 << p) - 1);// clear all bits to the right of p
		n |= (1 << (num1 - 1)) - 1;// insert num1-1 ones on the rightmost bits.
		return n;
	}

	/*
	 * Assume the rightmost non-trailing one is called position p. num1 is the
	 * number of trailings ones. num0 is the size of the block of zeros
	 * immediately to the left of the trailing ones. step 1:Calculate num0,num1
	 * and find position p step 2:Clear bits 0 through p step 3:Insert num1+1
	 * ones immediately to the right of position p.
	 */
	static int getPrevious(int n) {
		int tem = n;
		int num0 = 0;// the size of the block of zeros immediately to the left
						// of the trailing ones
		int num1 = 0;// the number of trailings ones
		while ((tem & 1) == 1) {// calculate num1
			num1++;
			tem >>= 1;// next bit
		}
		if (tem == 0)
			return -1;
		while (((tem & 1) == 0) && (tem != 0)) {// calculate num0
			num0++;
			tem >>= 1;
		}
		int p = num0 + num1;// position of rightmost non-trailing one
		int a = ~0;// sequence of 1s
		int b = a << (p + 1);// sequence of 1s followed by p+1 zeros
		n &= b;// clear bits 0 through p
		int i = 1 << (num1 + 1);// 0s with 1 at position (num1+1)
		int j = i - 1;// 0s followed by num1+1 ones
		int k = j << (num0 - 1);// num1+1 ones followed by num0-1 zeros
		n |= k;
		return n;
	}

}
