import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; 
public class Solution02 {

	public static void main(String[] args) {
		String[] array={"abcd","erty","cv","ytre","abe","etyr","race","wy","acre","you","care"};
		print(array);
		sort(array);
		System.out.println();
		print(array);
	}

	private static void print(String[] array) {
		for(String string:array){
			System.out.print(string+"  ");
		}
	}

	static void sort(String[] array){
		HashMap<String,ArrayList<String>> hm=new HashMap<String,ArrayList<String>>();
		//anagrams have the same key,key is the sorted string 
		for(String string:array){
			String key =sortString(string);
			ArrayList<String> list=new ArrayList<String>();	
			if(hm.get(key)!=null){
				list=hm.get(key);						
			}
			list.add(string);	
			hm.put(key, list);
		}
		//convert hashmap to array
		int index=0;
		for(String key:hm.keySet()){
			ArrayList<String> list=hm.get(key);
			for(String string:list){
				array[index++]=string;
			}
		}
	}

	private static String sortString(String string) {
		char[] s=string.toCharArray();
		Arrays.sort(s);
		return new String(s);
	}
}
