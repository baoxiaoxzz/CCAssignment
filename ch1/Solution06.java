
public class Solution06 {

	public static void main(String[] args) {
		System.out.println("aabcccccaaa -> "+compressString("aabcccccaaa"));
		System.out.println("abcdefgh -> "+compressString("abcdefg"));
		System.out.println("aabccccccCcaaa -> "+compressString("aabccccccCcaaa"));
	}

	private static String compressString(String x) {
		StringBuilder sb=new StringBuilder();
		int count=0;
		for(int i=0;i<x.length();i++){
			count++;
			if((i==x.length()-1)||x.charAt(i)!=x.charAt(i+1)){//if the character is the last character or the character is different from the next character 
				sb.append(x.charAt(i));
				sb.append(count);
				count=0;
			}	
		}
		return x.length()<sb.length()?x:sb.toString();
	}

}
