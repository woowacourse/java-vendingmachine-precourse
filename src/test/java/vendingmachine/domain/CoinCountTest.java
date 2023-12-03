package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Coin;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoinCountTest {
    @Nested
    class build {
        @DisplayName("잔돈을 잘 구하는지 확인한다.")
        @Test
        void testBuild() {
            List<CoinCount> coinCounts = CoinCount.build(110);
            List<String> messages = coinCounts.stream()
                    .map(CoinCount::getMessage)
                    .collect(Collectors.toList());
            assertThat(messages)
                    .contains(
                            "500원 - 0개",
                            "100원 - 1개",
                            "50원 - 0개",
                            "10원 - 1개"
                    );
        }
    }

    @Nested
    class getMessage {
        @DisplayName("메시지를 잘 구하는지 확인한다.")
        @Test
        void testGetMessage() {
            CoinCount coinCount = new CoinCount(Coin.COIN_10, 1);
            assertThat(coinCount.getMessage())
                    .contains("10원 - 1개");
        }
    }

    @Nested
    class isZero {
        @DisplayName("count가 0일 때, isZero가 참을 반환한다.")
        @Test
        void givenCountIsZero() {
            CoinCount coinCount = new CoinCount(Coin.COIN_10, 0);
            assertTrue(coinCount.isZero());
        }
    }
}