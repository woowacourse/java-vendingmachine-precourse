package vendingmachine.dto.request;

import java.util.Arrays;
import java.util.List;

import vendingmachine.dto.ItemInfo;
import vendingmachine.dto.ItemInventoryInfo;

public class ItemInventoryRequest {
    private final String input;
    public ItemInventoryInfo toItemInventoryDto;

    public ItemInventoryRequest(String input) {
        this.input = input;
    }

    public ItemInventoryInfo toItemInventoryInfo() {
        List<String> input = divideByKindOfInfo();
        validate(input);
        return new ItemInventoryInfo(extractItemInfo(input), extractItemQuantity(input));
    }

    private List<String> divideByKindOfInfo() {
        return Arrays.asList(splitByComma(removeBraces()));
    }

    private void validate(List<String> dividedInfoValue) {
        if (dividedInfoValue.size() != 3) {
            throw new IllegalArgumentException("상품명, 가격, 수량에 대한 정보를 모두 입력해 주세요");
        }
    }

    private ItemInfo extractItemInfo(List<String> infoToAdd) {
        ItemRequest itemRequest = new ItemRequest(infoToAdd.get(0), infoToAdd.get(1));
        return itemRequest.toItemInfo();
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

    private String removeBraces() {
        if (!(input.startsWith("[") || input.endsWith("]"))) {
            throw new IllegalArgumentException("아이템 정보는 대괄호('[]')로 묶여 있어야 합니다");
        }
        return input.substring(1, input.length() - 1);
    }

    private String[] splitByComma(String itemInventoryInfoValue) {
        return itemInventoryInfoValue.split(",");
    }

    private void validateItemQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }
}
