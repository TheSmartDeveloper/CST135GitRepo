package vendMachClasses;
public class VendMain
{

	public static void main(String[] args)			//main method declared
	{
		Dispenser machineOne = new Dispenser();			//Dispenser object created
		Candy snickers = new Candy(1.00, "Snickers", 2.35, true);		//candy object created
		Candy snickersXtreme = new Candy(2.00, "Snickers Xtreme", 2.35, true);		//candy object created
		Chips doritos = new Chips(1.00, "Doritos", 5.75, true);		//chips object created
		Gum trident = new Gum(.75, "Trident", .5, true);		//gum object created
		
		energyDrinks redBull = new energyDrinks(2.00, "Red Bull", 5, true);		//energy Drink object created
		water dasani = new water(2.50, "Dasani", 17.09, true);		//water object created
		soda pepsi = new soda(1.00, "Pepsi", 7.98, true);		//soda object created
		coffee starbucks = new coffee(3.00, "Starbucks", 8.90, true);		//coffee object created
		machineOne.loadMachine(1, 1, doritos);					//load an item into dispenser
		machineOne.loadMachine(2, 5, snickersXtreme);
		machineOne.displayProducts();					//display the products in the dispenser (displayProducts array printed)
		
		snickers.comparedTo(doritos, snickers);
		snickers.comparedTo(snickers, snickersXtreme);


	}

}
