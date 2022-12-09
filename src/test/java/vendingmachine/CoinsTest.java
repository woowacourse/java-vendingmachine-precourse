package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vendingmachine.domain.coins.Coin;
import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.coins.NumberGenerator;

import java.util.EnumMap;
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

    @DisplayName("잔돈을 성공적으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1100, 1, 2, 4, 20", "1000, 0, 2, 4, 20", "800, 0, 2, 4, 20", "500, 0, 1, 4, 20", "400, 0, 0, 4, 20",
            "350, 0, 0, 3, 20", "200, 0, 0, 0, 20", "220, 0, 0, 0, 20", "130, 0, 0, 0, 13", "0, 0, 0, 0, 0"})
    void makeLargestCoinsSuccess(int money, int coin500, int coin100, int coin50, int coin10) {
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
        coins.put(Coin.COIN_500, 1);
        coins.put(Coin.COIN_100, 2);
        coins.put(Coin.COIN_50, 4);
        coins.put(Coin.COIN_10, 20);
        Coins temp = new Coins(coins);
        Coins changes = temp.makeLargestCoins(Money.from(money));

        assertThat(changes.getCoins().get(Coin.COIN_500)).isEqualTo(coin500);
        assertThat(changes.getCoins().get(Coin.COIN_100)).isEqualTo(coin100);
        assertThat(changes.getCoins().get(Coin.COIN_50)).isEqualTo(coin50);
        assertThat(changes.getCoins().get(Coin.COIN_10)).isEqualTo(coin10);
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
