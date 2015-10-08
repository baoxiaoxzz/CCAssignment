
public class Solution05 {

/*
 * If n & (n-1)==0 ,it means n and n-1 never share a 1.
 * When subtract 1 from n,if the least significant bit is 1,then we can directly change it to 0
 * If it is 0,then we should change each bit from  0 to 1 until we find a 1.Flip this 1 to 0.
 * 	Thus, n's initial 0s will be 1s in n-1, and n's least significant 1 will be a 0  in n-1.
 * for example ,if n=abcd10000  ,then n-1 =abcd01111
 * so if n and n-1 never have 1 at the same bit,then a,b,c,d must all be 0.
 * It means n looks like: 000010000. 
 * Therefore,the value n is a power of two.
 * So,we can draw the conclusion that n & (n-1)==0 means n is a power of 2 or n is 0.
 */

}
