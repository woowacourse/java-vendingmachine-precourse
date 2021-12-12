package vendingmachine.model.Item;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.model.money.MoneyCoin;

public class Items {
    private final HashMap<Item, Quantity> itemsMap = new HashMap<>();

    public Items(String[] rawItems) {
        for (String rawItem : rawItems) {
            String itemData = rawItem.substring(1, rawItem.length()- 1);
            String[] itemSplit = itemData.split(",");
            itemsMap.put(new Item(itemSplit[0], itemSplit[1]), new Quantity(itemSplit[2]));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Item> items = new ArrayList<>(itemsMap.keySet());
        for (Item item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append(" " + itemsMap.get(item) + "개 \n");
        }
        return stringBuilder.toString();
    }
}
