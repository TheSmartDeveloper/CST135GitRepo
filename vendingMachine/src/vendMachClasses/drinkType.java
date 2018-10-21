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

public class drinkType
{
	Scene drinkType;
	GridPane drinkTypePane;
	Stage PrimaryStage;
	public drinkType(Stage PrimaryStage)
	{
		drinkTypePane = new GridPane();
		drinkType = new Scene(drinkTypePane);
	}
	public void build()
	{
		drinkTypePane.setAlignment(Pos.CENTER);
		drinkTypePane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		drinkTypePane.setHgap(5.5);
		drinkTypePane.setVgap(5.5);
		
		Button Coffee = new Button("Coffee");
		drinkTypePane.add(Coffee, 1, 1);
		
		Button Water = new Button("Water");
		drinkTypePane.add(Water, 2, 1);
		
		Button energyDrinks = new Button("Energy Drinks");
		drinkTypePane.add(energyDrinks, 3, 1);
		
		Button Soda = new Button("Soda");
		drinkTypePane.add(Soda, 4, 1);
		
		/*Coffee.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				//Create, build, and show Scene 2
				PrimaryStage.setHeight(288);
				PrimaryStage.setWidth(512);
				PrimaryStage.show();
			}
		});*/
	}
	
	public void show()
	{
		PrimaryStage.setScene(drinkType);
	}
}
