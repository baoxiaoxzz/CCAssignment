
public class Solution02 {
/*
 * The probability of winning Game 1 is p
 * The probability of winning Game 2 is:
 * p(making all three shots)+p(making 1 and 2,and missing 3)+p(making 1 and 3,and missing 2)+p(making 2 and 3,and missing 1)
 * =p*p*p+p*p*(1-p)+p*(1-p)*p+(1-p)*p*p
 * =p3+3*(1-p)p2
 * =3*p2-2*p3
 * According to the question,if p(game 1) >p(game 2)
 *   p>3*p2-2*p3
 *=> (2*p-1)(p-1)>0
 *=> 2*p-1<0
 *=> p<0.5
 *So,if we should play Game 1 if 0<p<0.5 and Game 2 if 0.5<p<1
 *if p=0,0.5,or 1,then p(Game 1) = p(Game 2),so it doesn't matter which game we play.
 */
}
