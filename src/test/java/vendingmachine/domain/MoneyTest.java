package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @Nested
    class of {
        @DisplayName("입력이 숫자가 아니면 오류를 반환한다.")
        @Test
        void givenStringIsNotNumber() {
            assertThatThrownBy(() -> Money.of("야호!"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력이 숫자이면 정상적으로 생성한다.")
        @Test
        void givenStringIsNumber() {
            assertDoesNotThrow(() -> Money.of("1"));
        }
    }

    @Nested
    class getMoney {
        @DisplayName("금액을 잘 반환하는지 확인한다.")
        @Test
        void testGetMoney() {
            assertEquals(Money.of("1").getMoney(), 1);
        }
    }

    @Nested
    class reduce {
        @DisplayName("금액 이상의 액수를 줄이면 오류를 반환한다.")
        @Test
        void givenReduceIsBiggerThanMoney() {
            Money money = Money.of("1");
            assertThatThrownBy(() -> money.reduce(10))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("금액이 잘 줄어드는지 확인한다.")
        @Test
        void testReduce() {
            Money money = Money.of("100");
            money.reduce(10);
            assertEquals(money.getMoney(), 90);
        }
    }
}