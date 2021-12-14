package vendingmachine.dto.request.iteminventory;

import static org.assertj.core.util.Arrays.isNullOrEmpty;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_DUPLICATED_ITEM_NAMES_IN;
import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_ITEM_INVENTORY_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.dto.servicedto.ItemInfo;
import vendingmachine.dto.servicedto.ItemInventoryInfo;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class ItemsInventoryRequest {
    private static final String SEMICOLON_DELIMITER_BETWEEN_ITEM_INVENTORY_INFO = ";";
    private final String input;

    public ItemsInventoryRequest(String input) {
        this.input = input;
    }

    public ItemsInventoryInfo toItemsInventoryInfo() {
        String[] inputDividedByItem = divideByItem();
        checkInputEmpty(inputDividedByItem);
        ItemsInventoryInfo itemsInventoryInfo = toItemsInventoryInfo(inputDividedByItem);
        checkDuplicatedNames(itemsInventoryInfo);
        return itemsInventoryInfo;
    }

    private void checkInputEmpty(String[] input) {
        if (isNullOrEmpty(input) || checkEachStringNotEmpty(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_ITEM_INVENTORY_INPUT);
        }
    }

    private boolean checkEachStringNotEmpty(String[] input) {
        for (String string : input) {
            if (string.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private ItemsInventoryInfo toItemsInventoryInfo(String[] inputDividedByItem) {
        ItemsInventoryInfo itemsInventoryInfo = new ItemsInventoryInfo();
        Arrays.stream(inputDividedByItem)
                .map(ItemInventoryRequest::new)
                .forEach(itemInventoryRequest -> itemsInventoryInfo.add(itemInventoryRequest.toItemInventoryInfo()));
        return itemsInventoryInfo;
    }

    private String[] divideByItem() {
        return input.split(SEMICOLON_DELIMITER_BETWEEN_ITEM_INVENTORY_INFO);
    }

    private void checkDuplicatedNames(ItemsInventoryInfo itemsInventoryInfo) {
        List<ItemInventoryInfo> info = itemsInventoryInfo.getInfo();
        Set<String> collectedItemNames = info.stream().map(ItemInventoryInfo::getItemInfo).map(ItemInfo::getName).collect(Collectors.toSet());
        if (collectedItemNames.size() != info.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_DUPLICATED_ITEM_NAMES_IN);
        }
    }
}
