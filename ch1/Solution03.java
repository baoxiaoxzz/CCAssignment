import java.util.Scanner;

public class Solution03 {

	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Please input string and length and split with , :");
		String[] text=sc.nextLine().split(",");
		String x=text[0];
		int len=Integer.parseInt(text[1]);
		System.out.println(replaceSpaces(x,len));	
	}
	private static char[] replaceSpaces(String x,int len){
    	char[] ch=x.toCharArray();
        int spaceNumber = 0;//calculate the number of space
        for (int i = 0;i < len;i++)
        {
            if (ch[i] == ' ')
            {
            	spaceNumber++;
            }
        }
        int j = 0;
        int newLen = len+2*spaceNumber;//the real length
        char[] newArr = new char[newLen];
        for (int i = 0;i < len;i++)
        {
            if (ch[i] == ' ')
            {
            	newArr[j++] = '%';
            	newArr[j++] = '2';
                newArr[j++] = '0';
            }
            else
            {
            	newArr[j++]=ch[i];
            }
        }
        return newArr;
    }
}
