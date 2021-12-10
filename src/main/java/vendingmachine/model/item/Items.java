package vendingmachine.model.item;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.InputItemDTO;

public class Items {
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
}
