package vendMachClasses;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.shape.Rectangle; 
import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

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
	String finalInventory = " ";
	public int dispenseCheck = 0;
	public double priceCheck = 0.0;
	public void start(Stage primaryStage) throws Exception
	{
		//ALL GRIDS & SCENES CREATION
		//Global Inventory Manangement Methods
		GlobalInventoryManagement newManager = new GlobalInventoryManagement();
		newManager.pullFromFile();
		newManager.sortArray();
		newManager.searchArray("Dasani");
		
		
		Restock LowOrPO = new Restock();
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
		
		GridPane servicePane = new GridPane();
		Scene serviceScene = new Scene(servicePane);
		
		GridPane demoPane = new GridPane();
		Scene demoScene = new Scene(demoPane);
		
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
		Service.setOnAction(e -> primaryStage.setScene(serviceScene));
		
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
				test.setToY(500);		//move button down
				test.setAutoReverse(true);		//bring button back up after going down
				test.setCycleCount(2);		//essentially go down then back up (each is one cycle)
				test.setNode(sbCarmFrap);		//act on button
				test.play();		//play the animation
				if(sbcmf_D.getCount() <= 3)
				{
					sbCarmFrap.setText(SbCarmFrap.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					sbCarmFrap.setText(SbCarmFrap.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(sbCoffFrap);
				test.play();
				if(sbcf_D.getCount() <= 3)
				{
					sbCoffFrap.setText(SbCoffFrap.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					sbCoffFrap.setText(SbCoffFrap.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(sbPSL);
				test.play();
				if(sbpsl_D.getCount() <= 3)
				{
					sbPSL.setText(SbPSL.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					sbPSL.setText(SbPSL.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(sbColBru);
				test.play();
				if(sbcb_D.getCount() <= 3)
				{
					sbColBru.setText(SbColBru.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					sbColBru.setText(SbColBru.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Dasani);
				test.play();
				if(dasani_D.getCount() <= 3)
				{
					Dasani.setText(dasani.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Dasani.setText(dasani.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Aquafina);
				test.play();
				if(aquaf_D.getCount() <= 3)
				{
					Aquafina.setText(aquafina.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Aquafina.setText(aquafina.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Kirkland);
				test.play();
				if(kirk_D.getCount() <= 3)
				{
					Kirkland.setText(kirkland.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Kirkland.setText(kirkland.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(MemMark);
				test.play();
				if(memMark_D.getCount() <= 3)
				{
					MemMark.setText(memMark.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					MemMark.setText(memMark.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(monster);
				test.play();
				if(monster_D.getCount() <= 3)
				{
					monster.setText(Monster.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					monster.setText(Monster.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(redBull);
				test.play();
				if(redB_D.getCount() <= 3)
				{
					redBull.setText(RedBull.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					redBull.setText(RedBull.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(fiveHourE);
				test.play();
				if(fhe_D.getCount() <= 3)
				{
					fiveHourE.setText(FHE.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					fiveHourE.setText(FHE.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(amp);
				test.play();
				if(amp_D.getCount() <= 3)
				{
					amp.setText(AMP.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					amp.setText(AMP.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(CocaCola);
				test.play();
				if(cc_D.getCount() <= 3)
				{
					CocaCola.setText(cocaC.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					CocaCola.setText(cocaC.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Sprite);
				test.play();
				if(sprite_D.getCount() <= 3)
				{
					Sprite.setText(sprite.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Sprite.setText(sprite.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Fanta);
				test.play();
				if(fanta_D.getCount() <= 3)
				{
					Fanta.setText(fanta.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Fanta.setText(fanta.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Pepsi);
				test.play();
				if(pepsi_D.getCount() <= 3)
				{
					Pepsi.setText(pepsi.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Pepsi.setText(pepsi.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
		});
				
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Five);
				test.play();
				if(five_D.getCount() <= 3)
				{
					Five.setText(five.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Five.setText(five.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Orbit);
				test.play();
				if(orbit_D.getCount() <= 3)
				{
					Orbit.setText(orbit.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Orbit.setText(orbit.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(JFruit);
				test.play();
				if(juicyFruit_D.getCount() <= 3)
				{
					JFruit.setText(juicyFruit.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					JFruit.setText(juicyFruit.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Lays);
				test.play();
				if(lays_D.getCount() <= 3)
				{
					Lays.setText(lays.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Lays.setText(lays.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Doritos);
				test.play();
				if(doritos_D.getCount() <= 3)
				{
					Doritos.setText(doritos.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Doritos.setText(doritos.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Ruffles);
				test.play();
				if(ruffles_D.getCount() <= 3)
				{
					Ruffles.setText(ruffles.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Ruffles.setText(ruffles.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Snickers);
				test.play();
				if(snickers_D.getCount() <= 3)
				{
					Snickers.setText(snickers.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Snickers.setText(snickers.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
			
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(mms);
				test.play();
				if(mms_D.getCount() <= 3)
				{
					mms.setText(MMS.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					mms.setText(MMS.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
				test.setToY(500);
				test.setAutoReverse(true);
				test.setCycleCount(2);
				test.setNode(Reeses);
				test.play();
				if(reeses_D.getCount() <= 3)
				{
					Reeses.setText(reeses.toPrint() + LowOrPO.declareLowInventory());
				}
				else
				{
					Reeses.setText(reeses.toPrint());
				}
			}
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
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
			sbcmf_D.atBought();
			sbcf_D.atBought();
			sbpsl_D.atBought();
			sbcb_D.atBought();
			dasani_D.atBought();
			aquaf_D.atBought();
			kirk_D.atBought();
			memMark_D.atBought();
			monster_D.atBought();
			redB_D.atBought();
			fhe_D.atBought();
			amp_D.atBought();
			cc_D.atBought();
			sprite_D.atBought();
			fanta_D.atBought();
			pepsi_D.atBought();
			five_D.atBought();
			orbit_D.atBought();
			juicyFruit_D.atBought();
			lays_D.atBought();
			doritos_D.atBought();
			ruffles_D.atBought();
			snickers_D.atBought();
			mms_D.cancel();
			reeses_D.cancel();
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
		});
		cancel.setOnAction(e ->
		{
			updateTotal.resetIandP();
			sbcmf_D.cancel();
			sbcf_D.cancel();
			sbpsl_D.cancel();
			sbcb_D.cancel();
			dasani_D.cancel();
			aquaf_D.cancel();
			kirk_D.cancel();
			memMark_D.cancel();
			monster_D.cancel();
			redB_D.cancel();
			fhe_D.cancel();
			amp_D.cancel();
			cc_D.cancel();
			sprite_D.cancel();
			fanta_D.cancel();
			pepsi_D.cancel();
			five_D.cancel();
			orbit_D.cancel();
			juicyFruit_D.cancel();
			lays_D.cancel();
			doritos_D.cancel();
			ruffles_D.cancel();
			snickers_D.cancel();
			mms_D.cancel();
			reeses_D.cancel();
			ITotal.setText(String.valueOf(updateTotal.getItems()));		//change total price
			PTotal.setText(String.valueOf(updateTotal.getPrice()));		//change total items
		});
		//SERVICE PANE
		InventoryManager inventoryLists = new InventoryManager();
		servicePane.setAlignment(Pos.CENTER);
		servicePane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		servicePane.setHgap(5.5);
		servicePane.setVgap(5.5);
		
		Label Items = new Label("label");
		Button showStats = new Button("Update/Display Inventory");
		servicePane.add(showStats, 2, 1);
		showStats.setOnAction(e ->
		{
			Items.setText("There are " + sbcmf_D.getCount() + " " + SbCarmFrap.toPrint() + "\n" + 
					"There are " + sbcf_D.getCount() + " " + SbCoffFrap.toPrint() + "\n" + 
					"There are " + sbpsl_D.getCount() + " " + SbPSL.toPrint() + "\n" + 
					"There are " + sbcb_D.getCount() + " " + SbColBru.toPrint() + "\n" + 
					"There are " + dasani_D.getCount() + " " + dasani.toPrint() + "\n" + 
					"There are " + aquaf_D.getCount() + " " + aquafina.toPrint() + "\n" + 
					"There are " + kirk_D.getCount() + " " + kirkland.toPrint() + "\n" + 
					"There are " + memMark_D.getCount() + " " + memMark.toPrint() + "\n" + 
					"There are " + monster_D.getCount() + " " + Monster.toPrint() + "\n" + 
					"There are " + redB_D.getCount() + " " + RedBull.toPrint() + "\n" + 
					"There are " + fhe_D.getCount() + " " + FHE.toPrint() + "\n" + 
					"There are " + amp_D.getCount() + " " + AMP.toPrint() + "\n" + 
					"There are " + cc_D.getCount() + " " + cocaC.toPrint() + "\n" + 
					"There are " + sprite_D.getCount() + " " + sprite.toPrint() + "\n" + 
					"There are " + fanta_D.getCount() + " " + fanta.toPrint() + "\n" + 
					"There are " + pepsi_D.getCount() + " " + pepsi.toPrint() + "\n" + 
					"There are " + five_D.getCount() + " " + five.toPrint() + "\n" + 
					"There are " + orbit_D.getCount() + " " + orbit.toPrint() + "\n" + 
					"There are " + juicyFruit_D.getCount() + " " + juicyFruit.toPrint() + "\n" + 
					"There are " + lays_D.getCount() + " " + lays.toPrint() + "\n" + 
					"There are " + doritos_D.getCount() + " " + doritos.toPrint() + "\n" + 
					"There are " + ruffles_D.getCount() + " " + ruffles.toPrint() + "\n" + 
					"There are " + snickers_D.getCount() + " " + snickers.toPrint() + "\n" + 
					"There are " + mms_D.getCount() + " " + MMS.toPrint() + "\n" + 
					"There are " + reeses_D.getCount() + " " + reeses.toPrint());
		});
		Button backFromService = new Button("Back");
		servicePane.add(Items, 1, 1);
		servicePane.add(backFromService, 2, 2);
		backFromService.setOnAction(e -> 
		{
			primaryStage.setScene(selectItem);
		});
		
		Button writeOut = new Button("Print Inventory.csv");
		servicePane.add(writeOut, 2, 3);
		writeOut.setOnAction(e->
		{
			String[] prodArray = {SbCarmFrap.arrayPrint(),
					   SbCoffFrap.arrayPrint(),
					   SbPSL.arrayPrint(),
					   SbColBru.arrayPrint(),
					   dasani.arrayPrint(),
					   aquafina.arrayPrint(),
					   kirkland.arrayPrint(),
					   memMark.arrayPrint(),
					   Monster.arrayPrint(),
					   RedBull.arrayPrint(),
					   FHE.arrayPrint(),
					   AMP.arrayPrint(),
					   cocaC.arrayPrint(),
					   sprite.arrayPrint(),
					   fanta.arrayPrint(),
					   pepsi.arrayPrint(),
					   five.arrayPrint(),
					   orbit.arrayPrint(),
					   juicyFruit.arrayPrint(), 
					   lays.arrayPrint(),
					   doritos.arrayPrint(),
					   ruffles.arrayPrint(),
					   snickers.arrayPrint(),
					   MMS.arrayPrint(),
					   reeses.arrayPrint()};
			int[] dispArray = {sbcmf_D.getCount(),
					   sbcf_D.getCount(),
					   sbpsl_D.getCount(),
					   sbcb_D.getCount(), 
					   dasani_D.getCount(),
					   aquaf_D.getCount(),
					   kirk_D.getCount(),
					   memMark_D.getCount(),
					   monster_D.getCount(),
					   redB_D.getCount(),
					   fhe_D.getCount(),
					   amp_D.getCount(),
					   cc_D.getCount(),
					   sprite_D.getCount(),
					   fanta_D.getCount(),
					   pepsi_D.getCount(),
					   five_D.getCount(),
					   orbit_D.getCount(),
					   juicyFruit_D.getCount(),
					   lays_D.getCount(),
					   doritos_D.getCount(),
					   ruffles_D.getCount(),
					   snickers_D.getCount(),
					   mms_D.getCount(),
					   reeses_D.getCount()};
			try
			{
				inventoryLists.writeOut(prodArray, dispArray);
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		Button addItems = new Button("Load the Machine with 1 more item");
		servicePane.add(addItems, 1, 3);
		addItems.setOnAction(e->
		{
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
			
			Items.setText("There are " + sbcmf_D.getCount() + " " + SbCarmFrap.toPrint() + "\n" + 
					"There are " + sbcf_D.getCount() + " " + SbCoffFrap.toPrint() + "\n" + 
					"There are " + sbpsl_D.getCount() + " " + SbPSL.toPrint() + "\n" + 
					"There are " + sbcb_D.getCount() + " " + SbColBru.toPrint() + "\n" + 
					"There are " + dasani_D.getCount() + " " + dasani.toPrint() + "\n" + 
					"There are " + aquaf_D.getCount() + " " + aquafina.toPrint() + "\n" + 
					"There are " + kirk_D.getCount() + " " + kirkland.toPrint() + "\n" + 
					"There are " + memMark_D.getCount() + " " + memMark.toPrint() + "\n" + 
					"There are " + monster_D.getCount() + " " + Monster.toPrint() + "\n" + 
					"There are " + redB_D.getCount() + " " + RedBull.toPrint() + "\n" + 
					"There are " + fhe_D.getCount() + " " + FHE.toPrint() + "\n" + 
					"There are " + amp_D.getCount() + " " + AMP.toPrint() + "\n" + 
					"There are " + cc_D.getCount() + " " + cocaC.toPrint() + "\n" + 
					"There are " + sprite_D.getCount() + " " + sprite.toPrint() + "\n" + 
					"There are " + fanta_D.getCount() + " " + fanta.toPrint() + "\n" + 
					"There are " + pepsi_D.getCount() + " " + pepsi.toPrint() + "\n" + 
					"There are " + five_D.getCount() + " " + five.toPrint() + "\n" + 
					"There are " + orbit_D.getCount() + " " + orbit.toPrint() + "\n" + 
					"There are " + juicyFruit_D.getCount() + " " + juicyFruit.toPrint() + "\n" + 
					"There are " + lays_D.getCount() + " " + lays.toPrint() + "\n" + 
					"There are " + doritos_D.getCount() + " " + doritos.toPrint() + "\n" + 
					"There are " + ruffles_D.getCount() + " " + ruffles.toPrint() + "\n" + 
					"There are " + snickers_D.getCount() + " " + snickers.toPrint() + "\n" + 
					"There are " + mms_D.getCount() + " " + MMS.toPrint() + "\n" + 
					"There are " + reeses_D.getCount() + " " + reeses.toPrint());
			
			finalInventory = Items.getText();
		});
		
		Button demoMode = new Button("Demo Mode");
		servicePane.add(demoMode, 2, 4);
		demoMode.setOnAction(e -> primaryStage.setScene(demoScene));
		
		//DEMO PANE
		demoPane.setAlignment(Pos.CENTER);
		demoPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		demoPane.setHgap(5.5);
		demoPane.setVgap(5.5);
		
		Button runDemo = new Button("Run Demo");
		demoPane.add(runDemo, 3, 3);
		DemoMode newDemo = new DemoMode();
		Queue<fakePeople> demoA = new LinkedList<>();
		Label qReadOut = new Label(" ");
		Label qTotal = new Label(" ");
		Label isTooLow = new Label(" ");
		Label isFinished = new Label(" ");
		demoPane.add(qReadOut, 4, 3);
		demoPane.add(qTotal, 5, 3);
		demoPane.add(isTooLow, 6, 3);
		demoPane.add(isFinished, 7, 3);
		runDemo.setOnAction(e -> 
		{
			try
			{
				newDemo.readQ(demoA);
				String fakeish = " ";
				double totalPrice = pepsi.price + SbColBru.price + dasani.price + five.price + MMS.price;
				String Qtotal = (String.valueOf(totalPrice));
				for(fakePeople deepFake : demoA)
				{
					fakeish = fakeish + deepFake.FName + ", " + deepFake.PName + ", " + deepFake.num + "\n";
				}
				qReadOut.setText(fakeish);
				qTotal.setText("Total is: $" + Qtotal);
				if(pepsi_D.getCount() <= 3 || sbcb_D.getCount() <= 3 || dasani_D.getCount() <= 3 || five_D.getCount() <= 3 || mms_D.getCount() <= 3)
				{
					isTooLow.setText("inventory is too low!!!");
				}
				isFinished.setText(finalInventory + " All customers have been served");
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
