package students.items;

public class Food extends Item {
	private int cost;
	
	public Food() {
		cost = 0;
	}

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

	@Override
	public String toString() {
		return null;
	}

}