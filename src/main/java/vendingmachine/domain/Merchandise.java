package vendingmachine.domain;

import vendingmachine.util.NumberValidation;

public class Merchandise extends NumberValidation {
    private String name;
    private int price;
    private int quantity;

    public Merchandise(String name, String price, String quantity) {
        isBlank(name);
        this.name = name;

        numberValidation(price);
        this.price = Integer.parseInt(price);

        numberValidation(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public String toString() {
        return name + price + quantity;
    }
}
