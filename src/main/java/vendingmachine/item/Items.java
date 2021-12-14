package vendingmachine.item;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item> items;

    public Items() {
        items = new ArrayList<>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
