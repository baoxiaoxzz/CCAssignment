import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution04 {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(11);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(20);
		list.add(21);
		list.add(26);
		list.add(28);
		System.out.println("List : ");
		print(list);
		System.out.println();
		System.out.println("input x: ");
	    Scanner sc =new Scanner(System.in);
	    int x=sc.nextInt();	    
		System.out.println("Index : "+search(list,x));

	}
	 private static void print(List<Integer> list) {
			for(int a:list){
				System.out.print(a+"  ");
			}	
	}
	static int search(List<Integer> list,int x){
		int index=1;
		try{
			while(list.get(index)!=-1 && list.get(index)<x){
		
			index*=2;		
		}
		}catch(IndexOutOfBoundsException e){
		}finally{
		//binary search
		int low=index/2;
		int high=index;
		while(low<=high){
			int mid=(low+high)/2;
			int midValue=list.get(mid);
			if(midValue==x){
				return mid;
			}else if(midValue>x|| midValue==-1){
				high=mid-1;
			}else if(midValue<x){
				low=mid+1;
			}
		}	
		return -1;
		}
	}

}
