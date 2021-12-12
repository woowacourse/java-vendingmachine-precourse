package vendingmachine.item;

import vendingmachine.utils.ItemErrorMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepository {

    private final Map<String, Integer> itemKeys = new ConcurrentHashMap<>();
    private final Map<Integer, Item> items = new ConcurrentHashMap<>();

    private static class InnerInstanceClazz {
        private static final ItemRepository instance = new ItemRepository();
    }

    public static ItemRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void save(Item item) {
        int itemKey = createItemKey();
        itemKeys.put(item.getName(), itemKey);
        items.put(itemKey, item);
    }

    private Integer createItemKey() {
        return items.size();
    }

    public Item findOneByName(String name) {
        Integer key = findItemKey(name);
        return items.get(key);
    }

    private Integer findItemKey(String name) {
        try {
            return itemKeys.get(name);
        }catch(NullPointerException e) {
            throw new IllegalArgumentException(ItemErrorMessage.NOT_EXIST_ITEM);
        }
    }
}