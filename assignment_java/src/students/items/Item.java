package students.items;

public abstract class Item {
	private int age = 0;
	private int mat_age = 0;
	private int death_age = 0;
	private int montery_val = 0;

	public int tick() {
		this.age += 1;

		return age;
	}

	public void setAge(int temp_age) {
		this.age = temp_age;
	}

	public String died() {
		if (age > death_age) {
			return "Food Item is dead!";
		} else
			return "Food Item isn't dead!";
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
