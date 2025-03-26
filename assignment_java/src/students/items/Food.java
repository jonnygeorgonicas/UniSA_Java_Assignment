package students.items;

public abstract class Food extends Item {
    private int cost = 0;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
// up casting and down casting for the assignment is needed
