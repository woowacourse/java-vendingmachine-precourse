package vendingmachine.domain;

public class Money {
    private int cost;

    public Money(String cost) {
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return cost;
    }

    public void decreaseMoney(int cost) {
        this.cost -= cost;
    }

    public boolean isAvailableForPurchase(int price) {
        return price <= cost;
    }
}
