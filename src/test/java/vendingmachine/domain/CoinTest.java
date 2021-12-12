package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        List<Integer> result = Coin.currentCoins();

        // then
        assertThat(result).isEqualTo(expected);
    }
}