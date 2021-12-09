package vendingmachine.inputvalue;

import static org.assertj.core.util.Arrays.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.ItemInfo;
import vendingmachine.ItemsInventoryInfo;

public class ItemsInventoryInputValue {
    private final String input;

    public ItemsInventoryInputValue(String input) {
        this.input = input;
    }

    public ItemsInventoryInfo toItemsInventoryInfo() {
        String[] itemsInventoryInputValue = divideIntoItems();
        checkInputEmpty(itemsInventoryInputValue);
        ItemsInventoryInfo itemsInventoryInfo = new ItemsInventoryInfo();
        for (String itemInventoryInputValue : itemsInventoryInputValue) {
            itemsInventoryInfo = addInfoToItemsInventoryInfo(itemsInventoryInfo, itemInventoryInputValue);
        }
        checkDuplicatedNames(itemsInventoryInfo);
        return itemsInventoryInfo;
    }

    private void checkInputEmpty(String[] input) {
        if(isNullOrEmpty(input)) {
            throw new IllegalArgumentException("하나 이상의 상품에 대한 정보를 입력해 주세요");
        }
    }

    private String[] divideIntoItems() {
        return input.split(";");
    }

    private ItemsInventoryInfo addInfoToItemsInventoryInfo(ItemsInventoryInfo itemsInventoryInfo, String itemInventoryInputValue) {
        List<String> dividedInputValue = divideByKindOfInfo(itemInventoryInputValue);
        validateOneInventoryInfo(dividedInputValue);
        itemsInventoryInfo.add(extractItemInfo(dividedInputValue), extractItemQuantity(dividedInputValue));
        return itemsInventoryInfo;
    }

    private void checkDuplicatedNames(ItemsInventoryInfo itemsInventoryInfo) {
        Map<ItemInfo, Integer> info = itemsInventoryInfo.getInfo();
        Set<String> collectedItemNames = info.keySet().stream().map(ItemInfo::getName).collect(Collectors.toSet());
        if (collectedItemNames.size() != info.size()) {
            throw new IllegalArgumentException("상품명은 중복될 수 없습니다");
        }
    }

    private List<String> divideByKindOfInfo(String itemInventoryInfoValue) {
        return Arrays.asList(splitByComma(removeBraces(itemInventoryInfoValue)));
    }

    private void validateOneInventoryInfo(List<String> dividedInfoValue) {
        if (dividedInfoValue.size() != 3) {
            throw new IllegalArgumentException("상품명, 가격, 수량에 대한 정보를 모두 입력해 주세요");
        }
    }

    private String removeBraces(String itemInventoryInputValue) {
        if (!(itemInventoryInputValue.startsWith("[") || itemInventoryInputValue.endsWith("]"))) {
            throw new IllegalArgumentException("아이템 정보는 대괄호('[]')로 묶여 있어야 합니다");
        }
        return itemInventoryInputValue.substring(1, itemInventoryInputValue.length() - 1);
    }

    private String[] splitByComma(String itemInventoryInfoValue) {
        return itemInventoryInfoValue.split(",");
    }

    private ItemInfo extractItemInfo(List<String> infoToAdd) {
        return new ItemInfo(toItemName(infoToAdd.get(0)), toItemPrice(infoToAdd.get(1)));
    }

    private int extractItemQuantity(List<String> infoToAdd) {
        try {
            int quantity = Integer.parseInt(infoToAdd.get(2));
            validateItemQuantity(quantity);
            return quantity;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("수량은 정수로 변환할 수 있어야 하며 1보다 커야 합니다");
        }
    }

    private String toItemName(String itemNameInput) {
        validateItemName(itemNameInput);
        return itemNameInput;
    }

    private void validateItemName(String itemName) {
        if (itemName.isEmpty()) {
            throw new IllegalArgumentException("상품 명은 최소 한 글자 이상이어야 합니다");
        }
    }

    private int toItemPrice(String itemPriceInput) {
        int itemPrice;
        try {
            itemPrice = Integer.parseInt(itemPriceInput);
            validateItemPrice(itemPrice);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("상품 가격은 100원 이상의 정수이며 10원 단위로 나눠 떨어져야 합니다");
        }
        return itemPrice;
    }

    private void validateItemPrice(int itemPrice) {
        if (itemPrice < 100 || itemPrice % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateItemQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }
}
