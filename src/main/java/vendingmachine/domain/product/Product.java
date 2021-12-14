package vendingmachine.domain.product;

import vendingmachine.domain.consumer.Consumer;

public class Product {

    private final String name;
    private final int price;
    private int amount;

    private Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static Product of(String name, int price, int amount) {
        return new Product(name, price, amount);
    }

    public boolean verifyEnough(int balance) {
        return price <= balance;
    }

    public void isPurchasedBy(Consumer consumer) {
        consumer.reduceBalance(price);
        reduceAmount();
    }

    private void reduceAmount() {
        amount--;
    }


    // for test
    public boolean verifyName(String name) {
        return this.name.equals(name);
    }
}
