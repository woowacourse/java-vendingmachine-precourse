package vendingmachine.domain;

import vendingmachine.utils.ItemValidator;

public class Item {
    private final String name;
    private final long price;
    private final long quantity;

    private Item(String name, long price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Item of(String name, long price, long quantity) {
        ItemValidator.validatePrice(price);

        return new Item(name, price, quantity);
    }


    public String provideName() {
        return name;
    }
}
