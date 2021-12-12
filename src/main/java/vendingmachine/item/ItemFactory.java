package vendingmachine.item;

import vendingmachine.dto.servicedto.ItemInfo;
import vendingmachine.dto.servicedto.ItemInventoryInfo;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class ItemFactory {
    private Items items = new Items();

    public Items createByInventoryList(ItemsInventoryInfo itemsInventoryInfo) {
        initialize();
        for (ItemInventoryInfo itemInventoryInfo : itemsInventoryInfo.getInfo()) {
            createItem(itemInventoryInfo);
        }
        return items;
    }

    private void initialize() {
        items = new Items();
    }

    private void createItem(ItemInventoryInfo itemInventoryInfo) {
        ItemInfo itemInfo = itemInventoryInfo.getItemInfo();
        items.add(new Item(itemInfo.getName(), itemInfo.getPrice()), itemInventoryInfo.getQuantity());
    }
}
