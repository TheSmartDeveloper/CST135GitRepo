package vendMachClasses;

public class transaction
{
	double totalPrice = 0;
	int totalItems = 0;
	public transaction()
	{
		
	}
	public transaction(double price, int items)
	{
		this.totalItems = items;
		this.totalPrice = price;
	}
	public void resetIandP()
	{
		totalItems = 0;
		totalPrice = 0;
	}
	public void setItems()
	{
		totalItems++;
	}
	public int getItems()
	{
		return totalItems;
	}
	public void setPrice(double input)
	{
		totalPrice = input + totalPrice;
	}
	public double getPrice()
	{
		return totalPrice;
	}
}
