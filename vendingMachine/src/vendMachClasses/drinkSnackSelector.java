package vendMachClasses;

import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;

public class drinkSnackSelector
{
	Scene selectionScene;
	GridPane selectionPane;
	Stage PrimaryStage;
	public drinkSnackSelector(Stage PrimaryStage)
	{
		selectionPane = new GridPane();
		selectionScene = new Scene(selectionPane);
	}
	public void build()
	{
		selectionPane.setAlignment(Pos.CENTER);
		selectionPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		selectionPane.setHgap(5.5);
		selectionPane.setVgap(5.5);
		
		Button Drinks = new Button("Drinks");
		selectionPane.add(Drinks, 1, 1);
				
		Button Snacks = new Button("Snacks");
		selectionPane.add(Snacks, 2, 1);
		
		Button Service = new Button("Service Mode");
		selectionPane.add(Service, 3, 1);
		
		Drinks.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				//Create, build, and show Scene 2
				PrimaryStage.setHeight(288);
				PrimaryStage.setWidth(512);
				PrimaryStage.show();
			}
		});
	}
	
	public void show()
	{
		PrimaryStage.setScene(selectionScene);
	}
}
/*class theStage
{
	public Scene getDrink()
	{
		GridPane drinkPane = new GridPane();
		drinkPane.setAlignment(Pos.CENTER);
		drinkPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		drinkPane.setHgap(5.5);
		drinkPane.setVgap(5.5);
		
		Button Coffee = new Button("Coffee");
		drinkPane.add(Coffee, 1, 1);
		
		Button Water = new Button("Water");
		drinkPane.add(Water, 2, 1);
		
		Button energyDrinks = new Button("Energy Drinks");
		drinkPane.add(energyDrinks, 3, 1);
		
		Button Soda = new Button("Soda");
		drinkPane.add(Soda, 4, 1);
		
		Scene getDrink = new Scene(drinkPane);
		return getDrink;
	}
}*/