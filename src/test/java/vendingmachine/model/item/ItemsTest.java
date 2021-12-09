package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEMS_OVERLAP_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemsTest {
    @ParameterizedTest
    @DisplayName("상품 구분자(;)의 앞 뒤에 상품 정보가 없으면 예외를 발생시킨다.")
    @ValueSource(strings = {";[물,1000,3];[콜라,1500,4]", "[물,1000,3];[콜라,1500,4];"})
    void evokeExceptionByWrongDelimiterPosition(final String wrongDelimiterInfos) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Items(wrongDelimiterInfos))
                .withMessage(WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("상품에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedItems() {
        String overlappedItemsInfo = "[물,1000,3];[물,1000,4]";
        assertThatIllegalArgumentException().isThrownBy(() -> new Items(overlappedItemsInfo))
                .withMessage(ITEMS_OVERLAP_EXCEPTION_MESSAGE);
    }
}
