package vendingmachine;

public class Product {
    private static final int EMPTY_QUANTITY = 0;

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

    public boolean isExistedProduct() {
        if (this.quantity > EMPTY_QUANTITY) {
            return true;
        }
        throw ErrorMessage.IMPOSSIBLE_BUY_PRODUCT.getException();
    }

    public boolean isPossibleBuyProduct(int holdingAmount) {
        return isExistedProduct() && price <= holdingAmount;
    }
}
