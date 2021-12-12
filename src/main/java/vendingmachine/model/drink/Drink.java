package vendingmachine.model.drink;

import vendingmachine.util.Constant;

public class Drink implements Comparable<Drink> {
    private final String name;
    private final int price;
    private int quantity;

    public Drink(String name, String price, String quantity) {
        new DrinkValidator(name, price, quantity);
        this.name = name;
        this.price = Integer.parseInt(price);
        this.quantity = Integer.parseInt(quantity);
    }

    public boolean isSameDrink(String drinkName) {
        return this.name == drinkName;
    }

    public boolean isOverPrice(int userMoney) {
        return userMoney >= this.price;
    }

    public boolean hasQuantity() {
        return this.quantity > Constant.QUANTITY_MIN_VALUE;
    }

    public void decQuantity() {
        this.quantity--;
    }

    @Override
    public int compareTo(Drink other) {
        return other.price - this.price;
    }
}
