package students;
import students.Field;
import java.util.Scanner;

public class Farm extends Field{
	String Option;
	int fund;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		super(fieldHeight, fieldWidth);
		Field f = new Field(fieldHeight, fieldWidth);
		this.fund = startingFunds;
	    //Seem to be a error with the varying sizes of arrays under 10x10
	    //How to test it: System.out.println(f);
	}
	
	public void run(Field f)
	{
		
		System.out.println(f);
		
		System.out.println("Bank balance: $" + this.fund);
		
		Scanner Op = new Scanner(System.in);
			
		System.out.println("Enter your next action:");
		System.out.println("t x y: till");
		System.out.println("h x y: harvest");
		System.out.println("p x y: plant");
		System.out.println("s: field summary");
		System.out.println("w: wait");
		System.out.println("q: quit");		
					
			
		String Option = Op.nextLine();
		
		if ("t".equals(Option)) {
			super.till(0, 0);
		}
		
		if ("h".equals(Option)) {
			//harvest method logic
			}
		
		if ("p".equals(Option)) {
			//add conditional to this conditional to buy apple or grain
			
			super.plant(fund, fund, f);		}
		
		if ("s".equals(Option)) {
			System.out.println("\n" + super.getSummary());
			}
		
		if ("w".equals(Option)) {
			super.tick();
		}
			
		if ("q".equals(Option)) {
			System.out.println("Quitted");
			Op.close();
		}
		}
	}
	
