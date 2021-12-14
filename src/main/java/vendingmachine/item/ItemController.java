package vendingmachine.item;

import java.util.ArrayList;
import java.util.List;

public class ItemController {

    Items items;
    private List<Item> itemsList;

    public ItemController() {
        items = new Items();
        itemsList = new ArrayList<>();
    }

}
