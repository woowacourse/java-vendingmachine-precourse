package vendingmachine.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 자연수_검증_테스트_입력값이_자연수인_경우() {
        // given
        String inputString = "1";
        // when, then
        InputView.validateNatural(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "0.1"})
    void 자연수_검증_테스트_입력값이_자연수가_아닌_경우(String inputString) {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNatural(inputString));
    }

    @Test
    void 십원의_배수_검증_테스트_입력값이_십원의_배수인_경우() {
        // given
        String inputString = "10";
        // when, then
        InputView.validateTensMultiple(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "15"})
    void 십원의_배수_검증_테스트_입력값이_십원의_배수가_아닌_경우(String inputString) {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateTensMultiple(inputString));
    }
}