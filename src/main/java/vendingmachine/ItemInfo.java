package vendingmachine;

public class ItemInfo {
    private final String name;
    private final int price;

    public ItemInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //test를 위한 getter 2개
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
