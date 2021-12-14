package vendingmachine.item;

import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.message.ItemErrorMessage;
import vendingmachine.utils.validator.InputDataValidator;
import vendingmachine.utils.validator.ItemDataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class ItemController {

    private final ItemService itemService;
    private final InputDataValidator inputDataValidator;

    private ItemController() {
        itemService = ItemService.getInstance();
        inputDataValidator = ItemDataValidator.getInstance();
    }
    private static class InnerInstanceClazz {
        private static final ItemController instance = new ItemController();
    }

    public static ItemController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void addItems(String inputItems) {

        List<String> itemData = removeParentheses(splitItemData(inputItems));
        validateItemData(itemData);

        List<ItemDto> itemDtoList = new ArrayList<>();
        for(String inputItem : itemData) {
            itemDtoList.add(ItemDto.fromInputString(inputItem));
        }
        itemService.addItems(itemDtoList);
    }

    private String[] splitItemData(String inputItems) {
        try{
            return inputItems.split(ItemDataValidator.MULTIPLE_ITEM_SEPARATE_UNIT);
        }catch(PatternSyntaxException e) {
            throw new IllegalArgumentException(ItemErrorMessage.ITEM_INPUT_FORMAT);
        }
    }

    private List<String> removeParentheses (String[] items) {

        List<String> newItemDataFormat = new ArrayList<>();
        for(String itemData : items) {
            newItemDataFormat.add(itemData.replace("[", "").replace("]", ""));
        }
        return newItemDataFormat;
    }

    public void validateItemData(List<String> items) {
        for(String item : items) {
            inputDataValidator.validateData(item);
        }
    }

    public void purChaseItem(String itemName, int quantity) {
        itemService.purchaseItem(itemName, quantity);
    }

    public void cancelPurchase(String itemName, int quantity) {
        itemService.cancelPurchase(itemName, quantity);
    }

    public void hasStockQuantity(String itemName, int quantity) {
        try {
            itemService.hasStockQuantity(itemName, quantity);
        }catch(NotEnoughStockException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getPriceByName(String itemName) {
        return itemService.getPriceByName(itemName);
    }

    public boolean isNotStockAllItem() {
        return itemService.isNotStockAllItem();
    }

    public boolean isLessThanTheLowestAmount(int amount) {
        Integer lowestPrice = itemService.getLowestPrice();
        return amount < lowestPrice;
    }
}