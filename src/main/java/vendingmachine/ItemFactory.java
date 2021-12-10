package vendingmachine;

import vendingmachine.dto.ItemInfo;
import vendingmachine.dto.ItemInventoryInfo;
import vendingmachine.dto.ItemsInventoryInfo;

public class ItemFactory {
    private Items items;

    public Items createByInventoryList(ItemsInventoryInfo itemsInventoryInfo) {
        items = new Items();
        for (ItemInventoryInfo itemInventoryInfo : itemsInventoryInfo.getInfo()) {
            createItem(itemInventoryInfo);
        }
        return items;
    }

    private void createItem(ItemInventoryInfo itemInventoryInfo) {
        ItemInfo itemInfo = itemInventoryInfo.getItemInfo();
        items.addItem(new Item(itemInfo.getName(), itemInfo.getPrice()), itemInventoryInfo.getQuantity());
    }
}
