package domain.wrapper;

import domain.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.*;

public class VendingMachineAmountTest {
    @ParameterizedTest
    @DisplayName("보유금액을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("450")
    void givenNormalAmount_thenSuccess(final String amount) {
        assertThat(VendingMachineAmount.create(amount))
                .isInstanceOf(VendingMachineAmount.class);

        assertThatCode(() -> VendingMachineAmount.create(amount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("보유금액을 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankAmount_thenFail(final String amount) {
        assertThatThrownBy(() -> VendingMachineAmount.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "보유금액"));
    }

    @ParameterizedTest
    @DisplayName("보유금액을 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String amount) {
        assertThatThrownBy(() -> VendingMachineAmount.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "보유금액"));
    }

    @ParameterizedTest
    @DisplayName("보유금액이 10으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ValueSource(strings = {"456", "123"})
    void givenNonDivisibleBy10_thenFail(final String amount) {
        assertThatThrownBy(() -> VendingMachineAmount.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TEN_UNIT_MESSAGE.getValue(), Constant.COIN_TEN.getValue()));
    }

    @ParameterizedTest
    @DisplayName("보유금액이 0이하인경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "-3"})
    void givenLessZero_thenFail(final String amount) {
        assertThatThrownBy(() -> VendingMachineAmount.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
    }
}
