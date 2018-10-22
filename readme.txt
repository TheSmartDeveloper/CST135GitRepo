Creator: Kevin George
Instructor: Prof. Parker
Class: CST135
Date: Ocotober 7th, 2018

The background for this project is that we need to create a vending machine that can input items and dispense them for the user. In implementing this program I decided to create abstract classes of product, drinks, and snacks so that each individual item object could inherit the properties from these super classes. Doing this allowed similar properties to be shared between all the classes and the unique ones can be held by each item.

As of right now, the user can add an item to the vending machine by calling the load machine method with the coordinates and the product that they want to put in there. They can then print out the vending machine data again and the product will show up in there. The product object must be declared before adding into the machine.

A user can also compare items using the compareto method in each product class. If two items have differently spelled names the item with the furthest first initial spelling in the alphabet will have greater precedence. If the first initial of the names is the same, then the price of each item will be compared. As of right now, every class can compare every object so you can compare a bottle of water with gum in a chip class compareTo method if you really wanted to.

For Milestone 4 a user can use a rudimentary GUI to control the application. They can move between screens and go to different categories. A transaction processing class is created to be utilized in the future. Also all items have their descriptions and prices on each button so that the user can know more about what they are purchasing.
