
public class Solution03 {
	static int MAX_LENGTH = 32;// longest length of sequence is 32

	public static void main(String[] args) {
		System.out.println("x is 1775 (11011101111) ");
		System.out.println("The length lonest sequence is : " + findLongestSequence(1775));

	}

	/*
	 * find a number as a sequence of groups of 0s and 1s.Then the longest
	 * sequence is: a.count of 0s = 1:combine left and right sequences and plus
	 * 1(flip this 0 to 1) b.count of 0s >1:take longer sequence between left
	 * and right sequences ,then plus 1(flip one bit from 0 to 1)
	 */
	static int findLongestSequence(int x) {
		int findElement = 0;
		int[] counts = { 0, 0, 0 };// counts of last 3 sequences: 1s+0s+1s
		int max = 1;// longest sequence

		for (int i = 0; i < MAX_LENGTH; i++) {
			if ((x & 1) != findElement) {
				if (findElement == 1) {// End of 1s+0s+1s sequence
					max = Math.max(max, findMaxSequence(counts));
				}
				findElement = x & 1;// Flip 1 to 0 or 0 to 1
				// we only need to compare each sequence to the immediately
				// surrounding sequences in order to save space,
				// so change counts to record different sequences.
				move(counts);
			}
			counts[0]++;// count the numbers of 1;
			x >>>= 1;// clear the lower bit in order to calculate the next bit
		}
		// check final set of counts
		if (findElement == 0) {
			move(counts);
		}
		return Math.max(max, findMaxSequence(counts));
	}

	/*
	 * The set of counts is {0s,1s,0s},find max sequence
	 */
	private static int findMaxSequence(int[] counts) {
		if (counts[1] == 0) {// no 0, compare left and right and return the
								// longer one
			return Math.max(counts[0], counts[2]);
		} else if (counts[1] == 1) {// only one 0,then can flip 0 to 1 and merge
									// left and right sequences
			return counts[0] + counts[2] + 1;
		} else {// more than 1 0s,then can choose a longer sequence from left
				// and right sequences,and add 1(flip one bit from 0 to 1)
			return Math.max(counts[0], counts[2]) + 1;
		}
	}

	/*
	 * we only need to compare each sequence to the immediately surrounding
	 * sequences in order to save space, so change counts to record different
	 * sequences.
	 */
	private static void move(int[] counts) {
		counts[2] = counts[1];
		counts[1] = counts[0];
		counts[0] = 0;
	}
}
