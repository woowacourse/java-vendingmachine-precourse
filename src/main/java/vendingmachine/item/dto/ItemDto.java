package vendingmachine.item.dto;

import vendingmachine.utils.validator.ItemDataValidator;

public class ItemDto {

    private String name;
    private int price;
    private int stockQuantity;

    private ItemDto(){}

    public static ItemDto fromInputString(String data) {
        String[] separatedData = data.split(ItemDataValidator.SINGLE_ITEM_SEPARATE_UNIT);
        ItemDto itemDto = new ItemDto();
        itemDto.name = separatedData[0];
        itemDto.price = Integer.parseInt(separatedData[1]);
        itemDto.stockQuantity = Integer.parseInt(separatedData[2]);
        return itemDto;
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