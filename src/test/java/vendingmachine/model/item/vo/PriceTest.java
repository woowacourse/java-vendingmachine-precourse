package vendingmachine.model.item.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.*;

class PriceTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(notIntegerValue))
                .withMessage(NOT_POSITIVE_INTEGER_PRICE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("10의 배수가 아닌 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByNotMultipleOfTen() {
        String notMultipleOfTen = "1001";
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(notMultipleOfTen))
                .withMessage(NOT_MULTIPLE_OF_TEN_PRICE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("100 미만의 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByLowerThan100() {
        String valueLowerThan100 = "99";
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(valueLowerThan100))
                .withMessage(PRICE_MIN_VALUE_EXCEPTION_MESSAGE);
    }
}