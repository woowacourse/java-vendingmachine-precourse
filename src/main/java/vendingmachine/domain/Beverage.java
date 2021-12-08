package vendingmachine.domain;


import vendingmachine.utils.ExceptionMessage;

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
        count--;
        return count;
    }

}
