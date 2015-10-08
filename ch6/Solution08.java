public class Solution08 {
	/*  
	 * 1.The perfectly load-balanced system would be one in which Drops(Egg 1)+Drops(Egg 2) 
	 * is always the same,regardless of where Egg 1 breaks.
	 * 2.Since each drop of Egg 1 takes one more step,Egg 2 is allowed one fewer step.
	 * 3.Therefore,we can reduce the number of steps required by Egg 2 by one drop each time.
	 *  For example,if Egg 1 is dropped on floor 10 and then floor 20.
	 *  Egg 2 is required to take 9 steps.When we drop Egg 1 again,we must reduce Egg 2 steps
	 *  to only 8.That is,we should drop Egg 1 at floor 29.
	 * 4.Therefore,Egg 1 must start at floor x,then go up by x-1 floors,then x-2,...,until it gets to 100.
	 * 5.So x is:
	 *    x+ (x-1) +(x-2) +...+1=100(number of floors)
	 *    x*(x+1)/2=100
	 *    x=13.7
	 *   x must be integer.If we assume x=13,then we would go up by 13,then 12,then 11,and so on.The last
	 *   increment will be 1 and it will happen at floor 91.This is after 13 drops.Floors 92 through 100
	 *   have not been covered yet.But we can not cover those floors in just one drop.
	 *   Therefore,we should assume x up to 14.That is,we go to floor 14,then 27,then 39,...
	 *   This takes 14 steps in the worse case.
	 */
	public static int breakingFloor = 25;// Assume
	int count = 0;

	boolean drop(int floor) {// whether egg is broken
		count++;
		return floor >= breakingFloor;
	}

	int findBestPoint(int floors) {
		int interval = 14;
		int preFloor = 0;
		int egg1 = interval;

		// Drop egg1 at decreasing intervals.
		while (!drop(egg1) && egg1 <= floors) {
			interval -= 1;
			preFloor = egg1;
			egg1 += interval;
		}
		// Drop egg2 at increasing one by one
		int egg2 = preFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
			egg2 += 1;
		}
		// If the egg2 did not break,return -1
		return egg2 > floors ? -1 : egg2;
	}

}
