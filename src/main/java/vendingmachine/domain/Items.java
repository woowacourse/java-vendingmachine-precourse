package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import vendingmachine.domain.validation.Validator;

public class Items {
    private final Map<String, Item> itemList;

    public Items() {
        itemList = new HashMap<>();
    }

    public void registerItem(String itemInput) {
        Validator itemManager = new Validator();
        StringTokenizer items = itemManager.getItemToken(itemInput);

        while (items.hasMoreTokens()) {
            String item = items.nextToken();

            String name = itemManager.getItemElement(Text.REGEX_ITEM_NAME, item);
            int price = Integer.parseInt(itemManager.getItemElement(Text.REGEX_ITEM_PRICE, item));
            int stock = Integer.parseInt(itemManager.getItemElement(Text.REGEX_ITEM_STOCK, item));

            itemList.put(name, new Item(name, price, stock));
        }

    }

    public boolean existsItemCanPurchase(int money) {

        for (String name : itemList.keySet()) {
            Item item = itemList.get(name);

            if (item.isInStock() && item.isEnoughMoney(money)) {
                return true;
            }

        }

        return false;
    }

    public Item getItem(String itemName) {
        return itemList.get(itemName);
    }

    public boolean existsItemName(String itemName) {
        return itemList.containsKey(itemName);
    }

    public int sellItem(String itemName) {
        Item item = getItem(itemName);
        item.sold();
        return item.getPrice();
    }
}
