package vendingmachine.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "111", "0"})
    void validateInt는_0이상의_정수의_범위만_가능하다(String given) {
        // when&then
        assertThatNoException().isThrownBy(() -> InputValidator.validateInt(given));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1s", "111원", "3000원", "0.0"})
    void validateInt는_숫자만_입력가능하다(String given) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateInt(given));

        assertEquals(exception.getMessage(), "숫자0-9만 입력 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000000000000000000000000", "1000000000000000000"})
    void validateInt는_정수범위만_입력가능하다(String given) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateInt(given));

        assertEquals(exception.getMessage(), "정수의 범위를 벗어났습니다");
    }
}