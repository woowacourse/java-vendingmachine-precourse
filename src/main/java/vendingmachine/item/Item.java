package vendingmachine.item;

import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.message.ItemErrorMessage;

public class Item {

    private Integer id = null;
    private String name;
    private Integer price;
    private Integer stockQuantity;

    private Item(){}

    public static Item fromItemDto (ItemDto itemDto) {
        Item item = new Item();
        item.name = itemDto.getName();
        item.price = itemDto.getPrice();
        item.stockQuantity = itemDto.getStockQuantity();
        return item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void addStock(int quantity) {
        stockQuantity += quantity;
    }

    public void reduceStock(int quantity) {
        if(stockQuantity == 0) {
            throw new NotEnoughStockException(ItemErrorMessage.NOT_STOCK);
        }
        if(stockQuantity < quantity) {
            throw new NotEnoughStockException(ItemErrorMessage.NOT_ENOUGH_STOCK);
        }
        stockQuantity -= quantity;
    }

    public void hasStockQuantity(int quantity) {
        if(stockQuantity == 0) {
            throw new NotEnoughStockException(ItemErrorMessage.NOT_STOCK);
        }
        if(stockQuantity < quantity) {
            throw new NotEnoughStockException(ItemErrorMessage.NOT_ENOUGH_STOCK);
        }
    }

    public boolean isNotStock() {
        return stockQuantity == 0;
    }
}