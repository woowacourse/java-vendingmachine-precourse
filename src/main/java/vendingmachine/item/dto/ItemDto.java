package vendingmachine.item.dto;

public class ItemDto {

    private final String name;
    private final int price;
    private final int stockQuantity;

    public ItemDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}