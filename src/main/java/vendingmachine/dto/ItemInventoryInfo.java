package vendingmachine.dto;

public class ItemInventoryInfo {
    private ItemInfo itemInfo;
    private int quantity;

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
