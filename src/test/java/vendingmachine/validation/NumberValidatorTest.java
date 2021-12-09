package vendingmachine.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아니면 true, 양의 정수면 false를 반환한다.")
    @CsvSource({"-1, true", "?, true", "1.2, true", "0, true", "1, false", "1000, false"})
    void isNotPositiveInteger(final String given, final boolean expected) {
        boolean actual = NumberValidator.isNotPositiveInteger(given);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("10의 배수가 아니면 true, 10의 배수면 false를 반환한다.")
    @CsvSource({"21, true", "30, false"})
    void isNotMultipleOfTen(final int value, final boolean expected) {
        boolean actual = NumberValidator.isNotMultipleOfTen(value);
        assertThat(actual).isEqualTo(expected);
    }
}
