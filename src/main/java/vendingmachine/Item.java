package vendingmachine;

public class Item {
    private String name;
    private int price;
    private int itemCount;

    public Item(String name, int price, int itemCount) {
        this.name = name;
        this.price = price;
        this.itemCount = itemCount;
    }

    boolean checkName(String name) {
        return this.name.contentEquals(name);
    }

    boolean checkNotItem() {
        return itemCount == 0;
    }

    boolean checkPrice(int amount) {
        return this.price <= amount;
    }
}
