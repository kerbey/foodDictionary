import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Gui
{
	static String file;

	public void removeLineFromFile(String file, String lineToRemove)
	{		 
		try
		{ 
			File inFile = new File(file);

			if (!inFile.isFile())
			{
				System.out.println("Parameter is not an existing file");
				return;
			}
			//Construct the new file that will later be renamed to the original filename. 
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			//takes in the old file and reads it
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			//new print writer to write the temporary file which is getting passed in
			String line = null;
			//Read from the original file and write to the new 
			//unless content matches data to be removed.
			while ((line = br.readLine()) != null)
			{//this loop reads all lines until it comes across the line that has to be deleted
				if (!line.trim().equals(lineToRemove))
				{
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();
			//Delete the original file if it can be done
			if (!inFile.delete())
			{
				System.out.println("Could not delete file");
				return;
			}       
			//Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
/*static String recieptFile="food.txt",line = "";
	static int maxCount, count=0;
	static PrintWriter textStream = createTextWrite(recieptFile);
	binarySearchTree<String> tree= new binarySearchTree<>();	
	public void add(String first)
	{
		count++;
		line=(first);
		textStream.println(count+" "+line);
		tree.add(first);
		return;                                                                                                               
	}

	public void contains(String second) {
		tree.contains(second);
	}//
	@SuppressWarnings("static-access")
	public static void createTextRead()
	{
		textStream.close();
		maxCount=count;
		System.out.println("textfile method");
		Scanner scanFile= createTextRead(recieptFile);
		for(count=1;count<=maxCount;count++){	
			System.out.println("count====== "+count);
			System.out.println("line"+line);                                                                            
			count=scanFile.nextInt();
			line = scanFile.nextLine();
			//System.out.println("line"+line);
			//System.out.println(DriverClass.count + line);
		}
		scanFile.close();
		return;
	}
	public Object checkFile(Object tree)
	{//double checks file to get back a line before returning it and deleteing it
		System.out.println("CHECKFILE");
		Scanner scanFile= createTextRead(recieptFile);
		for(count=1;count<=maxCount;count++)//fix limit
		{
			System.out.println("count2= "+count);
			count=scanFile.nextInt();
			line = scanFile.nextLine();
			if(line==tree)
			{
				tree=line;                                                                                                    
				return tree;

			}
			System.out.println(count + line);
		}scanFile.close();
		return tree;
	}
	public static PrintWriter createTextWrite(String S)
	{
		PrintWriter TStream=null;
		try
		{
			TStream= new PrintWriter(new FileOutputStream(S));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file in createTextWrite "+S.toString());
		}
		return TStream;
	}
	public static Scanner createTextRead(String S)
	{
		Scanner textFile=null;
		try 
		{
			textFile= new Scanner(new FileInputStream(new File(S)));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found "+S.toString());
			System.out.println("or could not be opened. "+S.toString());
		}
		return textFile;
	}
}*/