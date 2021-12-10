package vendingmachine.model.item;

import static vendingmachine.exception.ExceptionMessage.ITEMS_OVERLAP_EXCEPTION_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.InputItemDTO;

public class Items {
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
