package vendingmachine.model.order;

public class Drink {
    private final String name;
    private final int price;
    private final int quantity;

    public Drink(String name, String price, String quantity) {
        new DrinkValidator(name, price, quantity);
        this.name = name;
        this.price = convertToInt(price);
        this.quantity = convertToInt(quantity);
    }

    private int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
