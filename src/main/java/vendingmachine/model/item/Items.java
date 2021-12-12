package vendingmachine.model.item;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.vo.Money;

public class Items {
    private static final String WANTED_ITEM_NOT_FOUND_EXCEPTION_MESSAGE = "구매하시려는 상품이 상품 목록에 없습니다.";
    private static final String ITEMS_OVERLAP_EXCEPTION_MESSAGE = "상품에 중복이 있습니다.";
    private final List<Item> values;

    public Items(final List<InputItemDTO> inputItems) {
        values = inputItems.stream()
                .map(Item::new)
                .collect(Collectors.toList());
        validateOverlap();
    }

    private void validateOverlap() {
        int distinctCountOfItems = (int) values.stream().distinct().count();
        if (values.size() != distinctCountOfItems) {
            throw new IllegalArgumentException(ITEMS_OVERLAP_EXCEPTION_MESSAGE);
        }
    }

    public void sell(final String userWantedItemName, final Money remainingInputMoney) {
        Item userWantedItem = values.stream()
                .filter(item -> item.hasName(userWantedItemName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(WANTED_ITEM_NOT_FOUND_EXCEPTION_MESSAGE));
        userWantedItem.sell(remainingInputMoney);
    }

    public boolean canSellSomethingWith(final Money remainingInputMoney) {
        return values.stream().anyMatch(item -> !item.cannotSell(remainingInputMoney));
    }
}
