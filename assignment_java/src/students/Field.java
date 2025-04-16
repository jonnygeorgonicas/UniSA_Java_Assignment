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
		
		//returns the total monetary value of each item in the field
		return sum;
	}

