package vendingmachine.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.model.Coin.*;

public class CoinTest {
    @Test
    void 모든_동전의_금액을_리스트로_반환() {
        assertThat(Coin.getAmounts()).containsExactly(500, 100, 50, 10);
    }

    @Test
    void 투입_금액에_맞는_동전_갯수_반환() {
        int coinCountA = COIN_500.changeIntoCoins(5000);
        int coinCountB = COIN_10.changeIntoCoins(5005);

        assertThat(coinCountA).isEqualTo(10);
        assertThat(coinCountB).isEqualTo(500);
    }
}
