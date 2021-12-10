package vendingmachine.dto;

public class ItemInfo {
    private final String name;
    private final int price;

    public ItemInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
