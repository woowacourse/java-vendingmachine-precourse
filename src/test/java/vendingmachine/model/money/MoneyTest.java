package vendingmachine.model.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        String expectedExceptionMessage = "금액은 양의 정수여야 합니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notIntegerValue))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("10의 배수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByNotMultipleOfTen() {
        String notMultipleOfTen = "1001";
        String expectedExceptionMessage = "금액의 최소 단위는 10원입니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notMultipleOfTen))
                .withMessage(expectedExceptionMessage);
    }
}
