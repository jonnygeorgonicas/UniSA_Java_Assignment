package students.items;

public class Grain extends Food {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	
	private static int counter;
	
	public Grain() {
		mat_age = 2;
		death_age = 6;
		montery_val = 2;
		age = 0;
		//sets the cost to 1
		super.setCost(1);
		
		counter++;
	}
	//increases the age of the grain when called
    public int tick() {
		this.age += 1;

		return age;
    }
    //sets the age of the grain
    public void setAge(int temp_age) {
        age = temp_age;
    }
 // checks if the age is above the death age to see if the grain is dead
    public boolean died() {
        if (this.age > this.death_age) {
            return true;
        } else {
            return false;
        }

    }
  //returns the value of the object if the age is greater than the mat_age
    public int getValue() {
    	if (this.age > this.mat_age) {
			return this.montery_val;
		}
		return 0;
    }
    //returns 'G' if age is above mat_age
    @Override
    public String toString() {
        if (this.age > this.mat_age) {
            return "G";
        }
        //otherwise returns 'g'
        return "g";
    }
    //checks if one object is equal to another
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    //returns the number of instances generated
    public static int getGenerationCount() {
    	return counter;
    }

}
