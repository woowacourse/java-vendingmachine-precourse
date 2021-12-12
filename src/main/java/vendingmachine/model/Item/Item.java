package vendingmachine.model.Item;

import vendingmachine.model.buy.BuyItemName;

public class Item {
    Name name;
    Price price;

    public Item(String itemName, String itemPrice) {
        this.name = new Name(itemName);
        this.price = new Price(Integer.parseInt(itemPrice));
    }

    public boolean sameName(String buyItemName) {
        return name.sameName(buyItemName);
    }

    public boolean sameName(BuyItemName buyItemName) {
        return name.sameName(buyItemName);
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name.toString() + price.toString();
    }
}
