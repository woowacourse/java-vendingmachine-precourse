package vendingmachine;

public class Order {
    private int holdingAmount;
    private String productName;

    public Order(int userAmount) {
        this.holdingAmount = userAmount;
    }

    public int getHoldingAmount() {
        return holdingAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void calculate(int price) {
        this.holdingAmount -= price;
    }

    public void addProduct(String productName) {
        this.productName = productName;
    }
}
