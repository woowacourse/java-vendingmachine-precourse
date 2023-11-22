package vendingmachine.dto;


public class OrderDetailDto {
    private final String itemName;
    private final long updatedInputAmount;

    private OrderDetailDto(String itemName, long updatedInputAmount) {
        this.itemName = itemName;
        this.updatedInputAmount = updatedInputAmount;
    }

    public static OrderDetailDto of(String itemName, long updatedInputAmount) {
        return new OrderDetailDto(itemName, updatedInputAmount);
    }

    public long getUpdatedInputAmount() {
        return updatedInputAmount;
    }
}
