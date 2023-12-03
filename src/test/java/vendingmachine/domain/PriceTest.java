package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Nested
    class constructor {
        @DisplayName("금액이 100원 미만이면 오류를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1,0,99})
        void givenMoenyIsLowerThanHundred(int price) {
            Assertions.assertThatThrownBy(() -> new Price(price))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 가격이 100원 미만입니다!");
        }

        @DisplayName("금액이 10원으로 나누어 떨어지지 않으면 오류를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {101, 201, 301})
        void givenMoneyIsNotDividableByTen(int price) {
            Assertions.assertThatThrownBy(() -> new Price(price))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 10원으로 나누어지지 않습니다!");
        }
    }

    @Nested
    class isAvailable {
        @DisplayName("주어진 돈이 Price보다 적으면 거짓을 반환한다.")
        @Test
        void givenMoneyIsLowerThanPrice() {
            Price price = new Price(100);
            assertFalse(price.isAvailable(50));
        }

        @DisplayName("주어진 돈이 Price보다 많거나 같으면 참을 반환한다.")
        @Test
        void givenMoneyIsBiggerThanPrice() {
            Price price = new Price(100);
            assertAll(
                    () -> price.isAvailable(110),
                    () -> price.isAvailable(100)
            );
        }
    }

    class getPrice {
        @DisplayName("주어진 금액을 반환한다.")
        @Test
        void testGetPrice() {
            int price = 100;
            assertEquals(new Price(price).getPrice(), price);
        }
    }

}