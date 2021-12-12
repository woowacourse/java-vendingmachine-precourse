package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "+100", "money"})
    @DisplayName("입력받은 금액이 숫자가 아닌 경우 exception이 발생되어야 한다.")
    void createExceptionByStringMoney(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.valueOf(input))
            .withMessage("[ERROR] 금액은 양의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "1001", "100003"})
    @DisplayName("입력받은 금액이 10으로 나누어떨어지지 않는 경우 exception이 발생되어야 한다.")
    void createExceptionByShareLeastMoneyTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.valueOf(input))
            .withMessage("[ERROR] 금액은 10원으로 나누어떨어지는 금액만 입력할 수 있습니다.");
    }
}