package vendingmachine.dto.request;

import static org.assertj.core.util.Arrays.isNullOrEmpty;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.dto.ItemInfo;
import vendingmachine.dto.ItemInventoryInfo;
import vendingmachine.dto.ItemsInventoryInfo;

public class ItemsInventoryRequest {
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
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("하나 이상의 상품에 대한 정보를 입력해 주세요");
        }
    }

    private ItemsInventoryInfo toItemsInventoryInfo(String[] inputDividedByItem) {
        ItemsInventoryInfo itemsInventoryInfo = new ItemsInventoryInfo();
        Arrays.stream(inputDividedByItem)
                .map(ItemInventoryRequest::new)
                .forEach(itemInventoryRequest -> itemsInventoryInfo.add(itemInventoryRequest.toItemInventoryInfo()));
        return itemsInventoryInfo;
    }

    private String[] divideByItem() {
        return input.split(";");
    }

    private void checkDuplicatedNames(ItemsInventoryInfo itemsInventoryInfo) {
        List<ItemInventoryInfo> info = itemsInventoryInfo.getInfo();
        Set<String> collectedItemNames = info.stream().map(ItemInventoryInfo::getItemInfo).map(ItemInfo::getName).collect(Collectors.toSet());
        if (collectedItemNames.size() != info.size()) {
            throw new IllegalArgumentException("상품명은 중복될 수 없습니다");
        }
    }
}
