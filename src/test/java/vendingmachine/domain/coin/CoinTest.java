package vendingmachine.domain.coin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    void 동전의_금액에_갯수를_곱해서_얼마인지_계산() {
        assertThat(Coin.COIN_500.getAmount(5)).isEqualTo(500 * 5);
    }
}
