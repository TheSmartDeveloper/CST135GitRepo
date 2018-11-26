package vendMachClasses;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class InventoryManager
{
	String[] productArray = new String[25];
	int[] dispenserArray = new int[25];
	
	public InventoryManager()
	{
		
	}
	public InventoryManager(String[] pArray, int[] dArray)
	{
		this.dispenserArray = dArray;
		this.productArray = pArray;
	}
	
	public void writeOut(String[] pArray, int[] dArray) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("inventory.csv");
		writer.println("Name,Price,Weight,Flavor,Count");
		for(int i = 0; i < 25; i++)
		{
			writer.println(pArray[i] + "," + dArray[i]);
		}
		writer.close();
	}
}
