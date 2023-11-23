package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;

    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public void soldProduct(){
        this.quantity--;
    }
}
