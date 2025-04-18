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
		super.setCost(2);
		
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
    	if (this.age > this.getMat_age()) {
			return this.montery_val;
		}
		return 0;
    }

    public String toString() {
        if (this.age > this.getMat_age()) {
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

	public int getMat_age() {
		return mat_age;
	}

	public void setMat_age(int mat_age) {
		this.mat_age = mat_age;
	}

}

