package vendingmachine.dto.servicedto;

import java.util.ArrayList;
import java.util.List;

public class ItemsInventoryInfo {
    List<ItemInventoryInfo> itemsInventoryInfo = new ArrayList<>();

    public void add(ItemInventoryInfo itemInventoryInfo) {
        itemsInventoryInfo.add(itemInventoryInfo);
    }

    public List<ItemInventoryInfo> getInfo() {
        return new ArrayList<>(itemsInventoryInfo);
    }
}
