
public class Solution01 {

	public static void main(String[] args) {
      System.out.println("Abc3:"+isUniqueStr("Abc3"));  
      System.out.println("AbA3:"+isUniqueStr("AbA3")); 
	}
    private static boolean isUniqueStr(String str) {
	//Assume is the set of ASCII,including 256 characters
    if(str==null) return true;
 	if(str.length()>256) return false;
 	int[] mark = new int[8];//Define size of integer array is 8,then it has 8*4*8=256 bits
 	for(int i=0;i<str.length();i++) {
 		char ch= str.charAt(i);
 		int val = (int) ch; // Convert character to the integer value,the range is from 0 to 256
 		int arrIndex = val / 32; // Map the index of array
 		int bitIndex = val % 32; // Assume the rightmost bit in every integer is 0.Map the index of bit in every integer
 		if (((mark[arrIndex] >> bitIndex)&1)!=0){
 			return false;
 		}
     mark[arrIndex]|=1<<bitIndex;
    }
 	return true;
    }   
 }
 