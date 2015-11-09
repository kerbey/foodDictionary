import java.util.Scanner;
public class driverClass
{
	static Scanner input= new Scanner(System.in);
	static String recieptFile="food.txt",line=null;
	static int  maxCount, amount, i;
	static String food, foodsIngredients;
	public static void main(String[] args)
	{
		binarySearchTree<String> tree= new binarySearchTree<>();
		//ingredientsLinkedList<String> ingredients= new ingredientsLinkedList<>();
		BSTNode<String> bstn= new BSTNode<String>(null);
		System.out.println("main");
		System.out.println("how many food items do you want to add?");
		amount=input.nextInt();
		for (i=0;i<amount;i++)
		{
			System.out.println("what food item would you like to buy?");
			food=input.next();
			input.nextLine();
			System.out.println("what is that food's ingredients?");
			foodsIngredients=input.nextLine();
			bstn.add(food, foodsIngredients);
		}
		bstn.createTextRead();
		System.out.println();
		System.out.println("how many times do you want to search/delete?");
		amount=input.nextInt();
		for(int r=0;r<amount;r++)
		{
			System.out.println("which food would you like to remove/search?");
			food = input.next();
			input.nextLine();
			System.out.println("And what are the food's ingredients do you want to delete?");
			foodsIngredients= input.nextLine();
			bstn.Contains(food+" "+foodsIngredients, foodsIngredients);
			//ingredients.delete(food);
			Gui gui = new Gui();
			food=food+" "+foodsIngredients;
			gui.removeLineFromFile(recieptFile, food);
		}
	}
}