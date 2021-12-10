package vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.Coin.*;

public class CoinTest {
    @Test
    void 투입_금액에_맞는_동전_갯수_반환() {
        int coinCountA = COIN_500.changeIntoCoins(5000);
        int coinCountB = COIN_10.changeIntoCoins(5005);

        assertThat(coinCountA).isEqualTo(10);
        assertThat(coinCountB).isEqualTo(500);
    }
}
