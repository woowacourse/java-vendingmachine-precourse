package vendingmachine;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isEqualToName(String name) {
        return this.name.equals(name);
    }

    public void processPurchasing(Order order) {
        this.quantity -= 1;
        order.calculate(this.price);
    }

    public boolean isPossibleBuy() {
        if (this.quantity > 0) {
            return true;
        }
        throw ErrorMessage.IMPOSSIBLE_BUY_PRODUCT.getException();
    }
}
