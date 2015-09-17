import java.util.Enumeration;
import java.util.Hashtable;

public class Solution04 {

	public static void main(String[] args) {
		System.out.println("Tact Coa:"+isPermutationofPalindrome("Tact Coa"));
	}
    
	private static boolean isPermutationofPalindrome(String x){
		Hashtable<String, Integer> ht=countNumbers(x);
		boolean odd=false;
		Enumeration<Integer> e = ht.elements(); //get the number of all characters
		while (e.hasMoreElements()) { 
			int count=e.nextElement();
		    if(count%2==1){//the number of character is odd
		    	if(odd){ //already has odd character
		    		return false;
		    	}
		    	odd=true;
		    }
		} 
		return true;
	}
	private static Hashtable<String, Integer> countNumbers(String orix){
		String x=orix.toLowerCase();//convert all the characters of string into lowercase
		Hashtable<String,Integer> hx=new Hashtable<String,Integer>();//key is the character of string,value is the number of the same character
		for(int i=0;i<x.length();i++){
			char temp=x.charAt(i);
			if('a'<=temp&&temp<='z'){//Ignore the non-characters
				if(hx.get(String.valueOf(x.charAt(i)))==null){
					hx.put(String.valueOf(x.charAt(i)), 1);//if key does not exist,then value is 1
				}else{
					hx.put(String.valueOf(x.charAt(i)), hx.get(String.valueOf(x.charAt(i)))+1);//if key exists,then value plus one
				}
			}		
		}
		return hx;
	}

}
