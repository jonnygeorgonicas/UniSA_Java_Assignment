package students.items;

public class Apples extends Food {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	
	private static int counter;
	
	public Apples() {
		mat_age = 3;
		death_age = 5;
		montery_val = 3;
		age = 0;
		//sets the cost to 2
		super.setCost(2);
		
		counter++;
	}
	//increases the age of the grain when called
    public int tick() {
		this.age += 1;

		return age;
    }
  //sets the age of the apple
    public void setAge(int temp_age) {
        age = temp_age;
    }
 // checks if the age is above the death age to see if the apple is dead
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
  //returns 'A' if age is above mat_age
    public String toString() {
        if (this.age > this.mat_age) {
            return "A";
        }
      //otherwise returns 'a'
        return "a";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
  //returns the number of instances generated
    public static int getGenerationCount() {
    	return counter;
    }

}

