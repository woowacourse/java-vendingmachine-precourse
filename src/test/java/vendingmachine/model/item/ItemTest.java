package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_BRACKET_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {
    @ParameterizedTest
    @DisplayName("상품 정보가 [ ]로 감싸져 있지 않으면 예외를 발생시킨다.")
    @ValueSource(strings = {"물, 1000, 3", "[물, 1000, 3", "물, 1000, 3]"})
    void evokeExceptionByWrongBracket(final String wrongBracketItemInfo) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(wrongBracketItemInfo))
                .withMessage(ITEM_INFO_BRACKET_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("상품명, 가격, 수량 중 누락된 정보가 있으면 예외를 발생시킨다.")
    @ValueSource(strings = {"[물]", "[물, 1000]"})
    void evokeExceptionByNotEnoughItemInfo(final String notEnoughItemInfo) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(notEnoughItemInfo))
                .withMessage(ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE);
    }
}
