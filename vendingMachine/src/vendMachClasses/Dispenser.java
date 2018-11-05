package vendMachClasses;
import java.util.*;
public class Dispenser
{
	private final int COLUMN_SIZE = 7;									//constant var since the number of spots in the columns can't be changed
	private final int NUM_COLUMNS = 5;									//constant var since the number of columns in the machine can't be changed
	int [][] columnArray = new int[NUM_COLUMNS][COLUMN_SIZE];			//array created with limits set to the column size and the number of columns
	int[] columnID = new int[NUM_COLUMNS];								//each column gets a unique id
	int[] columnPrice = new int[NUM_COLUMNS];							//each column has a unique price
	int[] columnSnackCount = new int[COLUMN_SIZE];						//each column has a counter with the number of snacks
	Product empty = new Candy(0.00, "Empty", 0.00, false);
	int count = 10;
	
	public int dispenseItem()								//method to dispense items, will set a certain row to 0 since a row cannot have more than one item because this is a vertical 2d machine not a 3d machine
	{
		return count--;
	}
	public int loadMachine()							//method to ad items, will set a certain row to 1 since a row cannot have more than one item because this is a vertical 2d machine not a 3d machine
	{
		return count++;
	}
	public int getCount()
	{
		return count;
	}
	public int displayProducts()										//print out the array
	{
		for(int g = 0; g < COLUMN_SIZE; g++)
		{
			for(int h = 0; h < NUM_COLUMNS; h++)
			{
				System.out.print(columnArray[h][g] + "     ");
			}
			System.out.println();
		}
		return 1;
	}
	
}
