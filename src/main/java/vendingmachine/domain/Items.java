package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Items {
    private final Validation itemManager;
    private final Map<String, Item> itemList;

    public Items() {
        itemManager = new Validation();
        itemList = new HashMap<>();
    }

    public void registerItem(String itemInput) {
        StringTokenizer items = itemManager.getItemToken(itemInput);

        while (items.hasMoreTokens()) {
            String item = items.nextToken();

            String name = itemManager.getItemElement(Text.REGEX_ITEM_NAME, item);
            int price = Integer.parseInt(itemManager.getItemElement(Text.REGEX_ITEM_PRICE, item));
            int stock = Integer.parseInt(itemManager.getItemElement(Text.REGEX_ITEM_STOCK, item));

            itemList.put(name, new Item(name, price, stock));
        }

    }
}
