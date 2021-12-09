package vendingmachine.inputvalue;

import java.util.Arrays;
import java.util.List;

import vendingmachine.ItemInfo;
import vendingmachine.ItemsInventoryInfo;

public class ItemsInventoryInputValue {
    private final String input;

    public ItemsInventoryInputValue(String input) {
        this.input = input;
    }

    public ItemsInventoryInfo toItemsInventoryInfo() {
        String[] itemsInventoryInputValue = divideIntoItems();
        ItemsInventoryInfo itemsInventoryInfo = new ItemsInventoryInfo();
        for (String itemInventoryInputValue : itemsInventoryInputValue) {
            itemsInventoryInfo = addInfoToItemsInventoryInfo(itemsInventoryInfo, itemInventoryInputValue);
        }
        return itemsInventoryInfo;
    }

    private String[] divideIntoItems() {
        return input.split(";");
    }

    private ItemsInventoryInfo addInfoToItemsInventoryInfo(ItemsInventoryInfo itemsInventoryInfo, String itemInventoryInputValue) {
        List<String> dividedInputValue = divideByKindOfInfo(itemInventoryInputValue);
        validate(dividedInputValue);
        itemsInventoryInfo.add(extractItemInfo(dividedInputValue), extractItemQuantity(dividedInputValue));
        return itemsInventoryInfo;
    }

    private List<String> divideByKindOfInfo(String itemInventoryInfoValue) {
        return Arrays.asList(splitByComma(removeBraces(itemInventoryInfoValue)));
    }

    private void validate(List<String> dividedInfoValue) {
        if (dividedInfoValue.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private String removeBraces(String itemInventoryInputValue) {
        if (!(itemInventoryInputValue.startsWith("[") || itemInventoryInputValue.endsWith("]"))) {
            throw new IllegalArgumentException();
        }
        return itemInventoryInputValue.substring(1, itemInventoryInputValue.length() - 1);
    }

    private String[] splitByComma(String itemInventoryInfoValue) {
        return itemInventoryInfoValue.split(",");
    }

    private ItemInfo extractItemInfo(List<String> infoToAdd) {
        return new ItemInfo(infoToAdd.get(0), Integer.parseInt(infoToAdd.get(1)));
    }

    private int extractItemQuantity(List<String> infoToAdd) {
        return Integer.parseInt(infoToAdd.get(2));
    }
}
