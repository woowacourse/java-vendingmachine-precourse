package vendingmachine.dto.servicedto;

public class ItemInventoryInfo {
    private final ItemInfo itemInfo;
    private final int quantity;

    public ItemInventoryInfo(ItemInfo itemInfo, int quantity) {
        this.itemInfo = itemInfo;
        this.quantity = quantity;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public int getQuantity() {
        return quantity;
    }
}
