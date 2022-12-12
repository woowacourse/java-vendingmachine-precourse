package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vendingmachine.utils.Coin;

import java.util.Map;

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

    @Test
    @DisplayName("getChange 메소드는 자판기의 남은 잔돈을 줄인다.")
    void getChangeMethod() {
        Change coins = new Change(1000);
        Map<Coin, Integer> beforeChange = coins.getStoredChange();
        Map<Coin, Integer> returnChange = coins.getChange(1000);
        Map<Coin, Integer> afterChange = coins.getStoredChange();

        for (Coin key : beforeChange.keySet()) {
            Integer before = beforeChange.get(key);
            Integer after = afterChange.get(key);
            Assertions.assertTrue(before > after);
        }
    }
}