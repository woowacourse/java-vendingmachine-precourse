package vendingmachine.domain;

public class Product {
    private String name;
    private int price;
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void sell() {
        amount--;
    }

    public boolean existStock() {
        return this.amount > 0;
    }

    public int isLessThanMinimumPrice(int minimumPrice) {
        if (minimumPrice > this.price) {
            return this.price;
        }
        return minimumPrice;
    }

    public int calcCustomerMoney(int customerMoney) {
        return customerMoney - this.price;
    }

    public String getName() {
        return this.name;
    }
}
