package models;

import static vendingmachine.VendingMachineMain.userInputMoney;

public class Product {
    public static int totalRemains;
    private String productName;
    private int price;
    private int remains;

    public Product(String productName, int price, int remains) {
        this.productName = productName;
        this.price = price;
        this.remains = remains;
    }

    public boolean provide() {
        if (this.remains >= 1 && userInputMoney - this.price >= 0) {
            this.remains--;
            totalRemains--;
            userInputMoney -= this.price;
            return true;
        }
        return false;
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