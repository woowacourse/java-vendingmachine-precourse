package vendingmachine.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.util.ExceptionMessage;

class MachineMoneyValidatorTest {

    private MachineMoneyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new MachineMoneyValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"한글", "moonja", "   문자   wi t h 공    백   ", " -1000 ", "- 2 32 2190000"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }


        @DisplayName("int 범위를 초과한 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"2222222222222222222222222222000", "1294013905724312349120948120000"})
        void int_범위를_벗어난_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }

        @DisplayName("10원으로 나누어 떨어지지 않는 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"123", "1", "12 32 4 000 1"})
        void 단위가_10원이_아닌_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_UNIT.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"222000", "22222000", " 1   0    0  0   ", "10", "1230", "0"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }

    }
}