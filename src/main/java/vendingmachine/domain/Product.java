package vendingmachine.domain;

import vendingmachine.constant.Condition;

public class Product {
    private String name;
    private int cost;
    private int amount;

    public Product(String name, int cost, int amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }

    public void sellProduct() {
        amount -= Condition.ONE_SELL.getNumber();
    }
}