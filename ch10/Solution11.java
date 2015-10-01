import java.lang.reflect.GenericArrayType;

public class Solution11 {

	public static void main(String[] args) {
		int[] a={5,3,1,2,3};
		System.out.println("original array is :");
		print(a);
		System.out.println();
		System.out.println("alternating sequence is :");
		getPeakValley(a);
		print(a);

	}
	private static void print(int[] a) {
		for(int element:a){
			System.out.print(element+"  ");
		}
		
	}
	static void getPeakValley(int[] a){
		for(int i=1;i<a.length;i+=2){
			int maxIndex=getMaxIndex(a,i-1,i,i+1);
			if(i!=maxIndex){
				swap(a,i,maxIndex);
			}		
		}
		
	}
	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;	
	}
	private static int getMaxIndex(int[] arr, int a, int b, int c) {
		int length=arr.length;
		int aData=a>=0 && a<length ?arr[a]:Integer.MIN_VALUE;
		int bData=b>=0 && b<length ?arr[b]:Integer.MIN_VALUE;
		int cData=c>=0 && c<length ?arr[c]:Integer.MIN_VALUE;
		int max=Math.max(aData,Math.max(bData, cData));
		if(max==aData) return a;
		else if(bData==max) return b;
		else return c;
	}

}
