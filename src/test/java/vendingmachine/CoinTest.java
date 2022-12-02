package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.model.Balance;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoinTest {

    @ParameterizedTest
    @ValueSource(ints = {500, 30410, 391740})
    @DisplayName("동전 생성 테스트")
    void createCoinTest(int input) {
        Balance balance = new Balance(input);
        Map<Coin, Integer> coins = balance.createCoin();
        int sum = 0;
        for (Coin coin : Coin.values()) {
            sum += coin.get() * coins.get(coin);
        }
        assertThat(sum).isEqualTo(input);
    }
}
