package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    @DisplayName("현재 보유중인 coin의 종류를 반환할 수 있다.")
    void currentCoinsTest() {
        // given
        List<Integer> expected = Arrays.asList(500, 100, 50, 10);

        // when
        List<Integer> result = Coin.currentCoinAmounts();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 amount로 Coin을 반환하려고 하면 excpetion이 발생해야 한다.")
    void valueOfAmountExceptionByNotExistCoinTest() {
        // given
        int amount = 5;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Coin.valueOfAmount(amount))
            .withMessage("[ERROR] Coin의 종류에 존재하지 않는 Coin입니다.");
    }

    @Test
    @DisplayName("최소 coin금액을 반환할 수 있다.")
    void leastCoinTest() {
        // given
        int expected = 10;

        // when
        int result = Coin.leastCoin();

        // then
        assertThat(result).isEqualTo(expected);
    }
}