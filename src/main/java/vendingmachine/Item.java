package vendingmachine;

import java.util.Objects;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return price == item.price && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
