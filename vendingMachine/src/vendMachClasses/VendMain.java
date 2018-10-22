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
						
		coffee SbCarmFrap = new coffee(1.5, "Starbucks Carmel Frappucinno", 8.0, true);
		Button sbCarmFrap = new Button(SbCarmFrap.toPrint());
		sbCarmFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCarmFrap, 1, 1);
		
		coffee SbCoffFrap = new coffee(1.25, "Starbucks Coffee Frappucinno", 8.0, true);
		Button sbCoffFrap = new Button(SbCoffFrap.toPrint());
		sbCoffFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCoffFrap, 1, 2);
		
		coffee SbPSL = new coffee(2.25, "Starbucks Pumpkin Spice Latte", 8.0, true);
		Button sbPSL = new Button(SbPSL.toPrint());
		sbPSL.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbPSL, 1, 3);
		
		coffee SbColBru = new coffee(.85, "Starbucks Cold Brew Black", 8.0, true);
		Button sbColBru = new Button(SbColBru.toPrint());
		sbColBru.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbColBru, 1, 4);
						
		water dasani = new water(1.0, "Dasani", 16.9, true);
		Button Dasani = new Button(dasani.toPrint());
		Dasani.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Dasani, 2, 1);
		
		water aquafina = new water(1.0, "Aquafina", 16.9, true);
		Button Aquafina = new Button(aquafina.toPrint());
		Aquafina.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Aquafina, 2, 2);
		
		water kirkland = new water(.75, "Kirkland Signature", 16.9, true);
		Button Kirkland = new Button(kirkland.toPrint());
		Kirkland.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Kirkland, 2, 3);
		
		water memMark = new water(1.0, "Memebers Marks", 16.9, true);
		Button MemMark = new Button(memMark.toPrint());
		MemMark.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(MemMark, 2, 4);
						
		energyDrinks Monster = new energyDrinks(2.0, "Monster", 10, true);
		Button monster = new Button(Monster.toPrint());
		monster.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(monster, 3, 1);
		
		energyDrinks RedBull = new energyDrinks(2.50, "Red Bull", 10, true);
		Button redBull = new Button(RedBull.toPrint());
		redBull.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(redBull, 3, 2);
		
		energyDrinks FHE = new energyDrinks(2.50, "Five Hour Energy", 2, true);
		Button fiveHourE = new Button(FHE.toPrint());
		fiveHourE.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(fiveHourE, 3, 3);
		
		energyDrinks AMP = new energyDrinks(1.50, "AMP", 10, true);
		Button amp = new Button(AMP.toPrint());
		amp.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(amp, 3, 4);
						
		soda cocaC = new soda(1.50, "Coca Cola", 8, true);
		Button CocaCola = new Button(cocaC.toPrint());
		CocaCola.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(CocaCola, 4, 1);
		
		soda sprite = new soda(1.50, "Sprite", 8, true);
		Button Sprite = new Button(sprite.toPrint());
		Sprite.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Sprite, 4, 2);
		
		soda fanta = new soda(1.25, "Fanta", 8, true);
		Button Fanta = new Button(fanta.toPrint());
		Fanta.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Fanta, 4, 3);
		
		soda pepsi = new soda(1.50, "Pepsi", 8, true);
		Button Pepsi = new Button(pepsi.toPrint());
		Pepsi.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Pepsi, 4, 4);
				
		Button backFromDrinks = new Button("Back");
		drinkPane.add(backFromDrinks, 5, 1);
		backFromDrinks.setOnAction(e -> primaryStage.setScene(selectItem));
		
		Button doneWithDrinks = new Button("Done");
		drinkPane.add(doneWithDrinks, 5, 2);
		doneWithDrinks.setOnAction(e -> primaryStage.setScene(totalScene));
		
		//SNACK SELECTION
		
		snackPane.setAlignment(Pos.CENTER);
		snackPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		snackPane.setHgap(5.5);
		snackPane.setVgap(5.5);
		
		Gum five = new Gum(.75, "Five", 1, true);
		Button Five = new Button(five.toPrint());
		Five.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Five, 1, 1);
		
		Gum orbit = new Gum(.75, "Orbit", 1, true);
		Button Orbit = new Button(orbit.toPrint());
		Orbit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Orbit, 1, 2);
		
		Gum juicyFruit = new Gum(.75, "Juicy Fruit", 1, true);
		Button JFruit = new Button(juicyFruit.toPrint());
		JFruit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(JFruit, 1, 3);
						
		Chips lays = new Chips(1.00, "Lays", 2.21, true);
		Button Lays = new Button(lays.toPrint());
		Lays.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Lays, 2, 1);
		
		Chips doritos = new Chips(1.00, "Doritos", 2.18, true);
		Button Doritos = new Button(doritos.toPrint());
		Doritos.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Doritos, 2, 2);
		
		Chips ruffles = new Chips(1.00, "Ruffles", 2.05, true);
		Button Ruffles = new Button(ruffles.toPrint());
		Ruffles.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Ruffles, 2, 3);
						
		Candy snickers = new Candy(1.00, "Snickers", 2.35, true);
		Button Snickers = new Button(snickers.toPrint());
		Snickers.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Snickers, 3, 1);
		
		Candy MMS = new Candy(1.25,"M&M's", 2.44, true);
		Button mms = new Button(MMS.toPrint());
		mms.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(mms, 3, 2);
		
		Candy reeses = new Candy(1.25,"Reeses", 2.44, true);
		Button Reeses = new Button(reeses.toPrint());
		Reeses.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Reeses, 3, 3);
						
		Button backFromSnacks = new Button("Back");
		snackPane.add(backFromSnacks, 5, 1);
		backFromSnacks.setOnAction(e -> primaryStage.setScene(selectItem));
		
		Button doneWithSnacks = new Button("Done");
		snackPane.add(doneWithSnacks, 5, 2);
		doneWithSnacks.setOnAction(e -> primaryStage.setScene(totalScene));
		
		//TOTAL PANE
		totalPane.setAlignment(Pos.CENTER);
		totalPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		totalPane.setHgap(5.5);
		totalPane.setVgap(5.5);
		
		totalPane.add(new Label("Total Items: "), 1, 1);
		totalPane.add(new Label("Total Price: "), 1, 2);
		
		Button backFromTotal = new Button("Back");
		totalPane.add(backFromTotal, 1, 3);
		backFromTotal.setOnAction(e -> primaryStage.setScene(selectItem));
		
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
