package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.coins.Coin;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinTest {

    @DisplayName("입력한 코인금액에 맞는 코인을 반환한다.")
    @Test
    void getCoinByAmountSuccess() {
        assertThat(Coin.of(10)).isEqualTo(Coin.COIN_10);
        assertThat(Coin.of(50)).isEqualTo(Coin.COIN_50);
        assertThat(Coin.of(100)).isEqualTo(Coin.COIN_100);
        assertThat(Coin.of(500)).isEqualTo(Coin.COIN_500);
    }

    @DisplayName("amount 만 담은 리스트를 반환한다.")
    @Test
    void makeAmountListSuccess() {
        List<Integer> amounts = Arrays.asList(500, 100, 50, 10);
        assertThat(Coin.makeAmountList()).isEqualTo(amounts);
    }

    @DisplayName("amount 중 최소값을 반환한다.")
    @Test
    void findMinAmountSuccess() {
        assertThat(Coin.findMinAmount()).isEqualTo(10);
    }
}
