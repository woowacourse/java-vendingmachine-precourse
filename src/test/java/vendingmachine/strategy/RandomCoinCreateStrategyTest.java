package vendingmachine.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import vendingmachine.domain.Coin;

class RandomCoinCreateStrategyTest {

    @RepeatedTest(20)
    @DisplayName("정해진 범위의 코인을 반복해서 반화할 수 있다.")
    void createCoinRangeTest() {
        // given
        CoinCreateStrategy strategy = new RandomCoinCreateStrategy();

        // when
        Coin result = strategy.createCoin();

        // then
        assertThat(result).isInstanceOf(Coin.class);
    }
}