package vendMachClasses;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GlobalInventoryManagement
{
	@SuppressWarnings("static-access")
	public ArrayList pullFromFile() throws FileNotFoundException
	{
		Candy randomItem = new Candy(0,"0", 0, false);
		ArrayList<Product> productArray = new ArrayList<Product>();
		Scanner fromFiles = new Scanner(new File("inventory.csv"));
		while(fromFiles.hasNextLine())
		{
			String line = fromFiles.nextLine();
			String[] productAttributes = line.split(",");
			productAttributes[0].valueOf(randomItem.ounces);
			productAttributes[1].valueOf(randomItem.name);
			productAttributes[2].valueOf(randomItem.price);
			productAttributes[3].valueOf(randomItem.sweet);
			
			productArray.add(randomItem);
		}
		return productArray;
	}
	
	public void sortArray(ArrayList productArray)
	{
		
	}
	
	public void searchArray()
	{
		
	}
	
	public void printArray(ArrayList productArray) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("inventorySort.txt");
		for(int i = 0; i < productArray.size(); i++)
		{
			writer.println(productArray.toString());
		}
		writer.close();
	}
}
