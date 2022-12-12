package vendingmachine.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    @DisplayName("Coin의 of method에 존재하지 않는 값을 넣으면 예외")
    void testCoinOfMethod() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Coin.of(13);
        });

        String message = exception.getMessage();
        final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
        Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
    }

    @Test
    @DisplayName("Coin의 getRandomAmount method에 최소금액으로 나누어 떨어지지 않는 수를 넣으면 예외")
    void testCoinGetRandomAmountMethod() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Coin.getRandomAmount(1);
        });

        String message = exception.getMessage();
        final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
        Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
    }
}