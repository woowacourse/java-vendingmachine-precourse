package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEMS_OVERLAP_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.dto.InputItemDTO;

class ItemsTest {
    @Test
    @DisplayName("상품에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedItems() {
        InputItemDTO first = new InputItemDTO(Arrays.asList("물", "1000", "2"));
        InputItemDTO second = new InputItemDTO(Arrays.asList("물", "1000", "3"));
        List<InputItemDTO> overlappedInputItemInfos = Arrays.asList(first, second);
        assertThatIllegalArgumentException().isThrownBy(() -> new Items(overlappedInputItemInfos))
                .withMessage(ITEMS_OVERLAP_EXCEPTION_MESSAGE);
    }
}
