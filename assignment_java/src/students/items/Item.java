package students.items;

public abstract class Item {
	private int age;
	private int mat_age;
	private int death_age;
	private int montery_val;
	
	public Item() {
		age = 0;
		mat_age = 0;
		death_age = 0;
		montery_val = 0;
	}

	public int tick() {
		this.age += 1;

		return age;
	}

	public void setAge(int temp_age) {
		age = temp_age;
	}

	public String died() {
		if (age > death_age) {
			return "Food Item is dead!";
		} else
			return "Food Item isn't dead!";
	}

	public int getValue() {
		if (this.age > this.mat_age) {
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
