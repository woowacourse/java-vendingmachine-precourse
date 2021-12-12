package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "+100", "money"})
    @DisplayName("입력받은 금액이 숫자가 아닌 경우 exception이 발생되어야 한다.")
    void createExceptionByStringMoney(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> VendingMachine.createByMoney(input))
            .withMessage("[ERROR] 금액은 양의 숫자여야 합니다.");
    }
}