package vendingmachine.dto;

import vendingmachine.domain.Item;

public class ItemDto {
    private final String name;
    private final long price;
    private final long quantity;

    private ItemDto(String name, long price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ItemDto of(String name, long price, long quantity) {
        return new ItemDto(name, price, quantity);
    }

    public Item toItem() {
        return Item.of(name, price, quantity);
    }
}
