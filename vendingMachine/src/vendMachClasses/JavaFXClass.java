package vendMachClasses;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JavaFXClass extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//initial page
				GridPane drinkSnackSelector = new GridPane();
				drinkSnackSelector.setAlignment(Pos.CENTER);
				drinkSnackSelector.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				drinkSnackSelector.setHgap(5.5);
				drinkSnackSelector.setVgap(5.5);
						
				Button Drinks = new Button("Drinks");
				drinkSnackSelector.add(Drinks, 1, 1);
						
				Button Snacks = new Button("Snacks");
				drinkSnackSelector.add(Snacks, 2, 1);
						
				Scene drinkSnackscene = new Scene(drinkSnackSelector);
				
				primaryStage.setTitle("Vending Machine");
				primaryStage.setScene(drinkSnackscene);
				primaryStage.show();
				
				//initial page
				GridPane drinksPane = new GridPane();
				drinksPane.setAlignment(Pos.CENTER);
				drinksPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				drinksPane.setHgap(5.5);
				drinksPane.setVgap(5.5);
				
				Button soda = new Button("Soda");
				Button coffee = new Button("Coffee");
				Button water = new Button("Water");
				Button energyDrinks = new Button("Energy Drinks");
				drinksPane.add(soda, 1, 1);
				drinksPane.add(coffee, 1, 2);
				drinksPane.add(water, 1, 3);
				drinksPane.add(energyDrinks, 1, 4);
				
				Scene chooseDrinks = new Scene(drinksPane);
				
				Drinks.setOnAction(e -> primaryStage.setScene(chooseDrinks));
				
				//snacks scene
				GridPane snacksPane = new GridPane();
				snacksPane.setAlignment(Pos.CENTER);
				snacksPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				snacksPane.setHgap(5.5);
				snacksPane.setVgap(5.5);
				
				Button gum = new Button("Gum");
				Button chips = new Button("Chips");
				Button candy = new Button("Candy");
				snacksPane.add(gum, 1, 1);
				snacksPane.add(chips, 1, 2);
				snacksPane.add(candy, 1, 3);
				
				Scene chooseSnacks = new Scene(snacksPane);
				
				Snacks.setOnAction(e -> primaryStage.setScene(chooseSnacks));
		
	}

}
