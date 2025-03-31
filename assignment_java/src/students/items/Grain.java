package students.items;

public abstract class Grain extends Food {
	private int mat_age;
	private int death_age;
	private int montery_val;
	private int age;
	private int cost;
	
	public Grain() {
		mat_age = 2;
		death_age = 6;
		montery_val = 2;
		age = 0;
		cost = 1;
	}

    @Override
    public int tick() {
        return super.tick();
    }

    @Override
    public void setAge(int temp_age) {
        super.setAge(temp_age);
    }

    @Override
    public String died() {
        if (age > death_age) {
            return "Food Item is dead!";
        } else {
            return "Food Item isn't dead!";
        }

    }

    @Override
    public int getValue() {
        return super.getValue();
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

}
