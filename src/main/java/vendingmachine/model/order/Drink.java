package vendingmachine.model.order;

public class Drink implements Comparable<Drink> {
    private final String name;
    private final int price;
    private final int quantity;

    public Drink(String name, String price, String quantity) {
        new DrinkValidator(name, price, quantity);
        this.name = name;
        this.price = Integer.parseInt(price);
        this.quantity = Integer.parseInt(quantity);
    }

    public boolean isMinPrice(Drink minPriceDrink) {
        return this.quantity == minPriceDrink.quantity;
    }

    @Override
    public int compareTo(Drink other) {
        return this.price - other.price;
    }
}
