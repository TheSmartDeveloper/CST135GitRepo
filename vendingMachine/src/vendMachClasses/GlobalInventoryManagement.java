package vendMachClasses;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GlobalInventoryManagement
{
	ArrayList<Product> InventoryName = new ArrayList<Product>();
	ArrayList<coffee> coffeeArray = new ArrayList<coffee>();
	ArrayList<energyDrinks> eDrinkArray = new ArrayList<energyDrinks>();
	ArrayList<water> waterArray = new ArrayList<water>();
	ArrayList<soda> sodaArray = new ArrayList<soda>();
	ArrayList<Gum> gumArray = new ArrayList<Gum>();
	ArrayList<Chips> chipsArray = new ArrayList<Chips>();
	ArrayList<Candy> candyArray = new ArrayList<Candy>();
	@SuppressWarnings("static-access")
	public void pullFromFile() throws FileNotFoundException
	{
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
		try
		{
			while((line = br.readLine()) != null)
			{
				String[] productAttributes = line.split(",");
				String productType = productAttributes[0];
				switch(productType)
				{
				case "Coffee": 
					coffee newCoffee = new coffee();
					newCoffee.setName(productAttributes[1]);
					newCoffee.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newCoffee.setWeight(Double.valueOf(productAttributes[3]));
					newCoffee.setFlavor(Boolean.valueOf(productAttributes[4]));
					newCoffee.setCount(Integer.valueOf(productAttributes[5]));
					coffeeArray.add(newCoffee);
					InventoryName.add(newCoffee);
					break;
				case "Water":
					water newWater = new water();
					newWater.setName(productAttributes[1]);
					newWater.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newWater.setWeight(Double.valueOf(productAttributes[3]));
					newWater.setFlavor(Boolean.valueOf(productAttributes[4]));
					newWater.setCount(Integer.valueOf(productAttributes[5]));
					waterArray.add(newWater);
					InventoryName.add(newWater);
					break;
				case "Energy Drink":
					energyDrinks newenergyD = new energyDrinks();
					newenergyD.setName(productAttributes[1]);
					newenergyD.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newenergyD.setWeight(Double.valueOf(productAttributes[3]));
					newenergyD.setFlavor(Boolean.valueOf(productAttributes[4]));
					newenergyD.setCount(Integer.valueOf(productAttributes[5]));
					eDrinkArray.add(newenergyD);
					InventoryName.add(newenergyD);
					break;
				case "Soda":
					soda newSoda = new soda();
					newSoda.setName(productAttributes[1]);
					newSoda.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newSoda.setWeight(Double.valueOf(productAttributes[3]));
					newSoda.setFlavor(Boolean.valueOf(productAttributes[4]));
					newSoda.setCount(Integer.valueOf(productAttributes[5]));
					sodaArray.add(newSoda);
					InventoryName.add(newSoda);
					break;
				case "Gum":
					Gum newGum = new Gum();
					newGum.setName(productAttributes[1]);
					newGum.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newGum.setWeight(Double.valueOf(productAttributes[3]));
					newGum.setFlavor(Boolean.valueOf(productAttributes[4]));
					newGum.setCount(Integer.valueOf(productAttributes[5]));
					gumArray.add(newGum);
					InventoryName.add(newGum);
					break;
				case "Chips":
					Chips newChips = new Chips();
					newChips.setName(productAttributes[1]);
					newChips.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newChips.setWeight(Double.valueOf(productAttributes[3]));
					newChips.setFlavor(Boolean.valueOf(productAttributes[4]));
					newChips.setCount(Integer.valueOf(productAttributes[5]));
					chipsArray.add(newChips);
					InventoryName.add(newChips);
					break;
				case "Candy":
					Candy newCandy = new Candy();
					newCandy.setName(productAttributes[1]);
					newCandy.setPrice(Double.valueOf(productAttributes[2].substring(1, productAttributes[2].toString().length())));
					newCandy.setWeight(Double.valueOf(productAttributes[3]));
					newCandy.setFlavor(Boolean.valueOf(productAttributes[4]));
					newCandy.setCount(Integer.valueOf(productAttributes[5]));
					candyArray.add(newCandy);
					InventoryName.add(newCandy);
					break;
				}
			}
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sortArray()
	{
		InventoryName.sort(Comparator.comparing(Product::getName));
		coffeeArray.sort(Comparator.comparing(coffee::getName));
		eDrinkArray.sort(Comparator.comparing(energyDrinks::getName));
		candyArray.sort(Comparator.comparing(Candy::getName));
		waterArray.sort(Comparator.comparing(water::getName));
		chipsArray.sort(Comparator.comparing(Chips::getName));
		sodaArray.sort(Comparator.comparing(soda::getName));
		gumArray.sort(Comparator.comparing(Gum::getName));
		
		for(coffee newCoff : coffeeArray)
		{
			System.out.println(newCoff.arrayPrint());
		}
		for(energyDrinks newEDrink : eDrinkArray)
		{
			System.out.println(newEDrink.arrayPrint());
		}
		for(soda newSoda : sodaArray)
		{
			System.out.println(newSoda.arrayPrint());
		}
		for(water newWat : waterArray)
		{
			System.out.println(newWat.arrayPrint());
		}
		for(Candy newCandy : candyArray)
		{
			System.out.println(newCandy.arrayPrint());
		}
		for(Chips newChip : chipsArray)
		{
			System.out.println(newChip.arrayPrint());
		}
		for(Gum newGum : gumArray)
		{
			System.out.println(newGum.arrayPrint());
		}
	}
	
	public void searchArray(String searchPiece) throws FileNotFoundException
	{
		boolean coffeeExists = false;
		boolean edExists = false;
		boolean sodaExists = false;
		boolean waterExists = false;
		boolean gumExists = false;
		boolean chipsExist = false;
		boolean candyExists = false;
		PrintWriter writer = new PrintWriter("callStack.txt");
		for(coffee coffeeItem : coffeeArray)
		{
			//string toCheck = test.name.indexOf(searchPiece);
			writer.println(coffeeItem.name + coffeeItem.amount);
			if(coffeeItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of coffees and there are " + coffeeItem.amount + " in our inventory");
				coffeeExists = true;
				break;				
			}
		}
		for(energyDrinks eDrink : eDrinkArray)
		{
			writer.println(eDrink.name + eDrink.amount);
			if(eDrink.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of energy drinks and there are " + eDrink.amount + " in our inventory");
				edExists = true;
				break;
			}
		}
		for(soda sodaItem : sodaArray)
		{
			writer.println(sodaItem.name + sodaItem.amount);
			if(sodaItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of sodas and there are " + sodaItem.amount + " in our inventory");
				sodaExists = true;
				break;
			}
		}
		for(water waterItem : waterArray)
		{
			writer.println(waterItem.name + waterItem.amount);
			if(waterItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of waters and there are " + waterItem.amount + " in our inventory");
				waterExists = true;
				break;
			}
		}
		for(Gum gumItem: gumArray)
		{
			writer.println(gumItem.name + gumItem.amount);
			if(gumItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of chewing gum");
				gumExists = true;
				break;
			}
		}
		for(Candy candyItem : candyArray)
		{
			writer.println(candyItem.name + candyItem.amount);
			if(candyItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of candy");
				candyExists = true;
				break;
			}
		}
		for(Chips chipItem : chipsArray)
		{
			writer.println(chipItem.name + chipItem.amount);
			if(chipItem.name.contains(searchPiece))
			{
				System.out.println(searchPiece + " is in our selection of chips");
				chipsExist = true;
				break;
			}
		}
		if(coffeeExists == false && edExists == false && sodaExists == false && waterExists == false && gumExists == false && chipsExist == false && candyExists == false)
		{
			System.out.println(searchPiece + " is not in our selection of coffees");
		}
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
