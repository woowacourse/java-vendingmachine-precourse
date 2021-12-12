package vendingmachine.model.Item;

public class Item {
    Name name;
    Price price;

    public Item(String itemName, String itemPrice) {
        this.name = new Name(itemName);
        this.price = new Price(Integer.parseInt(itemPrice));
    }

    @Override
    public String toString() {
        return name.toString() + price.toString();
    }
}
