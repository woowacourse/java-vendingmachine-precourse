package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ItemsInventoryInfo {
    Map<ItemInfo, Integer> itemInventoryInfo = new HashMap<>();

    public ItemsInventoryInfo() {
    }

    public void add(ItemInfo itemInfo, int quantity) {
        itemInventoryInfo.put(itemInfo, quantity);
    }

    //test를 위한 getter
    public Map<ItemInfo, Integer> getInfo() {
        return new HashMap<>(itemInventoryInfo);
    }
}
