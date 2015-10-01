import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution07 {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName="d:\\test.txt";
		 findMissingInt(fileName);
	}
	/*we have 8 billion bits(1GB) of memory and 4 million non-negative integars,so we can map all possible integers to a bit*/
   static void findMissingInt(String fileName) throws FileNotFoundException{
	   long num=((long)Integer.MAX_VALUE)+1;
	   byte[] bit=new byte[(int) (num/8)];
	   Scanner sc=new Scanner(new FileReader(fileName));
	   while(sc.hasNext()){
		   int x=sc.nextInt();
		   //store in the bit[]
		   bit[x/8]|=1<<(x%8);
	   }
	   for(int i=0;i<bit.length;i++){
		   for (int j=0;j<8;j++){
			   if((bit[i]&(1<<j))!=1){
				   System.out.println(i*8+j);
				   return;
			   }
		   }
	   }
   }
}
