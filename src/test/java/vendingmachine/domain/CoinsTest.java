package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("잔돈을 반환할 수 있다.")
    class ChangeCoinsTest {

        private Coins coins;
        private Map<Coin, Integer> expected;

        @BeforeEach
        void beforeEach() {
            Map<Coin, Integer> coinMap = Coin.createEmptyCoinMap();
            coinMap.put(Coin.valueOfAmount(100), 4);
            coinMap.put(Coin.valueOfAmount(50), 1);
            coins = new Coins(coinMap);

            expected = new TreeMap<>(coinMap);
        }

        @Test
        @DisplayName("남는 금액 없이 잔돈을 반환할 수 있다.")
        void changeCoinsTest() {
            // given
            Money money = Money.valueOf("450");
            Money remainMoney = Money.init();

            // when
            Map<Coin, Integer> result = coins.changeCoins(money);

            // then
            assertAll(
                () -> assertThat(result).isEqualTo(expected),
                () -> assertThat(money.currentMoney()).isEqualTo(remainMoney.currentMoney())
            );
        }

        @Test
        @DisplayName("잔돈을 다 반환할 수 없다면 반환할 수 있는 금액만 반환한다.")
        void changeCoinsRemainMoneyTest() {
            // given
            Money money = Money.valueOf("600");
            Money remainMoney = Money.valueOf("150");

            // when
            Map<Coin, Integer> result = coins.changeCoins(money);

            // then
            assertAll(
                () -> assertThat(result).isEqualTo(expected),
                () -> assertThat(money.currentMoney()).isEqualTo(remainMoney.currentMoney())
            );
        }
    }
}
