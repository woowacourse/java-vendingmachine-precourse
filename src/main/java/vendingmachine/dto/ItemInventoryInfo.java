package vendingmachine.dto;

public class ItemInventoryInfo {
    private ItemInfo itemInfo;
    private int quantity;

    public ItemInventoryInfo(ItemInfo itemInfo, int quantity) {
        this.itemInfo = itemInfo;
        this.quantity = quantity;
    }

    //테스트를 위한 getter
    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public int getQuantity() {
        return quantity;
    }
}
