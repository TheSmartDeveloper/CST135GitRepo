package vendMachClasses;
import java.time.Duration;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
public class VendMain extends Application
{

	public int dispenseCheck = 0;
	public double priceCheck = 0.0;
	public void start(Stage primaryStage) throws Exception
	{
		//ALL GRIDS & SCENES CREATION
		
		TranslateTransition test = new TranslateTransition();		//animation method created
		StackPane root = new StackPane();	//created to show message above gridpane
		GridPane drinkSnackSelector = new GridPane();
		Pane pane1 = new Pane();		//pane that label will exist on
		Label Rules = new Label("Total number of one item that can be purchased is 10");
		Rules.setAlignment(Pos.CENTER);
		pane1.getChildren().add(Rules);
		root.getChildren().addAll(pane1,drinkSnackSelector);
		Scene selectItem = new Scene(root);
		
		GridPane drinkPane = new GridPane();
		Scene getDrink = new Scene(drinkPane);
		
		
		GridPane snackPane = new GridPane();
		Scene getSnack = new Scene(snackPane);
		
		GridPane totalPane = new GridPane();
		Scene totalScene = new Scene(totalPane);
		
		transaction updateTotal = new transaction();
		
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
		
		//TOTAL PANE - PART 1
		totalPane.setAlignment(Pos.CENTER);
		totalPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		totalPane.setHgap(5.5);
		totalPane.setVgap(5.5);
		Label TotalItems = new Label("Total Items: ");
		Label TotalPrice = new Label("Total Price: ");
		Label ITotal = new Label(" ");
		Label PTotal = new Label(" ");
		totalPane.add(TotalItems, 1, 1);
		totalPane.add(TotalPrice, 1, 2);
		totalPane.add(ITotal, 2, 1);
		totalPane.add(PTotal, 2, 2);
		//String[][] totalArray = new String[10][10];
		
		Button backFromTotal = new Button("Back");
		totalPane.add(backFromTotal, 1, 3);
		backFromTotal.setOnAction(e -> primaryStage.setScene(selectItem));
		
		Button purchase = new Button("Purchase");
		totalPane.add(purchase, 1, 4);
		
		Button cancel = new Button("Cancel");
		totalPane.add(cancel, 1, 5);
		
		//DRINK SELECTION
		
		drinkPane.setAlignment(Pos.CENTER);
		drinkPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		drinkPane.setHgap(5.5);
		drinkPane.setVgap(5.5);
						
		coffee SbCarmFrap = new coffee(1.5, "Starbucks Carmel Frappucinno", 8.0, true);
		Button sbCarmFrap = new Button(SbCarmFrap.toPrint());
		sbCarmFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCarmFrap, 1, 1);
		Dispenser sbcmf_D = new Dispenser();
		sbCarmFrap.setOnAction(e-> 
		{
			sbcmf_D.dispenseItem();			//bring count down
			if(sbcmf_D.getCount() >= 0)		//only update totals if there are more than 0 items in the vending machine
			{
				updateTotal.setItems();
				updateTotal.setPrice(SbCarmFrap.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);		//move button down
			test.setAutoReverse(true);		//bring button back up after going down
			test.setCycleCount(2);		//essentially go down then back up (each is one cycle)
			test.setNode(sbCarmFrap);		//act on button
			test.play();		//play the animation
		});
		
		coffee SbCoffFrap = new coffee(1.25, "Starbucks Coffee Frappucinno", 8.0, true);
		Button sbCoffFrap = new Button(SbCoffFrap.toPrint());
		sbCoffFrap.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbCoffFrap, 1, 2);
		Dispenser sbcf_D = new Dispenser();
		sbCoffFrap.setOnAction(e-> 
		{
			sbcf_D.dispenseItem();			//bring count down
			if(sbcf_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(SbCoffFrap.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(sbCoffFrap);
			test.play();
		});
		
		coffee SbPSL = new coffee(2.25, "Starbucks Pumpkin Spice Latte", 8.0, true);
		Button sbPSL = new Button(SbPSL.toPrint());
		sbPSL.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbPSL, 1, 3);
		Dispenser sbpsl_D = new Dispenser();
		sbPSL.setOnAction(e-> 
		{
			sbpsl_D.dispenseItem();			//bring count down
			if(sbpsl_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(SbPSL.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(sbPSL);
			test.play();
		});
		
		coffee SbColBru = new coffee(.85, "Starbucks Cold Brew Black", 8.0, true);
		Button sbColBru = new Button(SbColBru.toPrint());
		sbColBru.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(sbColBru, 1, 4);
		Dispenser sbcb_D = new Dispenser();
		sbColBru.setOnAction(e-> 
		{
			sbcb_D.dispenseItem();			//bring count down
			if(sbcb_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(SbColBru.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(sbColBru);
			test.play();
		});
						
		water dasani = new water(1.0, "Dasani", 16.9, true);
		Button Dasani = new Button(dasani.toPrint());
		Dasani.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Dasani, 2, 1);
		Dispenser dasani_D = new Dispenser();
		Dasani.setOnAction(e-> 
		{
			dasani_D.dispenseItem();			//bring count down
			if(dasani_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(dasani.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Dasani);
			test.play();
		});
		
		water aquafina = new water(1.0, "Aquafina", 16.9, true);
		Button Aquafina = new Button(aquafina.toPrint());
		Aquafina.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Aquafina, 2, 2);
		Dispenser aquaf_D = new Dispenser();
		Aquafina.setOnAction(e-> 
		{
			aquaf_D.dispenseItem();			//bring count down
			if(aquaf_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(aquafina.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Aquafina);
			test.play();
		});
		
		water kirkland = new water(.75, "Kirkland Signature", 16.9, true);
		Button Kirkland = new Button(kirkland.toPrint());
		Kirkland.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Kirkland, 2, 3);
		Dispenser kirk_D = new Dispenser();
		Kirkland.setOnAction(e-> 
		{
			kirk_D.dispenseItem();			//bring count down
			if(kirk_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(kirkland.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Kirkland);
			test.play();
		});
		
		water memMark = new water(1.0, "Memeber's Mark", 16.9, true);
		Button MemMark = new Button(memMark.toPrint());
		MemMark.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(MemMark, 2, 4);
		Dispenser memMark_D = new Dispenser();
		MemMark.setOnAction(e-> 
		{
			memMark_D.dispenseItem();			//bring count down
			if(memMark_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(memMark.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(MemMark);
			test.play();
		});
						
		energyDrinks Monster = new energyDrinks(2.0, "Monster", 10, true);
		Button monster = new Button(Monster.toPrint());
		monster.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(monster, 3, 1);
		Dispenser monster_D = new Dispenser();
		monster.setOnAction(e-> 
		{
			monster_D.dispenseItem();			//bring count down
			if(monster_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(Monster.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(monster);
			test.play();
		});
		
		energyDrinks RedBull = new energyDrinks(2.50, "Red Bull", 10, true);
		Button redBull = new Button(RedBull.toPrint());
		redBull.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(redBull, 3, 2);
		Dispenser redB_D = new Dispenser();
		redBull.setOnAction(e-> 
		{
			redB_D.dispenseItem();			//bring count down
			if(redB_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(RedBull.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(redBull);
			test.play();
		});
		
		energyDrinks FHE = new energyDrinks(2.50, "Five Hour Energy", 2, true);
		Button fiveHourE = new Button(FHE.toPrint());
		fiveHourE.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(fiveHourE, 3, 3);
		Dispenser fhe_D = new Dispenser();
		fiveHourE.setOnAction(e-> 
		{
			fhe_D.dispenseItem();			//bring count down
			if(fhe_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(FHE.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(fiveHourE);
			test.play();
		});
		
		energyDrinks AMP = new energyDrinks(1.50, "AMP", 10, true);
		Button amp = new Button(AMP.toPrint());
		amp.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(amp, 3, 4);
		Dispenser amp_D = new Dispenser();
		amp.setOnAction(e-> 
		{
			amp_D.dispenseItem();			//bring count down
			if(amp_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(AMP.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(amp);
			test.play();
		});
						
		soda cocaC = new soda(1.50, "Coca Cola", 8, true);
		Button CocaCola = new Button(cocaC.toPrint());
		CocaCola.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(CocaCola, 4, 1);
		Dispenser cc_D = new Dispenser();
		CocaCola.setOnAction(e-> 
		{
			cc_D.dispenseItem();			//bring count down
			if(cc_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(cocaC.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(CocaCola);
			test.play();
		});
		
		soda sprite = new soda(1.50, "Sprite", 8, true);
		Button Sprite = new Button(sprite.toPrint());
		Sprite.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Sprite, 4, 2);
		Dispenser sprite_D = new Dispenser();
		Sprite.setOnAction(e-> 
		{
			sprite_D.dispenseItem();			//bring count down
			if(sprite_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(sprite.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Sprite);
			test.play();
		});
		
		soda fanta = new soda(1.25, "Fanta", 8, true);
		Button Fanta = new Button(fanta.toPrint());
		Fanta.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Fanta, 4, 3);
		Dispenser fanta_D = new Dispenser();
		Fanta.setOnAction(e-> 
		{
			fanta_D.dispenseItem();			//bring count down
			if(fanta_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(fanta.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Fanta);
			test.play();
		});
		
		soda pepsi = new soda(1.50, "Pepsi", 8, true);
		Button Pepsi = new Button(pepsi.toPrint());
		Pepsi.setMaxWidth(Double.MAX_VALUE);
		drinkPane.add(Pepsi, 4, 4);
		Dispenser pepsi_D = new Dispenser();
		Pepsi.setOnAction(e-> 
		{
			pepsi_D.dispenseItem();			//bring count down
			if(pepsi_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(pepsi.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Pepsi);
			test.play();
		});
		
		/*Label Limit = new Label("The total number of items that you are allowed to purchase at one time is 10");
		drinkPane.add(Limit, 1, 5);*/
				
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
		Dispenser five_D = new Dispenser();
		Five.setOnAction(e-> 
		{
			five_D.dispenseItem();			//bring count down
			if(five_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(five.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Five);
			test.play();
		});
		
		
		Gum orbit = new Gum(.75, "Orbit", 1, true);
		Button Orbit = new Button(orbit.toPrint());
		Orbit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Orbit, 1, 2);
		Dispenser orbit_D = new Dispenser();
		Orbit.setOnAction(e-> 
		{
			orbit_D.dispenseItem();			//bring count down
			if(orbit_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(orbit.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Orbit);
			test.play();
		});
		
		Gum juicyFruit = new Gum(.75, "Juicy Fruit", 1, true);
		Button JFruit = new Button(juicyFruit.toPrint());
		JFruit.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(JFruit, 1, 3);
		Dispenser juicyFruit_D = new Dispenser();
		JFruit.setOnAction(e-> 
		{
			juicyFruit_D.dispenseItem();			//bring count down
			if(juicyFruit_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(juicyFruit.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(JFruit);
			test.play();
		});
						
		Chips lays = new Chips(1.00, "Lays", 2.21, true);
		Button Lays = new Button(lays.toPrint());
		Lays.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Lays, 2, 1);
		Dispenser lays_D = new Dispenser();
		Lays.setOnAction(e-> 
		{
			lays_D.dispenseItem();			//bring count down
			if(lays_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(lays.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Lays);
			test.play();
		});
		
		Chips doritos = new Chips(1.00, "Doritos", 2.18, true);
		Button Doritos = new Button(doritos.toPrint());
		Doritos.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Doritos, 2, 2);
		Dispenser doritos_D = new Dispenser();
		Doritos.setOnAction(e-> 
		{
			doritos_D.dispenseItem();			//bring count down
			if(doritos_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(doritos.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Doritos);
			test.play();
		});
		
		Chips ruffles = new Chips(1.00, "Ruffles", 2.05, true);
		Button Ruffles = new Button(ruffles.toPrint());
		Ruffles.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Ruffles, 2, 3);
		Dispenser ruffles_D = new Dispenser();
		Ruffles.setOnAction(e-> 
		{
			ruffles_D.dispenseItem();			//bring count down
			if(ruffles_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(ruffles.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Ruffles);
			test.play();
		});
						
		Candy snickers = new Candy(1.00, "Snickers", 2.35, true);
		Button Snickers = new Button(snickers.toPrint());
		Snickers.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Snickers, 3, 1);
		Dispenser snickers_D = new Dispenser();
		Snickers.setOnAction(e-> 
		{
			snickers_D.dispenseItem();			//bring count down
			if(snickers_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(snickers.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Snickers);
			test.play();
		});
		
		Candy MMS = new Candy(1.25,"M&M's", 2.44, true);
		Button mms = new Button(MMS.toPrint());
		mms.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(mms, 3, 2);
		Dispenser mms_D = new Dispenser();
		mms.setOnAction(e-> 
		{
			mms_D.dispenseItem();			//bring count down
			if(mms_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(MMS.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(mms);
			test.play();
		});
		
		Candy reeses = new Candy(1.25,"Reeses", 2.44, true);
		Button Reeses = new Button(reeses.toPrint());
		Dispenser reeses_D = new Dispenser();
		Reeses.setMaxWidth(Double.MAX_VALUE);
		snackPane.add(Reeses, 3, 3);
		Reeses.setOnAction(e-> 
		{
			reeses_D.dispenseItem();			//bring count down
			if(reeses_D.getCount() >= 0)
			{
				updateTotal.setItems();
				updateTotal.setPrice(reeses.price);
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			test.setToY(500);
			test.setAutoReverse(true);
			test.setCycleCount(2);
			test.setNode(Reeses);
			test.play();
		});	
						
		Button backFromSnacks = new Button("Back");
		snackPane.add(backFromSnacks, 5, 1);
		backFromSnacks.setOnAction(e -> primaryStage.setScene(selectItem));
		
		Button doneWithSnacks = new Button("Done");
		snackPane.add(doneWithSnacks, 5, 2);
		doneWithSnacks.setOnAction(e -> primaryStage.setScene(totalScene));
		
		//TOTAL PANE - PART 2
		purchase.setOnAction(e ->
		{
			updateTotal.resetIandP();
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
		});
		cancel.setOnAction(e ->
		{
			updateTotal.resetIandP();
			sbcmf_D.loadMachine();
			sbcf_D.loadMachine();
			sbpsl_D.loadMachine();
			sbcb_D.loadMachine();
			dasani_D.loadMachine();
			aquaf_D.loadMachine();
			kirk_D.loadMachine();
			memMark_D.loadMachine();
			monster_D.loadMachine();
			redB_D.loadMachine();
			fhe_D.loadMachine();
			amp_D.loadMachine();
			cc_D.loadMachine();
			sprite_D.loadMachine();
			fanta_D.loadMachine();
			pepsi_D.loadMachine();
			five_D.loadMachine();
			orbit_D.loadMachine();
			juicyFruit_D.loadMachine();
			lays_D.loadMachine();
			doritos_D.loadMachine();
			ruffles_D.loadMachine();
			snickers_D.loadMachine();
			mms_D.loadMachine();
			reeses_D.loadMachine();
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
		});
		
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
		 * 
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
