import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;


public class Solution06
{
 static int N = 20000000; // size of the file in all
 static int M = 100000; // the amount of memory we have available
 
 public static void externalSort(String fileName)
 {
  String tempFile = "tFile";
  int[] buffer = new int[M < N ? M : N];
  
  try
  {
   FileReader fr = new FileReader(fileName);
   BufferedReader br = new BufferedReader(fr);
   int parts = (int) Math.ceil((double) N/M);
   
   int i=0;
   int j = 0;
   // Iterate in the file
   for (i = 0; i < parts; i++)
   {
    // Read one chunk from the file
    for (j = 0; j < (M < N ? M : N); j++)
    {
     String str = br.readLine();
     if (str != null)
      buffer[j] = Integer.parseInt(str);
     else
      break;
    }
    // Sort 
    Arrays.sort(buffer);

    // Write the sorted numbers into temporary file
    FileWriter fw = new FileWriter(tempFile + Integer.toString(i) + ".txt");
    PrintWriter pw = new PrintWriter(fw);
    for (int k = 0; k < j; k++)
     pw.println(buffer[k]);
    
    pw.close();
    fw.close();
   }
   
   br.close();
   fr.close();
   
   //merge each file, then write back to disk
   int[] maxNums = new int[parts];
   BufferedReader[] brs = new BufferedReader[parts];
   
   for (i = 0; i < parts; i++)
   {
    brs[i] = new BufferedReader(new FileReader(tempFile + Integer.toString(i) + ".txt"));
    String s = brs[i].readLine();
    if (s != null)
     maxNums[i] = Integer.parseInt(s);
    else
     maxNums[i] = Integer.MAX_VALUE;
   }
   
   FileWriter fw = new FileWriter("D:\\externalsorted.txt");
   PrintWriter pw = new PrintWriter(fw);
   
   for (i = 0; i < N; i++)
   {
    int min = maxNums[0];
    int minIndex = 0;
    
    for (j = 0; j < parts; j++)
    {
     if (min > maxNums[j])
     {
      min = maxNums[j];
      minIndex = j;
     }
    }
    
    pw.println(min);
    String t = brs[minIndex].readLine();
    if (t != null)
     maxNums[minIndex] = Integer.parseInt(t);
    else
     maxNums[minIndex] = Integer.MAX_VALUE;
    
   }
   for (i = 0; i < parts; i++)
    brs[i].close();
   
   pw.close();
   fw.close();
  }
  catch (FileNotFoundException e)
  {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }  
 }


 static String randomInput(int n)
 {
  String fileName = "external-sort.txt";
  Random rand = new Random();
  
  try
  {
   FileWriter fw = new FileWriter(fileName);
   PrintWriter pw = new PrintWriter(fw);
   
   for (int i = 0; i < n; i++)
    pw.println(rand.nextInt(101));
   
   pw.close();
  }
  
  catch (IOException e)
  {
   e.printStackTrace();
  }
  
  return fileName;
 }
        
 public static void main(String[] args)
 {
  String fileName = randomInput(N);
  externalSort(fileName);
 }
}

