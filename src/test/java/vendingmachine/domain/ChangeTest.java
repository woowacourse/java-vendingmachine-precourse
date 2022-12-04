package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChangeTest {

    private final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @DisplayName("Change의 생성자 인자값은 10으로 나누어 떨어져야한다.")
    @Nested
    class checkChangeAmount {
        @ParameterizedTest(name = "amount가 {0} 이면 예외발생.")
        @CsvSource(value = {"21", "44", "1005"}, delimiter = ':')
        void case1(int amount) {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Change product = new Change(amount);
            });

            String message = exception.getMessage();
            Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
        }
    }
}