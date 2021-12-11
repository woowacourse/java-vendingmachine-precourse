package vendingmachine.domain;

import vendingmachine.constant.Condition;

public class Product implements Comparable<Product>{
    private String name;
    private int cost;
    private int quantity;

    public Product(String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void sellProduct() {
        quantity -= Condition.ONE_SELL.getNumber();
    }

    @Override
    public int compareTo(Product p) {
        return Integer.compare(cost, p.cost);
    }
}