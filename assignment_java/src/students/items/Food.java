package students.items;

public abstract class Food extends Item {
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

}