import java.util.Random;

public class Solution08 {
	 static int N = 32000;
	public static void main(String[] args) {
		  Random rand = new Random();
		  int[] array=new int[N];		
		  for (int i = 0; i < N; i++)
		  array[i]=(rand.nextInt(N-1)+1);
		  findDuplicates(array);
	}
	static /*availabe bits:8*4*2^10 > 32000, so can create a vector of 32000 bits */
	void findDuplicates(int[] array){
		int[] bit=new int[(32000>>5)+1];//divide by 32
		for(int i=0;i<array.length;i++){
			int data=array[i];
			int index=data-1;
			if((bit[index>>5]&(1<<(index&0x1F)))!=0){//integer is 4*8=32bits. mod32:index & 32
				System.out.println(data);
			}else{
				bit[index>>5]|=1<<(index&0x1F);
			}
		}
	}
}
