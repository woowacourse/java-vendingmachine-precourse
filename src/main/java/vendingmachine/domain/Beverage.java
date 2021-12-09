package vendingmachine.domain;


import java.util.Objects;

public class Beverage {

    private String productName;
    private int price;
    private int count;

    public Beverage(String productName, int price, int count) {
        this.productName = productName;
        this.price = price;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int reduceCount() {
        return --count;
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
