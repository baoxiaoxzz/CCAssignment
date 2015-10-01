import java.util.Random;
public class Solution01 {

	public static void main(String[] args) {
		int[] a=new int[100];
		Random r=new Random();
		for(int i=1;i<10;i++){
			a[i]=a[i-1]+r.nextInt(10);
		}
		int[] b={3,42,54,62,78,94,95,134,142};
		System.out.println("array a is : " );
		print(a,10);
		System.out.println();
		System.out.println("array b is : " );
		print(b,b.length);
		System.out.println();
		merge(a,b,10);
		System.out.println("merged array is : " );
		print(a,10+b.length);
	}
	
	/*print array*/
	private static void print(int[] a,int actual) {
		for (int i=0;i<actual;i++ ){
			System.out.print(a[i]+"  " );
		}		
	}
   /*merge by incremental order*/
	static void merge(int a[],int b[],int actual){
		int aIndex=actual-1;//the index of last element of array a  
		int bIndex=b.length-1;//the index of last element of array b
		int mergeIndex=actual+b.length-1;//the index of last element of merged array
		//from the rear of each array 
		while(bIndex>=0){
			if(aIndex>=0 && a[aIndex]>=b[bIndex]){//end of array a >end of array b
			//	System.out.println("下标："+aIndex + " " +mergeIndex);
				a[mergeIndex]=a[aIndex];
				aIndex--;
			}else{
				a[mergeIndex]=b[bIndex];
				bIndex--;
			}
			mergeIndex--;
		}		
	}
}
