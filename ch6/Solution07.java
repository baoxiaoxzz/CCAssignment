import java.util.Random;

public class Solution07 {
	/*
	 * Let us put all the gender sequence of each family into one string.
	 * B represents boy and G represents girl.
	 * So if family has1 boy and 1 girl,string is BG.
	 * Family has 2 boys and 1 girl,string is BBG.
	 * Family has 3 boys and 1 girl,string is BBBG.
	 * ...
	 * As soon as a child is born,we can just append its gender (B or G) to the string.
	 * If the odds of having a boy and girl is the same,
	 * then the odds of the next character being a G is 50%.
	 * Therefore,almost half of the string should be end at G.
	 * The gender ratio should be even.
	 * Therefore,the gender ratio is 50% girls and 50% boys.
	 */
	public static void main(String[] args) {
		Random random = new Random();// randomly generate n families.
		int n = random.nextInt(10000000) + 10000;// we have n families.
		// The result should be close to 0.5
		System.out.println("Gender radio is : " + simulateFamilies(n));
	}

	static double simulateFamilies(int n) {
		int girlsNum = 0;
		int boysNum = 0;
		for (int i = 0; i < n; i++) {
			int[] genders = simulateOneFamily();
			girlsNum += genders[0];
			boysNum += genders[1];
		}
		return (double) girlsNum / (girlsNum + boysNum);
	}

	static int[] simulateOneFamily() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		while (girls == 0) {// until the family has a girl
			if (random.nextBoolean() == true) {// the family has a girl
				girls += 1;
			} else {// the family has a boy
				boys += 1;
			}
		}
		int[] genders = { girls, boys };
		return genders;
	}
}
