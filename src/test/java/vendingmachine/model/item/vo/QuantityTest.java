package vendingmachine.model.item.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 상품 수량을 입력하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotPositiveInteger(final String notPositiveInteger) {
        String expectedExceptionMessage = "상품 수량은 양의 정수여야 합니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Quantity(notPositiveInteger))
                .withMessage(expectedExceptionMessage);
    }

}