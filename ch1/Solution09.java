
public class Solution09 {

	public static void main(String[] args) {
		System.out.println("waterbottle,erbottlewat is rotation: "+isRotation("waterbottle","erbottlewat"));
	}

	private static boolean isRotation(String s1,String s2) {
		if(s1.length()>0&&s1.length()==s2.length()){//x and y are not empty and have the same length
			String combineS2=s2+s2;//If s1 is the substring of combineS2,then s2 is the rotation of s1
			return isSubstring(combineS2,s1);	
		//	return combineS2.contains(s1);
		}	
		return false;
	}

}
