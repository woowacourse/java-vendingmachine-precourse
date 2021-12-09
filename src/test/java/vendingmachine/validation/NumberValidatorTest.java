package vendingmachine.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {
    @ParameterizedTest
    @DisplayName("양의 정수가 아니면 true, 양의 정수면 false를 반환한다.")
    @CsvSource({"-1, true", "?, true", "1.2, true", "0, true", "1, false"})
    void isNotPositiveInteger(final String given, final boolean expected) {
        boolean actual = NumberValidator.isNotPositiveInteger(given);
        assertThat(actual).isEqualTo(expected);
    }
}