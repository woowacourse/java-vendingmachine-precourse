package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_BRACKET_EXCEPTION_MESSAGE;

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
}
