package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoinsTest {

    @Test
    @DisplayName("Money를 받아 그만큼의 coin을 가지고 있는 Coins를 생성할 수 있다.")
    void createByMoneyTest() {
        // given
        Money money = Money.valueOf("100");
        Coin coin = Coin.valueOfAmount(10);
        Coins coins = Coins.createByMoney(money, () -> coin);

        Map<Coin, Integer> expected = Coin.createEmptyCoinMap();
        expected.put(coin, expected.get(coin) + 10);

        // when
        Map<Coin, Integer> result = coins.currentRemainCoins();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("잔돈을 반환할 수 있다.")
    void changeCoinsTest() {
        // given
        Money money = Money.valueOf("500");
        Map<Coin, Integer> coinMap = Coin.createEmptyCoinMap();
        coinMap.put(Coin.valueOfAmount(100), 4);
        coinMap.put(Coin.valueOfAmount(50), 1);
        Coins coins = new Coins(coinMap);

        Map<Coin, Integer> expected = new TreeMap<>(coinMap);

        // when
        Map<Coin, Integer> result = coins.changeCoins(money);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
