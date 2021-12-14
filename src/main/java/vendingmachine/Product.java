package vendingmachine;

public class Product {
    private String name;
    private int price;
    private int quantity;

    Product(String[] inputArray) {
        this.name=inputArray[0];
        this.price=Integer.parseInt(inputArray[1]);
        this.quantity=Integer.parseInt(inputArray[2]);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
