package students;
import students.items.*;

public class Field extends Item{
	Item[][] fieldArray;
	Soil s = new Soil();
	Weed w = new Weed();
	Apples a = new Apples();
	Grain g = new Grain();
	UntilledSoil us = new UntilledSoil();
	int appleCreate;
	int grainCreate;
	int appleCount;
	int grainCount;
	
	public Field(int height, int width)
	{
		this.appleCreate = 0;
		this.grainCreate = 0;
		this.appleCount = 0;
		this.grainCount = 0;
		
		this.fieldArray = new Item[height][width];
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				fieldArray[i][j] = s;
		
			}
		}
	}
	
	public int tick() {
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				//ticks every item in the field
				fieldArray[i][j].tick();
				
				if (fieldArray[i][j] instanceof Soil) {
					System.out.println("fieldArray element at " + i + " " + j + " is Soil");
					
					double percent = 0.20;
					
					//triggers 20 percent chance
					if (Math.random() < percent)
					{
						System.out.println("Weed has been created!");
						fieldArray[i][j] = w;
						System.out.println(fieldArray[i][j]);
					}
					
				}
				
				if (fieldArray[i][j].died() == true) {
					System.out.println(fieldArray[i][j] + " item has died!");
					fieldArray[i][j] = us;
				}
			}
		}
		return 0;
	}
	
	public void till(int pos1, int pos2) {
		if (fieldArray[pos1][pos2] != null) {
		Soil s = new Soil();
		fieldArray[pos1][pos2] = s;
		}
	}
	
	public Object get(int pos1, int pos2) {
		if (fieldArray[pos1][pos2] != null) {
		Object res = fieldArray[pos1][pos2];
		return res;
		}
		return null;
	}
	
	public void plant(int pos1, int pos2, Item item) {
		//stores a given Item at a given location 
		fieldArray[pos1][pos2] = item;
		
		if (fieldArray[pos1][pos2] instanceof Apples) {
			appleCreate += 1;
		}
		if (fieldArray[pos1][pos2] instanceof Grain) {
			grainCreate += 1;
		}
	}
	public int getValue() {
		//sums the values for the whole field
		int sum = 0;
		//used to check the mat age of the given crop to register
		int count = 0;
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				//calculates sum of the entire field 
				sum += fieldArray[i][j].getValue();
				
				//used to find the mat age of the given crop
				count = fieldArray[i][j].getValue();
				
				//checks if the given crop is an apple or grain and if it has matured
				if (fieldArray[i][j] instanceof Apples && count > 0) {
					appleCount += 1;
				}
				if (fieldArray[i][j] instanceof Grain && count > 0) {
					grainCount += 1;
				}
				
			}
		}
		//returns the total monetary value of each item in the field
		return sum;
	}

	@Override
	public String toString() {
		//StringBuilder is used to capture a mutable sequence of characters
		StringBuilder sb = new StringBuilder();
		
		int height = fieldArray.length;
		int width = fieldArray[0].length;
		
		
		sb.append("  ");
		for (int col = 1; col <= width; col++) {
			sb.append(String.format("%2d ", col));
		}
		sb.append("\n");

	    // Grid rows
	    for (int row = 0; row < height; row++) {
	        sb.append(String.format("%2d ", row + 1)); // Row label
	        for (int col = 0; col < width; col++) {
	            sb.append(fieldArray[row][col] + "  "); // Placeholder for object representation
	        }
	        sb.append("\n");
	    }

	    return sb.toString();
	}

	public String getSummary() {
		int soilCount = 0;
		int untilledCount = 0;
		int weedCount = 0;
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				if (fieldArray[i][j] instanceof Soil) {
					soilCount += 1;
				}
				if (fieldArray[i][j] instanceof UntilledSoil) {
					untilledCount += 1;
				}
				if (fieldArray[i][j] instanceof Weed) {
					weedCount += 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Apples:        " + appleCount + "\n");
		sb.append("Grain:         " + grainCount + "\n");
		sb.append("Soil:          " + soilCount + "\n");
		sb.append("Untilled:      " + untilledCount + "\n");
		sb.append("Weed:          " + weedCount + "\n");
		sb.append("For a total of $" + getValue() + "\n");
		sb.append("Total apples created: " + appleCreate + "\n");
		sb.append("Total grain created: " + grainCreate + "\n");
		
		return sb.toString();
		}

}
