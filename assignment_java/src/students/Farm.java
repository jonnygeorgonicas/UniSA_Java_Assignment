package students;
import students.Field;
import students.items.Apples;
import students.items.Grain;
import students.items.Item;

import java.util.Scanner;

public class Farm extends Field{
	String Option;
	int fund;
	Apples a = new Apples();
	Grain g = new Grain();
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		super(fieldHeight, fieldWidth);
		//creates new field
		Field f = new Field(fieldHeight, fieldWidth);
		this.fund = startingFunds;
	}
	
	public void run(Field f)
	{
		//creates scanner object for means of user input
		Scanner Op = new Scanner(System.in);
		//a boolean for the state of the game
		boolean operating = true;
		
		//while operating is true the loop will continue to run
		while (operating) {
		//print the field created by the user
			System.out.println(f);
			
			System.out.println("Bank balance: $" + this.fund + "\n");
				
			System.out.println("Enter your next action:");
			System.out.println("t x y: till");
			System.out.println("h x y: harvest");
			System.out.println("p x y: plant");
			System.out.println("s: field summary");
			System.out.println("i: infection");
			System.out.println("w: wait");
			System.out.println("q: quit");		
						
			//reads the user input, removes the leading and trailing whitespace of a string
			String input = Op.nextLine().trim();
			//splits string into an array of sub strings for spaces 
			String[] str_parts = input.split(" ");
			
			try {
				//switches based on the first character in the array of sub strings
				switch (str_parts[0]) {
				case "t":
					//checks the length of the parts to check if the user inputs more than 3 characters
					if (str_parts.length == 3) {
						//stores the int from the string given by the user into variables such as x and y. 
						int x = Integer.parseInt(str_parts[1]);
						int y = Integer.parseInt(str_parts[2]);
						//tills the given positions
						super.till(x, y);
					}
						else {
							//if the input is invalid this string is printed in the console
							System.out.println("Invalid input format for till.");
						}
						break;
				
				case "h":
					//same reasoning as above for the length and parseInt
					if (str_parts.length == 3) {
						int x = Integer.parseInt(str_parts[1]);
						int y = Integer.parseInt(str_parts[2]);
						//I use a object to match the method being called
						Object itemObj = super.get(x, y);
						//A check for the string even being a item instance
						if (itemObj instanceof Item) {
							Item item = (Item) itemObj;
							//gets value of item
							int value = item.getValue();
							
							if (value > 0) {
								this.fund += value;
								//removes the item after harvest
								super.till(x, y);
								System.out.println("$" + value + " was made from the harvest");
							} else {
								//prints to console when the crop isn't mature
								System.out.println("Crop isn't mature yet.");
							}
						} else {
							System.out.println("Nothing to harvest at this location.");
						} 
					} else {
						System.out.println("invalid input format for the harvest command");
						}
					break;
				case "p":
					if (str_parts.length == 3) {
						int x = Integer.parseInt(str_parts[1]);
						int y = Integer.parseInt(str_parts[2]);
						System.out.println("Enter:");
						System.out.println(" - 'a' to buy an apple");
						System.out.println(" - 'g' to buy grain");
						//to lower case was to account for if the user inputted the string as an 'A' or 'G'
						String cropChoice = Op.nextLine().trim().toLowerCase();
						
						if (cropChoice.equals("a")) {
							//uses a getter to get the cost of the apple
							int cost = a.getCost();
							//checks if the user has enough funds to even buy the apple
							if (this.fund >= cost) {
								this.fund -= cost;
								//use new Apples() for the plant method to have unique ages to specific instances of the apple
								super.plant(x, y, new Apples());
							} else {
								//prints to console if the user doesn't have enough funds
								System.out.println("Not enough funds.");
							}
						}
						//similar reasoning for the coding decisions as above
						else if (cropChoice.equals("g")) {
							int cost = g.getCost();
							if (this.fund >= cost) {
								this.fund -= cost;
								super.plant(x, y, new Grain());
							} else {
								System.out.println("Not enough funds.");
							}
						} else {
							System.out.println("Invalid crop selection.");
						}
					} else {
						System.out.println("Invalid input format for the plant command");
					}
					break;
					//prints the summary for the field
			case "s":
				System.out.println("\n" + super.getSummary());
				break;
				//calls plague method
			case "i":
				super.Plague();
				break;
				//calls the tick method
			case "w":
				super.tick();
				break;
				//quits the game 
			case "q":
				operating = false;
				break;
				//default if none of the cases match the input given
			default:
				System.out.println("unrecognised command.");
				break;
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
	}
		Op.close();
	}
	
}




	
