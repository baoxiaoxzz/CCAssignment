import java.util.Hashtable;

public class Solution02 {

	public static void main(String[] args) {
		System.out.println("dog and God are permutation:"+isPermutation("dog","God"));
	}
    
	private static boolean isPermutation(String x,String y){
		return storeInHt(x).equals(storeInHt(y));
	}
	private static Hashtable<String, Integer> storeInHt(String orix){
		String x=orix.toLowerCase();//convert all the characters of string into lowercase
		Hashtable<String,Integer> hx=new Hashtable<String,Integer>();//key is the character of string,value is the number of the same character
		for(int i=0;i<x.length();i++){
			if(hx.get(String.valueOf(x.charAt(i)))==null){
				hx.put(String.valueOf(x.charAt(i)), 1);//if key does not exist,then value is 1
			}else{
				hx.put(String.valueOf(x.charAt(i)), hx.get(String.valueOf(x.charAt(i)))+1);//if key exists,then value plus one
			}
		}
		return hx;
	}
}
