import java.util.ArrayList;

public class Solution10 {
	/*
	 * Seven days.
	 * If power(2,S)< = B, where T is the number of test strips and B is the number of bottles.
	 * Each test strip is a binary indicator for poisoned or unpoisoned.
	 * We can take each bottle number and look at its binary representation.
	 * If there is a 1 in the ith digit,then we will add a drop of this bottle's contents to test strip i.
	 * and power(2,10) is 1024,so 10 test strips will be enough to handle up to 1024 bottles.
	 * We wait 7 days,and then read the results.If test strip i is positive,then set bit i of
	 * the result value.Reading all the test strips will give us the ID of the poisoned bottle.
	 */
	class Bottle {
		private int id;
		private boolean poisoned = false;

		public Bottle(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setIsPoisoned() {
			poisoned = true;
		}

		public boolean isPoisoned() {
			return poisoned;
		}
	}

	class TestStrip {
		public static final int DAYS_GET_RESULT = 7;
		private ArrayList<ArrayList<Bottle>> dropOneDay = new ArrayList<ArrayList<Bottle>>();
		private int id;

		public TestStrip(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void addDropOnDay(int day, Bottle bottle) {
			enlargeDropsForDay(day);
			ArrayList<Bottle> drops = dropOneDay.get(day);
			drops.add(bottle);
		}

		// if list of days is not large enough,enlarge it
		private void enlargeDropsForDay(int day) {
			while (dropOneDay.size() <= day) {
				dropOneDay.add(new ArrayList<Bottle>());
			}
		}

		public boolean isPositiveOnDay(int day) {
			int testDay = day - DAYS_GET_RESULT;
			if (testDay < 0 || testDay >= dropOneDay.size()) {
				return false;
			}
			for (int i = 0; i <= testDay; i++) {
				ArrayList<Bottle> bottles = dropOneDay.get(i);
				if (hasPoison(bottles)) {
					return true;
				}
			}
			return false;
		}

		private boolean hasPoison(ArrayList<Bottle> bottles) {
			for (Bottle b : bottles) {
				if (b.isPoisoned()) {
					return true;
				}
			}
			return false;
		}

	}

	int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		test(bottles, strips);
		ArrayList<Integer> positive = getResults(strips, 7);
		return setBits(positive);
	}

	// Add bottle contents to test strips
	void test(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		for (Bottle bottle : bottles) {
			int id = bottle.getId();
			int bitPosition = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					strips.get(bitPosition).addDropOnDay(0, bottle);
				}
				bitPosition++;
				id >>= 1;
			}
		}
	}

	// Get test strips that are positive on the particular day.
	ArrayList<Integer> getResults(ArrayList<TestStrip> strips, int day) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip strip : strips) {
			int id = strip.getId();
			if (strip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}
		return positive;
	}

	// set bits which teststrip indicated is positive
	int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitPos : positive) {
			id |= 1 << bitPos;
		}
		return id;
	}
}
