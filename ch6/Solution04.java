
public class Solution04 {
/*
 * The ants will collide if any of them are moving towards each other.
 * So,the only way that they won't collide is if they are all moving
 * in the same direction,that is clockwise or counterclockwise.
 * So,p(clockwise)=0.5*0.5*0.5=0.125
 *    p(counterclockwise)=0.5*0.5*0.5=0.125
 *    p(same direction)=p(clockwise)+p(counterclockwise)=0.25
 *  The probability of collision is the probabiity of the ants not moving in the same direction
 *   p(collision)=1-p(same direction)=1-0.25=0.75
 *   
 *   To generalize this to an n-vertex polygon:
 *   There are only two ways in which the ants can move to avoid a collision,
 *   and there are power(2,n) ways they can move in total.
 *   Therefore,probability of collision is:
 *    p(clockwise)=power(0.5,n).
 *    p(counterclockwise)=power(0.5,n).
 *    p(same direction)=p(clockwise)+p(counterclockwise)=power(0.5,n-1).
 *    p(collision)=1-p(same direction)=1-power(0.5,n-1).
 *   
 */
}
