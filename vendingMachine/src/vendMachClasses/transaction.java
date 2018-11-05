package vendMachClasses;

public class transaction
{
	double totalPrice = 0;
	int totalItems = 0;
	public transaction()		//default constructor
	{
		
	}
	public transaction(double price, int items)		//overloaded constructor
	{
		this.totalItems = items;
		this.totalPrice = price;
	}
	public void resetIandP()	//reset when purchased or canceled
	{
		totalItems = 0;
		totalPrice = 0;
	}
	public void setItems()		//increment items
	{
		totalItems++;
	}
	public int getItems()		//return items value
	{
		return totalItems;
	}
	public void setPrice(double input)		//add up price
	{
		totalPrice = input + totalPrice;
	}
	public double getPrice()		//return price value
	{
		return totalPrice;
	}
}
