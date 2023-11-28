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

public class ProductQuantityTest {
    @ParameterizedTest
    @DisplayName("상품수량을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("450")
    void givenNormalQuantity_thenSuccess(final String amount) {
        assertThat(Quantity.create(amount))
                .isInstanceOf(Quantity.class);

        assertThatCode(() -> Quantity.create(amount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("상품수량을 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankQuantity_thenFail(final String amount) {
        assertThatThrownBy(() -> Quantity.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "수량"));
    }

    @ParameterizedTest
    @DisplayName("상품수량을 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String amount) {
        assertThatThrownBy(() -> Quantity.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "수량"));
    }

    @ParameterizedTest
    @DisplayName("수량이 0이하인경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void givenLessZero_thenFail(final String amount) {
        assertThatThrownBy(() -> Quantity.create(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
    }
}
