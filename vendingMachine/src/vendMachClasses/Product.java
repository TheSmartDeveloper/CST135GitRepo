package vendMachClasses;
import java.util.*;

abstract public class Product implements Comparable										//abstract class product where the food and drinks will inherit properties from
{
	String name;											//name and price var created since every product will have these
	double price;
	
	public Product()												//default constructor
	{
		
	}
	
	public Product(String productName, double productPrice)			//overloaded constructor, name and price pre-assigned
	{
		this.name = productName;
		this.price = productPrice;
	}
	public void setName(String productName)							//set & get method so that product names can be changed
	{
		this.name = productName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPrice(double productPrice)						//set & get method so that product prices can be changed
	{
		this.price = productPrice;
	}
	
	public double getPrice()
	{
		return price;
	}
	public String toPrint()										//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	
}
//----------SNACK BITS----------//
abstract class Snack extends Product										//abstract class Snack where the food will inherit more properties from
{
	double ounces;															//ounces var created since every snack will have these
	public Snack()															//default constructor
	{
		
	}
	public Snack(double price, String name, double snackWeight)				//overloaded constructor, weight pre-assigned, and price, name, and weight passed in
	{
		this.ounces = snackWeight;
	}
	public void setWeight(double snackWeight)								//set & get method so that product weights can be changed
	{
		this.ounces = snackWeight;
	}
	public double getWeight()
	{
		return ounces;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return "Weight is: " + getWeight();
	}
}

class Candy extends Snack													//Class candy for candy products only
{
	boolean sweet = true;													//boolean var to guarantee that the user is purchasing a candy
	int amount = 0;
	public Candy()															//default constructor
	{
		
	}
	public Candy(double price, String name, double snackWeight, boolean flavor)		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.sweet = flavor;
		this.name = name;
		this.price = price;
		this.ounces = snackWeight; 
	}
	public void setFlavor(boolean flavor)									//set & get method so that product flavors can be changed
	{
		this.sweet = flavor;
	}
	public boolean getFlavor()
	{
		return sweet;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	//@Override
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Candy," + getName().toString() + ",$" + getPrice() + "," + getWeight() + "," + getFlavor();
	}
}

class Chips extends Snack													//Class chips for chips products only
{
	boolean salty = true;													//boolean var to guarantee that the user is purchasing chips
	int amount = 0;
	public Chips()															//default constructor
	{
		
	}
	public Chips(double price, String name, double snackWeight, boolean flavor)		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.salty = flavor;
		this.name = name;
		this.price = price;
		this.ounces = snackWeight;
	}
	public void setFlavor(boolean flavor)									//set & get method so that product flavors can be changed
	{
		this.salty = flavor;
	}
	public boolean getFlavor()
	{
		return salty;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Chips," + getName().toString() + ",$" + getPrice() + "," + getWeight() + "," + getFlavor();
	}
}

class Gum extends Snack													//Class gum for gum products only
{
	boolean chewy = true;													//boolean var to guarantee that the user is purchasing gum
	int amount = 0;
	public Gum()															//default constructor
	{
		
	}
	public Gum(double price, String name, double snackWeight, boolean flavor)		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.chewy = flavor;
		this.name = name;
		this.price = price;
		this.ounces = snackWeight;
	}
	public void setFlavor(boolean flavor)													//boolean var to guarantee that the user is purchasing gum
	{
		this.chewy = flavor;
	}
	public boolean getFlavor()									//set & get method so that product flavors can be changed
	{
		return chewy;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Gum," + getName().toString() + ",$" + getPrice() + "," + getWeight() + "," + getFlavor();
	}
}
//----------DRINK BITS----------//
abstract class Drink extends Product										//abstract class Drink where the drinks will inherit more properties from
{
	double fluidOz;															//fluid ounces var created since every drink will have these
	public Drink()															//default constructor
	{
		
	}
	public Drink(double price, String name, double drinkWeight)				//overloaded constructor, weight pre-assigned, and price, name, and weight are passed in
	{
		this.fluidOz = drinkWeight;
	}
	public void setWeight(double drinkWeight)									//set & get method so that product weights can be changed
	{
		this.fluidOz = drinkWeight;
	}
	public double getDrinkWeight()
	{
		return fluidOz;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return "Weight is: " + getDrinkWeight();
	}
}

class energyDrinks extends Drink												//Class enerrgyDrinks for energy drinks only
{
	boolean crappyTaste = true;													//boolean var to guarantee that the user is purchasing an energy drink
	int amount = 0;
	public energyDrinks()														//default constructor
	{
		
	}
	public energyDrinks(double price, String name, double drinkWeight, boolean drinkFlavor) 		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.crappyTaste = drinkFlavor;
		this.name = name;
		this.price = price;
		this.fluidOz = drinkWeight;
	}
	public void setFlavor(boolean drinkFlavor)									//set & get method so that product flavors can be changed
	{
		this.crappyTaste = drinkFlavor;
	}
	public boolean getFlavor()
	{
		return crappyTaste;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Energy Drink," + getName().toString() + ",$" + getPrice() + "," + getDrinkWeight() + "," + getFlavor();
	}
}

class water extends Drink												//Class water for water only
{
	boolean flat = true;													//boolean var to guarantee that the user is purchasing a water
	int amount = 0;
	public water()														//default constructor
	{
		
	}
	public water(double price, String name, double drinkWeight, boolean drinkFlavor) 		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.flat = drinkFlavor;
		this.name = name;
		this.price = price;
		this.fluidOz = drinkWeight;
	}
	public void setFlavor(boolean drinkFlavor)									//set & get method so that product flavors can be changed
	{
		this.flat = drinkFlavor;
	}
	public boolean getFlavor()
	{
		return flat;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Water," + getName().toString() + ",$" + getPrice() + "," + getDrinkWeight() + "," + getFlavor();
	}
}

class soda extends Drink												//Class soda for soda only
{
	boolean cloying = true;													//boolean var to guarantee that the user is purchasing a soda
	int amount = 0;
	public soda()														//default constructor
	{
		
	}
	public soda(double price, String name, double drinkWeight, boolean drinkFlavor) 		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.cloying = drinkFlavor;
		this.name = name;
		this.price = price;
		this.fluidOz = drinkWeight;
	}
	public void setFlavor(boolean drinkFlavor)									//set & get method so that product flavors can be changed
	{
		this.cloying = drinkFlavor;
	}
	public boolean getFlavor()
	{
		return cloying;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Soda," + getName().toString() + ",$" + getPrice() + "," + getDrinkWeight() + "," + getFlavor();
	}
}

class coffee extends Drink												//Class coffee for coffee only
{
	boolean hyper = true;													//boolean var to guarantee that the user is purchasing a coffee
	int amount = 0;
	public coffee()														//default constructor
	{
		
	}
	public coffee(double price, String name, double drinkWeight, boolean drinkFlavor) 		//overloaded constructor, flavor pre-assigned, and price, name, weight, and flavor are passed in
	{
		this.hyper = drinkFlavor;
		this.name = name;
		this.price = price;
		this.fluidOz = drinkWeight;
	}
	public void setFlavor(boolean drinkFlavor)									//set & get method so that product flavors can be changed
	{
		this.hyper = drinkFlavor;
	}
	public boolean getFlavor()
	{
		return hyper;
	}
	public void setCount(int count)
	{
		int amount = count;
	}
	public int getCount()
	{
		return amount;
	}
	public String toPrint()													//toString method created to print anything necessary
	{
		return getName() + " is $" + getPrice();
	}
	public void comparedTo(Product p1, Product p2)
	{
		int compVal = p1.name.compareTo(p2.name);
		if(compVal < 0 )
		{
			System.out.println(p2.getName() + " is greater than " + p1.getName());
		}
		else if(compVal > 0)
		{
			System.out.println(p1.getName() + " is greater than " + p2.getName());
		}
		else if(compVal == 0)
		{
			if(p1.getPrice() > p2.getPrice())
			{
				System.out.println(p1.getName() + " is greater than " + p2.getName());
			}
			else
			{
				System.out.println(p2.getName() + " is greater than " + p1.getName());
			}
		}
		else
		{
			System.out.println("Something broke");
		}
		
	}
	public String arrayPrint()
	{
		return "Coffee," + getName().toString() + ",$" + getPrice() + "," + getDrinkWeight() + "," + getFlavor();
	}
}