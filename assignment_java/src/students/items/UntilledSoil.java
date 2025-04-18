package students.items;

public class UntilledSoil extends Item {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	private int cost;
	
	public UntilledSoil() {
		//uses Integer.MAX_VALUE to represent infinity
		mat_age = Integer.MAX_VALUE;
		death_age = Integer.MAX_VALUE;
		montery_val = -1;
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


    public int getValue() {
    	if (this.age > this.mat_age) {
			return this.montery_val;
		}
		return 0;
    }
    
	public boolean died() {
			return false;
	}

    public String toString() {
        return "/";
    }
    
    @Override
    public boolean equals(Object obj) {
    	 return super.equals(obj);
	}

}

