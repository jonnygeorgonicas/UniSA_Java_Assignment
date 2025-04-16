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
		//Add check for index being out of scope of the array
		Soil s = new Soil();
		fieldArray[pos1][pos2] = s;
	}
