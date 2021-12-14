package vendingmachine.domain.coin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinPocketTest {
    private CoinPocket coinPocket;
    private int machineBalance;

    @BeforeEach
    void init() {
        coinPocket = CoinPocket.getInstance();
        machineBalance = 450;
    }

    @ParameterizedTest
    @ValueSource(strings = "100,100,100,100,50")
    void 입력한_만큼_동전_추출(String amountsString) {
        for (String amount : amountsString.split(","))
            putCoin(Integer.parseInt(amount));

        assertThat(coinPocket.countEachCoin(Coin.COIN_100)).isEqualTo(4);
        assertThat(coinPocket.countEachCoin(Coin.COIN_50)).isEqualTo(1);
    }

    private void putCoin(int amount) {
        machineBalance -= coinPocket.putCoinAndAddCount(machineBalance, (i) -> amount);
    }
}
