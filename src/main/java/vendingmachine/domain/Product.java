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

    public boolean isSameName(Product product, String productName) {
        if (product.getName().equals(productName)) {
            return true;
        }
        return false;
    }

    public boolean isCostLessThanMoney(Product product, int money) {
        if (product.getCost() <= money) {
            return true;
        }
        return false;
    }

    public int minusMoneyForProductPurchase(Product product, int money) {
        return money - product.getCost();
    }

    public boolean hasQuantity(Product product) {
        if (product.getQuantity() < Condition.QUANTITY_1.getNumber()) {
            return false;
        }
        return true;
    }

    public int countProductQuantity(int amount, Product product) {
        return amount + product.getQuantity();
    }
}