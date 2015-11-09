import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BSTNode <T>
{
	protected T info;
	protected BSTNode<T> left;
	protected BSTNode<T> right;
	
	static String recieptFile="food.txt", newRecieptFile="new.txt",line = "";
	static int maxCount, count=0;
	static PrintWriter textStream = createTextWrite(recieptFile);
	binarySearchTree<String> tree= new binarySearchTree<>();	
	ingredientsLinkedList<String> ingredients= new ingredientsLinkedList<>();
	
	//ingredientsLinkedList<String> ingredients=new ingredientsLinkedList<>();
	public BSTNode(T info)
	{
		this.info = info;
		left = null;
		right = null;
	}
	public T getInfo() {
		//System.out.println("getInfo=="+this.info);
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public BSTNode<T> getLeft() {
		//System.out.println("getLeft=="+this.left);
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		//System.out.println("getRight=="+this.right);
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	/*public boolean isEmpty()
	{//returns true to show node and children are empty
		if(getLeft()==null && getRight()==null)
		{	
			System.out.println("right  "+getRight());
			System.out.println("left  "+getLeft());
			if(getInfo()==null)
			{
				System.out.println("getinfo "+getInfo());
				return true;
			}
		}
		System.out.println("getinfo "+getInfo());
		return false;
	}*/
	public void add(String food, String foodIngredients)
	{
		count++;
		line=(food+" "+foodIngredients);
		textStream.println(line);
		ingredients.Add(foodIngredients);
		tree.add(food+" "+foodIngredients);
		return;                                                                                                               
	}
	public void Contains(String second, String foodsIngredients) {
		tree.contains(second, foodsIngredients);
	}//*/
	@SuppressWarnings("static-access")
	public static void createTextRead()
	{
		textStream.close();
		maxCount=count;
		System.out.println("textfile method");
		Scanner scanFile= createTextRead(recieptFile);
		for(count=1;count<=maxCount;count++) {	
			//System.out.println("count====== "+count);
			//System.out.println("line"+line);                                                                            
			//count=scanFile.nextInt();
			line = scanFile.nextLine();
			//System.out.println("line"+line);
			//System.out.println(DriverClass.count + line);
		}
		scanFile.close();
		return;
	}
	@SuppressWarnings("unchecked")
	public boolean checkFile(Object element)
	{//double checks file to get back a line before returning it and deleteing it
		System.out.println("CHECKFILE");
		Scanner scanFile= createTextRead(recieptFile);
		for(count=1;count<=maxCount;count++)//fix limit
		{
			//System.out.println("count2===== "+count);
			//count=scanFile.nextInt();
			line = scanFile.nextLine();
			if(((String) element).contains(line))
			{
				System.out.println("food you're looking for is in the file and will be found in binary search tree");
				return true;
			}
		}//scanFile.close();
		System.out.println("food you're looking for is NOT in the file and will NOT be found in binary search tree");
		return  false;
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
}