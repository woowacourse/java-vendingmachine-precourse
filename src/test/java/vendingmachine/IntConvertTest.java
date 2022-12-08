package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.util.IntConvert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class IntConvertTest {

    private static final String EXCEPTION_MESSAGE_CONVERT_INT = "[ERROR] 입력값이 숫자가 아니거나 값의 범위를 초과했습니다.";

    @DisplayName("숫자가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "$%", "\n"})
    void InputIsNotNumber(String input) {
        assertThatThrownBy(() -> IntConvert.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_CONVERT_INT);
    }
}
