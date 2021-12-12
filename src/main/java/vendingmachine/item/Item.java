package vendingmachine.item;

import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.ItemErrorMessage;

public class Item {

    private String name;
    private int price;
    private int stockQuantity;

    private Item(){}

    public static Item fromItemDto (ItemDto itemDto) {
        Item item = new Item();
        item.name = itemDto.getName();
        item.price = itemDto.getPrice();
        item.stockQuantity = itemDto.getStockQuantity();
        return item;
    }

    public String getName() {
        return name;
    }

    public void reduceStock() throws NotEnoughStockException {
        if(stockQuantity == 0) {
            throw new NotEnoughStockException(ItemErrorMessage.NOT_STOCK);
        }
        stockQuantity -= 1;
    }
}