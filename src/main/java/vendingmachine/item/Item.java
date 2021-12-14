package vendingmachine.item;

public class Item implements Comparable<Item> {
    private final String name;
    private final int price;
    private int count;

    public Item(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void minusCount() {
        this.count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int compareTo(Item i) {
        return getPrice().compareTo(i.getPrice());
    }
}
