package students.items;

public abstract class Soil extends Item {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	private int cost;
	
	public Soil() {
		mat_age = Integer.MAX_VALUE;
		death_age = Integer.MAX_VALUE;
		montery_val = 0;
		age = 0;
		cost = 0;
	}

	public int tick() {
		this.age += 1;

		return age;
	}

	public void setAge(int temp_age) {
		this.age = temp_age;
	}


    @Override
    public int getValue() {
    	if (age > mat_age) {
			return montery_val;
		}
		return 0;
    }
    
	public String died() {
			return "Soil cannot die!";
	}

    public String toString() {
        return ".";
    }
    
    @Override
    public boolean equals(Object obj) {
    	 return super.equals(obj);
	}

}

