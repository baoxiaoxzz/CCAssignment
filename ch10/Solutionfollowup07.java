import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solutionfollowup07 {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName="d:\\test.txt";
		findMissingInt(fileName);

	}
    static int findMissingInt(String fileName) throws FileNotFoundException{
    	int range=(1<<20);//2^17 bytes
        //get count of each slice
        int[] slices=getCount(fileName,range);
        //find missing value
        int sliceIndex=findMissing(slices,range);
        if(sliceIndex<0) return -1;
        //create bit vector within this range
        byte[] bVector=getBitVector(fileName,sliceIndex,range);
        //find flag 0 in the bit vector
        int index=findFalse(bVector);
        if(index<0) return -1;
        //missing value
        return sliceIndex*range+index;
    }
	private static int findFalse(byte[] bVector) {
		for(int i=0;i<bVector.length;i++){
			if(bVector[i]!=~0){//not each bite is 1
				int index=findFalse(bVector[i]);
				return i*Byte.SIZE+index;		
			}
			
		}
		return 0;
	}
	private static byte[] getBitVector(String fileName, int sliceIndex, int range) throws FileNotFoundException {
		int first=sliceIndex*range;
		int last=first+range;
		byte[] bVector=new byte[range/Byte.SIZE];
		Scanner sc=new Scanner(new FileReader(fileName));
		while(sc.hasNext()){
			int data=sc.nextInt();
			//mark 1 if value exists,otherwise 0
			if(first<=data && data <last){
				int index=data-first;
				bVector[index/Byte.SIZE]|=1<<(index%Byte.SIZE);
			}
		}
		sc.close();
		return bVector;
	}
	private static int findFalse(byte b) {
		for(int i=0;i<Byte.SIZE;i++){
			if((b & (1 << i)) ==0){
				return i;	
			}
		}
		return -1;
	}
	private static int findMissing(int[] slices, int range) {
		for(int i=0;i<slices.length;i++){
			if(slices[i]<range){
				return i;
			}
		}
		return -1;
	}
	private static int[] getCount(String fileName, int range) throws FileNotFoundException {
		int sliceSize=Integer.MAX_VALUE/range+1;
		int[] b=new int[sliceSize];
		Scanner sc =new Scanner(new FileReader(fileName));
		while(sc.hasNext()){
			int data=sc.nextInt();
			b[data/range]++;
		}
		sc.close();
		return b;
	}
    
}
