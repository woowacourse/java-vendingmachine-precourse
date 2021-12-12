package vendingmachine.Domain;

public class Product {
    private String name;
    private int cost;
    private int count;

    public Product(String name, int cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public boolean isSameName(String input) {
        return this.name.equals(input);
    }

    public boolean isRemain() {
        return this.count > 0;
    }

    public boolean canPurchase() {
        return InputAmount.isMoreThanCost(cost);
    }

    public void purchase() {
        this.count--;
        InputAmount.takeMoney(this.cost);
    }

}
