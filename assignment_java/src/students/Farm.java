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
		Field f = new Field(fieldHeight, fieldWidth);
		this.fund = startingFunds;
	}
	
	public void run(Field f)
	{
		Scanner Op = new Scanner(System.in);
		boolean operating = true;
		
		while (operating) {
		System.out.println(f);
		
		System.out.println("Bank balance: $" + this.fund + "\n");
			
		System.out.println("Enter your next action:");
		System.out.println("t x y: till");
		System.out.println("h x y: harvest");
		System.out.println("p x y: plant");
		System.out.println("s: field summary");
		System.out.println("w: wait");
		System.out.println("q: quit");		
					
			
		String input = Op.nextLine().trim();
		String[] str_parts = input.split(" ");
		
		try {
			switch (str_parts[0]) {
			case "t":
				if (str_parts.length == 3) {
					int x = Integer.parseInt(str_parts[1]);
					int y = Integer.parseInt(str_parts[2]);
					super.till(x, y);
				}
					else {
						System.out.println("Invalid input format for till.");
					}
					break;
			
			case "h":
				if (str_parts.length == 3) {
					int x = Integer.parseInt(str_parts[1]);
					int y = Integer.parseInt(str_parts[2]);
					
					Object itemObj = super.get(x, y);
					if (itemObj instanceof Item) {
						Item item = (Item) itemObj;
						int value = item.getValue();
						
						if (value > 0) {
							this.fund += value;
							super.till(x, y);
							System.out.println("$" + value + " was made from the harvest");
						} else {
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
					
					String cropChoice = Op.nextLine().trim().toLowerCase();
					
					if (cropChoice.equals("a")) {
						int cost = a.getCost();
						if (this.fund >= cost) {
							System.out.println(this.fund);
							this.fund -= cost;
							super.plant(x, y, new Apples());
							System.out.println(cost);
							System.out.println(this.fund);
						} else {
							System.out.println("Not enough funds.");
						}
					}
					
					else if (cropChoice.equals("g")) {
						int cost = g.getCost();
						if (this.fund >= cost) {
							System.out.println(this.fund);
							this.fund -= cost;
							super.plant(x, y, new Grain());
							System.out.println(cost);
							System.out.println(this.fund);
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
				
		case "s":
			System.out.println("\n" + super.getSummary());
			break;
			
		case "w":
			super.tick();
			break;
			
		case "q":
			System.out.println("Quitted");
			operating = false;
			break;

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




	
