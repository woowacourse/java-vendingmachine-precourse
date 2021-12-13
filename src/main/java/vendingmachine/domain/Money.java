package vendingmachine.domain;

public class Money {
    private int cost;

    public Money(String cost) {
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return cost;
    }
}
