package vendingmachine.model;

public class Item {
    private String name;
    private int price;
    private int itemCount;

    public Item(String name, int price, int itemCount) {
        this.name = name;
        this.price = price;
        this.itemCount = itemCount;
    }

    public int getPrice() {
        return price;
    }

    public boolean checkName(String name) {
        return this.name.contentEquals(name);
    }

    public boolean checkNotItem() {
        return itemCount == 0;
    }

    public boolean checkPrice(int amount) {
        return this.price <= amount;
    }

    public void decreaseCount() {
        itemCount -= 1;
    }
}
