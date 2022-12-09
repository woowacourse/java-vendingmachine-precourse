package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.products.Quantity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuantityTest {

    private static final String EXCEPTION_MESSAGE_QUANTITY_RANGE =
            "[ERROR] 수량은 0 원 이상, 1000000000 원 이하 이어야 합니다.";

    @DisplayName("Quantity 클래스를 정상적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 1510, 1000000000})
    void createQuantitySuccess(int input) {
        boolean result = true;
        try {
            Quantity.from(input);
        } catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("잘못된 범위의 금액이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 1000000001})
    void createQuantityFail(int input) {
        assertThatThrownBy(() -> Quantity.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_QUANTITY_RANGE);
    }
}
