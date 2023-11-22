package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoinMakerTest {

    CoinMaker coinMaker = new CoinMaker();

    @DisplayName("자판기 보유 금액만큼 동전을 만든다.")
    @ValueSource(ints = {500, 1000, 15000})
    @ParameterizedTest
    void makeCoins(int amount) {
        //given, when
        Map<Coin, Integer> coins = coinMaker.make(amount);

        int totalAmount = coins.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        //then
        assertThat(totalAmount).isEqualTo(amount);
    }
}
