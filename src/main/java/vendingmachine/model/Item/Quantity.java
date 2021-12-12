package vendingmachine.model.Item;

public class Quantity {
    int quantity;

    public Quantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public String toString() {
        return Integer.toString(quantity);
    }
}
