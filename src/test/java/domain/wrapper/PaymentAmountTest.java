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
import static util.message.ExceptionMessage.RANGE_MESSAGE;

public class PaymentAmountTest {
    @ParameterizedTest
    @DisplayName("투입금액을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("450")
    void givenNormalPaymentAmount_thenSuccess(final String paymentAmount) {
        assertThat(PaymentAmount.create(paymentAmount))
                .isInstanceOf(PaymentAmount.class);

        assertThatCode(() -> PaymentAmount.create(paymentAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("투입금액을 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankPaymentAmount_thenFail(final String paymentAmount) {
        assertThatThrownBy(() -> PaymentAmount.create(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "투입금액"));
    }

    @ParameterizedTest
    @DisplayName("투입금액을 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String paymentAmount) {
        assertThatThrownBy(() -> PaymentAmount.create(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "투입금액"));
    }

    @ParameterizedTest
    @DisplayName("투입금액이 0이하인경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void givenLessZero_thenFail(final String paymentAmount) {
        assertThatThrownBy(() -> PaymentAmount.create(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
    }
}
