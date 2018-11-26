package vendMachClasses;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Restock
{
	public String declareLowInventory()
	{
		return " LOW ";
	}
	
	public void purchaseOrder(ArrayList productArray) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("purchaseOrder.txt");
		for(int i = 0; i < productArray.size(); i++)
		{
			writer.println(productArray.toString());
		}
		writer.close();
	}
}
