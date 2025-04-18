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
		super.setCost(1);
		
		counter++;
	}

    public int tick() {
		this.age += 1;

		return age;
    }

    public void setAge(int temp_age) {
        age = temp_age;
    }

    public boolean died() {
        if (this.age > this.death_age) {
            return true;
        } else {
            return false;
        }

    }

    public int getValue() {
    	if (this.age > this.mat_age) {
			return this.montery_val;
		}
		return 0;
    }

    @Override
    public String toString() {
        if (age > mat_age) {
            return "G";
        }
        return "g";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public static int getGenerationCount() {
    	return counter;
    }

}
