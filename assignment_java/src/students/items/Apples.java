package students.items;

public class Apples extends Food {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	private int cost;
	
	private static int counter;
	
	public Apples() {
		mat_age = 3;
		death_age = 5;
		montery_val = 3;
		age = 0;
		cost = 2;
		
		counter++;
	}

    public int tick() {
		this.age += 1;

		return age;
    }

    public void setAge(int temp_age) {
        age = temp_age;
    }

    public String died() {
        if (this.age > this.death_age) {
            return "True";
        } else {
            return "False";
        }

    }

    public int getValue() {
    	if (this.age > this.mat_age) {
			return this.montery_val;
		}
		return 0;
    }

    public String toString() {
        if (this.age > this.mat_age) {
            return "A";
        }
        return "a";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public static int getGenerationCount() {
    	return counter;
    }

}

