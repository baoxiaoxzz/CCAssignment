
public class Solution02 {

	public static void main(String[] args) {
		System.out.println("Binary of 0.625 is :");
		System.out.println((binaryToString(0.625)));

	}

	/*
	 * In order to print the decimal part,we can multiply by 2. If product is
	 * >=1 , then this number has a 1 after the decimal point. Otherwise,this
	 * number has a 0 behind the decimal point. Repeat this step,we can print
	 * every digit.
	 */
	static String binaryToString(double x) {
		if (x <= 0 || x >= 1) { // 0<=x<=1
			return "ERROR";
		}
		StringBuilder str = new StringBuilder();
		str.append(".");
		while (x > 0) {
			// at most 32 characters
			if (str.length() >= 32) {
				return "ERROR";
			}
			double temp = x * 2;
			if (temp >= 1) {// this bit is 1
				str.append(1);
				x = temp - 1;// clear higher bit
			} else {
				str.append(0);// this bit is 0
				x = temp;
			}
		}
		return str.toString();
	}

}
