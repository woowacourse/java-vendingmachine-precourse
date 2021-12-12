package vendingmachine.item;

import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.validator.InputDataValidator;
import vendingmachine.utils.validator.ItemDataValidator;

import java.util.regex.PatternSyntaxException;

public class ItemController {

    private final ItemService itemService;
    private final InputDataValidator inputDataValidator;

    private ItemController() {
        itemService = ItemService.getInstance();
        inputDataValidator = new ItemDataValidator();
    }
    private static class InnerInstanceClazz {
        private static final ItemController instance = new ItemController();
    }

    public static ItemController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void addItem(String inputItems) {
        try{
            String[] items = splitItemData(inputItems);
            for(String item : items) {
                item = item.replace("[", "").replace("]", "");
                inputDataValidator.validateSingleFormatSize(item);
                inputDataValidator.validateNumber(item);
                itemService.addItem(ItemDto.fromInputString(item));
            }
        }catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String[] splitItemData(String inputItems) {
        try{
            return inputItems.split(ItemDataValidator.MULTIPLE_ITEM_SEPARATE_UNIT);
        }catch(PatternSyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}