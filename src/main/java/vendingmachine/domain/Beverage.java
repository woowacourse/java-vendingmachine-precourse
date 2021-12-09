package vendingmachine.domain;


import java.util.Objects;

public class Beverage {

    private String productName;
    private int price;
    private int amount;

    Beverage(String productName, int price, int amount) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int reduceAmount() {
        return --amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return productName.equals(beverage.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
