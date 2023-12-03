package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

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

    @Nested
    class getRests {
        @DisplayName("잔돈을 잘 구하는지 확인한다.")
        @Test
        void testGetRests() {
            Wallet wallet = new Wallet(510);
            Money money = mock(Money.class);
            given(money.getMoney()).willReturn(110);

            List<CoinCount> coinCounts = wallet.getRests(money);
            String message = coinCounts.stream()
                    .map(CoinCount::getMessage)
                    .collect(Collectors.joining("\n"));

            assertEquals(message, "10원 - 1개");
        }
    }
}