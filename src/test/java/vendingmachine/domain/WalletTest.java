package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WalletTest {
    @Nested
    class constructor {
        @DisplayName("금액이 0원 미만이면 오류를 반환한다.")
        @Test
        void givenMoneyIsLowerThanZero() {
            Assertions.assertThatThrownBy(() -> new Wallet(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class getMessage {
        @DisplayName("메시지가 잘 만들어지는지 확인한다.")
        @Test
        void testGetMessage() {
            Wallet wallet = new Wallet(110);
            assertThat(wallet.getMessage())
                    .contains(
                            "500원 - 0개",
                            "100원 - 1개",
                            "50원 - 0개",
                            "10원 - 1개"
                    );
        }
    }
}