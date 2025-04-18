package students;
import students.items.*;

import java.util.Random;

import students.Farm;

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
			for (int j = 0; j < fieldArray[i].length; j++) {
				fieldArray[i][j] = s;
		
			}
		}
	}
	
	public int tick() {
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray[i].length; j++) {
				//ticks every item in the field
				fieldArray[i][j].tick();
				
				if (fieldArray[i][j] instanceof Soil) {				
					double percent = 0.20;
					
					//triggers 20 percent chance
					if (Math.random() < percent)
					{
						fieldArray[i][j] = w;
						System.out.println(fieldArray[i][j]);
					}
					
				}
				
				if (fieldArray[i][j].died() == true) {
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
			//adds 1 to the appleCreate int to check for the number of apples created by the user
			appleCreate += 1;
		}
		if (fieldArray[pos1][pos2] instanceof Grain) {
			//adds 1 to the grainCreate int to check for the number of grains created by the user
			grainCreate += 1;
		}
	}
	public int getValue() {
		//sums the values for the whole field
		int sum = 0;
		//used to check the mat age of the given crop to register
		int count = 0;
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray[i].length; j++) {
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
	public void Plague() {
		int cropNum = 0;
		Random rand = new Random();
		
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray[i].length; j++) {
				if (fieldArray[i][j] instanceof Apples || fieldArray[i][j] instanceof Grain) {
				cropNum++;
				}
			}
		}
		//if no instance of Apples or Grain exists on the field there will be no crops to be infected
		if (cropNum == 0) {
			System.out.println("There is no crops to infect!");
			System.out.println("Try planting some apples or grain");
			return; //exits method early
		}
		
		//get the total cells 
		int cells_tot = fieldArray.length * fieldArray[0].length;
		//makes the double a int to find cells in infected
		int cells_infected = (int)(cells_tot * (0.2 + Math.random() * 0.2));
		//prints to console how many cells are infected
		System.out.println("Infection has hit " + cells_infected + " crops will be affected.");
		
		int effected = 0;
		//keeps looping until effected is greater than cells_infected
		while (effected < cells_infected) {
			
			//gets random position within the array
			int k = rand.nextInt(fieldArray.length);
			int j = rand.nextInt(fieldArray[0].length);
			
			//checks if the element is an instance of Apples or Grain and makes it UntilledSoil
			if (fieldArray[k][j] instanceof Apples || fieldArray[k][j] instanceof Grain) {
				
				fieldArray[k][j] = us;
				
				//effected increments up an value
				effected++;
			}
		}
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
	            sb.append(fieldArray[row][col] + "  "); // Placeholder for object representation, which might need to be used again to fix a error
	        }
	        sb.append("\n");
	    }

	    return sb.toString(); // returns null instead of nothing for areas of the string that 
	}

	public String getSummary() {
		int soilCount = 0;
		int untilledCount = 0;
		int weedCount = 0;
		//checks for instance of Soil, weed and untilledsoil to count them
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray[i].length; j++) {
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
		//provides summary of field
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
