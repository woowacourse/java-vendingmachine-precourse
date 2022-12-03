package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest {

    private final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @Test
    @DisplayName("consume을 호출하면 total이 1 줄어든다.")
    void testConsumeMethod() {
        Product product = new Product("사이다", 100, 1);
        product.consume();
        Assertions.assertEquals(0, product.getTotal());
    }

    @Test
    @DisplayName("total이 0 이하일때 consume을 호출하면 예외")
    void testConsumeMethodException() {
        Product product = new Product("사이다", 100, 1);
        product.consume();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, product::consume);

        String message = exception.getMessage();
        Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
    }

    @DisplayName("Product의 amount가 100보다 작거나 10으로 나누어 떨어지지 않으면 예외")
    @Nested
    class checkProductAmount {
        @ParameterizedTest(name = "가격이 {1} 이면 예외발생.")
        @CsvSource(value = {"사이다:1:1", "사이다:101:1"}, delimiter = ':')
        void case1(String name, int amount, int total) {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Product product = new Product(name, amount, total);
            });

            String message = exception.getMessage();
            Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
        }
    }

    @DisplayName("Product의 tatal이 0미만이면 예외")
    @Nested
    class checkProductTotal {
        @ParameterizedTest(name = "total이 {2} 이면 예외발생.")
        @CsvSource(value = {"사이다:100:0", "사이다:100:-1"}, delimiter = ':')
        void case1(String name, int amount, int total) {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Product product = new Product(name, amount, total);
            });

            String message = exception.getMessage();
            Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
        }
    }


}