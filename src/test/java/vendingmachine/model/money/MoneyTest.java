package vendingmachine.model.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notIntegerValue))
                .withMessage(NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("10의 배수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByNotMultipleOfTen() {
        String notMultipleOfTen = "1001";
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notMultipleOfTen))
                .withMessage(NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE);
    }
}
