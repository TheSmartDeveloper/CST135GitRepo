package vendMachClasses;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class VendMain extends Application
{

	public void start(Stage primaryStage) throws Exception
	{
		//ALL GRIDS & SCENES CREATION
		
		GridPane drinkSnackSelector = new GridPane();
		Scene selectItem = new Scene(drinkSnackSelector);
		
		GridPane drinkPane = new GridPane();
		Scene getDrink = new Scene(drinkPane);
		
		
		GridPane snackPane = new GridPane();
		Scene getSnack = new Scene(snackPane);
		
		GridPane totalPane = new GridPane();
		Scene totalScene = new Scene(totalPane);
		
		//MAIN SELECTION
		
		drinkSnackSelector.setAlignment(Pos.CENTER);
		drinkSnackSelector.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		drinkSnackSelector.setHgap(5.5);
		drinkSnackSelector.setVgap(5.5);
		
		
		Button Drinks = new Button("Drinks");
		drinkSnackSelector.add(Drinks, 1, 1);
		Drinks.setOnAction(e -> primaryStage.setScene(getDrink));
				
		Button Snacks = new Button("Snacks");
		drinkSnackSelector.add(Snacks, 2, 1);
		Snacks.setOnAction(e -> primaryStage.setScene(getSnack));
		
		Button Service = new Button("Service Mode");
		drinkSnackSelector.add(Service, 3, 1);
		
		drinkSnackSelector.add(new Label("Total"), 4, 1);
		
		//DRINK SELECTION
		
		drinkPane.setAlignment(Pos.CENTER);
		drinkPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		drinkPane.setHgap(5.5);
		drinkPane.setVgap(5.5);
						
		Button sbCarmFrap = new Button("Starbucks Carmel Frappucinno");
		sbCarmFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCarmFrap, 1, 1);
		
		Button sbCoffFrap = new Button("Starbucks Coffee Frappucinno");
		sbCoffFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCoffFrap, 1, 2);
		
		Button sbPSL = new Button("Starbucks Pumpkin Spice Latte");
		sbPSL.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbPSL, 1, 3);
		
		Button sbColBru = new Button("Starbucks Cold Brew Black");
		sbColBru.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbColBru, 1, 4);
						
		Button Dasani = new Button("Dasani");
		Dasani.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Dasani, 2, 1);
		
		Button Aquafina = new Button("Aquafina");
		Aquafina.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Aquafina, 2, 2);
		
		Button Kirkland = new Button("Kirkland Signature");
		Kirkland.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Kirkland, 2, 3);
		
		Button MemMark = new Button("Memebers Marks");
		MemMark.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(MemMark, 2, 4);
						
		Button monster = new Button("Monster");
		monster.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(monster, 3, 1);
		
		Button redBull = new Button("Red Bull");
		redBull.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(redBull, 3, 2);
		
		Button fiveHourE = new Button("Five Hour Energy");
		fiveHourE.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(fiveHourE, 3, 3);
		
		Button amp = new Button("AMP");
		amp.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(amp, 3, 4);
						
		Button CocaCola = new Button("Coca Cola");
		CocaCola.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(CocaCola, 4, 1);
		
		Button Sprite = new Button("Sprite");
		Sprite.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Sprite, 4, 2);
		
		Button Fanta = new Button("Fanta");
		Fanta.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Fanta, 4, 3);
		
		Button Pepsi = new Button("Pepsi");
		Pepsi.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Pepsi, 4, 4);
				
		Button backFromDrinks = new Button("Back");
		drinkPane.add(backFromDrinks, 5, 1);
		backFromDrinks.setOnAction(e -> primaryStage.setScene(selectItem));
		
		//SNACK SELECTION
		
		snackPane.setAlignment(Pos.CENTER);
		snackPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		snackPane.setHgap(5.5);
		snackPane.setVgap(5.5);
		
		Button Five = new Button("Five");
		Five.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Five, 1, 1);
		
		Button Orbit = new Button("Orbit");
		Orbit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Orbit, 1, 2);
		
		Button JFruit = new Button("Juicy Fruit");
		JFruit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(JFruit, 1, 3);
						
		Button Lays = new Button("Lays");
		Lays.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Lays, 2, 1);
		
		Button Doritos = new Button("Doritos");
		Doritos.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Doritos, 2, 2);
		
		Button Ruffles = new Button("Ruffles");
		Ruffles.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Ruffles, 2, 3);
						
		Button Snickers = new Button("Snickers");
		Snickers.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Snickers, 3, 1);
		
		Button mms = new Button("M&M's");
		mms.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(mms, 3, 2);
		
		Button Reeses = new Button("Reeses");
		Reeses.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Reeses, 3, 3);
						
		Button backFromSnacks = new Button("Back");
		snackPane.add(backFromSnacks, 5, 1);
		backFromSnacks.setOnAction(e -> primaryStage.setScene(selectItem));
		
		//RUN THE WHOLE THING
		
		primaryStage.setTitle("Vending Machine");
		primaryStage.setScene(selectItem);
		primaryStage.setHeight(576);
		primaryStage.setWidth(1024);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)			//main method declared
	{
		launch(args);
		
		/*Dispenser machineOne = new Dispenser();			//Dispenser object created
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
		snickers.comparedTo(snickers, snickersXtreme);*/


	}

}
