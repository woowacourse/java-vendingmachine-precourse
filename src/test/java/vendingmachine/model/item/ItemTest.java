package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_FORMAT_EXCEPTION_MESSAGE;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {
    @ParameterizedTest
    @DisplayName("이름과 가격을 기준으로 동등성을 반환한다.")
    @MethodSource("provideAnotherItemAndExpected")
    void equals(final Item another, final boolean expected) {
        String itemInfo = "[물,1000,2]";
        Item item = new Item(itemInfo);
        boolean actual = item.equals(another);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAnotherItemAndExpected() {
        return Stream.of(
                Arguments.of(new Item("[물,1000,3]"), true),
                Arguments.of(new Item("[물,2000,2]"), false),
                Arguments.of(new Item("[콜라,1000,2]"), false),
                Arguments.of(new Item("[콜라,2000,2]"), false)
        );
    }

    @ParameterizedTest
    @DisplayName("상품 정보가 [ ]로 감싸져 있지 않으면 예외를 발생시킨다.")
    @ValueSource(strings = {"물, 1000, 3", "[물, 1000, 3", "물, 1000, 3]"})
    void evokeExceptionByWrongBracket(final String wrongBracketItemInfo) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(wrongBracketItemInfo))
                .withMessage(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("상품명, 가격, 수량 중 누락된 정보가 있으면 예외를 발생시킨다.")
    @ValueSource(strings = {"[물]", "[물, 1000]"})
    void evokeExceptionByNotEnoughItemInfo(final String notEnoughItemInfo) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(notEnoughItemInfo))
                .withMessage(ITEM_INFO_FORMAT_EXCEPTION_MESSAGE);
    }
}
