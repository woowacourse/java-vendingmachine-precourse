package models;

import static vendingmachine.VendingMachineMain.userInputMoney;

public class Product {
    private String productName;
    private int price;
    private int remains;

    public Product(String productName, int price, int remains) {
        this.productName = productName;
        this.price = price;
        this.remains = remains;
    }

    public void provide() {
        this.remains--;
        //totalRemains--;
        userInputMoney -= this.price;
    }

    public int value() {
        return this.price;
    }

    public boolean isSoldOut() {
        return this.remains == 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", remains=" + remains +
                '}';
    }
}