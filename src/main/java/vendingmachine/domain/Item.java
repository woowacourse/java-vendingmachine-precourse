package vendingmachine.domain;

public class Item {

    private final ItemName itemName;
    private final Price price;
    private final Count count;

    public Item(ItemName itemName, Price price, Count count) {
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return itemName.getName();
    }

    public boolean isEmpty() {
        return count.isZero();
    }

    public boolean isAvailable(int money) {
        return price.isAvailable(money);
    }

    public boolean is(ItemName itemName) {
        return this.itemName.getName().equals(itemName.getName());
    }

    public void reduce() {
        count.reduce();
    }

    public int getPrice() {
        return price.getPrice();
    }
}
