package vendingmachine.domain.VendingMachine;

import vendingmachine.constants.ItemName;

public class Item {

    private final ItemName itemName;
    private final Price price;
    private final Count count;

    public Item(ItemName itemName, Price price, Count count) {
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

}
