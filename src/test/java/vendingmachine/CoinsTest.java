package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.coins.Coin;
import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.coins.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class CoinsTest {

    @DisplayName("랜덤한 코인을 성공적으로 생성한다.")
    @Test
    void makeRandomCoinsSuccess() {
        Coins coins = new Coins();
        coins.makeRandomCoins(new TestNumberGenerator(newArrayList(500, 500, 100, 100, 50, 50, 10, 50, 10, 10))
                , Money.from(676));

        assertThat(coins.getCoins().get(Coin.COIN_500)).isEqualTo(1);
        assertThat(coins.getCoins().get(Coin.COIN_100)).isEqualTo(1);
        assertThat(coins.getCoins().get(Coin.COIN_50)).isEqualTo(1);
        assertThat(coins.getCoins().get(Coin.COIN_10)).isEqualTo(2);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate(List<Integer> test) {
            return numbers.remove(0);
        }
    }
}
