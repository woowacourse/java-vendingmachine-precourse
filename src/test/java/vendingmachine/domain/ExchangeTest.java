package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExchangeTest {

    private final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @DisplayName("Exchange의 생성자 인자값은 10으로 나누어 떨어져야한다.")
    @Nested
    class checkExchangeAmount {
        @ParameterizedTest(name = "amount가 {0} 이면 예외발생.")
        @CsvSource(value = {"0", "21", "44", "1005"}, delimiter = ':')
        void case1(int amount) {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Exchange product = new Exchange(amount);
            });

            String message = exception.getMessage();
            Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
        }
    }

    @Test
    @DisplayName("Exchange의 생성 금액은 getTotalPrice와 같다.")
    void cash_ConstructorParameter_Equals_GetTotalPriceMethod() {
        Exchange cash = new Exchange(2000);
        Assertions.assertEquals(2000, cash.getTotalPrice());
    }
}