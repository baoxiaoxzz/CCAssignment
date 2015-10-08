
public class Solution06 {
/*
 * Assume there are n people on the island and c of them have blue eyes,c>0.
 * 1.Base case: Exactly one person has blue eyes
 *  The blue-eyed person should look around and realize that no one else has blue eyes.
 *  Since he knows that at least one person has blue eyes,he must conclude that 
 *  he has blue eyes.Therefore,he would leave that evening.
 * 2.When c=2:Exactly two people have blue eyes
 * The two blue-eyed people see each other,but are unsure whether c is 1 or 2
 * They know,from the previous case ,if c=1,the blue-eyed person would leave on the first night.
 * Therefore,if the other blue-eyed person is still there,he must deduce that c=2.
 * It means that he himself has blue eyes.Both men would then leave on the second night.
 * 3.When c>2: The general Case
 * When c=3,then those three people will immediately know that there are either 2 or 3 peole with blue eyes.
 * If there are two people,then those two people would have left on the second night.So,when the 
 * others are still around after that night,each person would conclude that c = 3
 * and they have blue eyes too.They would leave that night.
 * THerefore,the same logic applies to any value of c.THerefore,if c men have blue eyes,it will take
 * c nights for the blue-eyed men to leave.All the blue-eyed men will leave on the same night. 
 */

}
