package students.items;

public abstract class Item {
	private int age = 0;
	private int mat_age = 0;
	private int death_age = 0;
	private int montery_val = 0;
	
	public int getMat_age() {
		return mat_age;
	}

	public void setMat_age(int mat_age) {
		this.mat_age = mat_age;
	}

	public int getDeath_age() {
		return death_age;
	}

	public void setDeath_age(int death_age) {
		this.death_age = death_age;
	}

	public int getMontery_val() {
		return montery_val;
	}

	public void setMontery_val(int montery_val) {
		this.montery_val = montery_val;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int temp_age) {
		this.age = temp_age;
	}
	
	public int tick() {
		this.age += 1;
		
		return age;
	}
	
	public int getValue() {
		if (age > mat_age) {
			return montery_val;
		}
		return 0;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return age == other.age && death_age == other.death_age && mat_age == other.mat_age
				&& montery_val == other.montery_val;
	}

	public abstract String toString();
	
}
