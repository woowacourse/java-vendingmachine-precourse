package vendingmachine;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    private Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product of(String name, int price, int quantity) {
        return new Product(name, price, quantity);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduce() {
        this.quantity--;
    }

    public boolean isOutOfStock() {
        return quantity == 0;
    }

    public boolean isLessThan(InputAmount inputAmount) {
        return price <= Integer.parseInt(inputAmount.toString());
    }

    public boolean isSameName(String productName) {
        return name.equals(productName);
    }
}
