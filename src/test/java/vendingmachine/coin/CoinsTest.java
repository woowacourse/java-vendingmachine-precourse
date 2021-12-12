package vendingmachine.coin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

class CoinsTest {

    @Test
    void Coin객체로_동전_추가_가능() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        int expectedResult = Coin.COIN_100.getAmount() + Coin.COIN_50.getAmount();

        Assertions.assertThat(coins.getAmount()).isEqualTo(expectedResult);
    }

    @Test
    void Coins끼리의_뺄셈_가능() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_500, 1);
        coins.add(Coin.COIN_100, 2);
        coins.add(Coin.COIN_50, 3);

        Coins coinsToTake = new Coins();
        coinsToTake.add(Coin.COIN_100, 1);
        coinsToTake.add(Coin.COIN_50, 3);
        coinsToTake.add(Coin.COIN_10, 2);

        coins.take(coinsToTake);

        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(coins.count(Coin.COIN_500)).isEqualTo(1),
                () -> Assertions.assertThat(coins.count(Coin.COIN_100)).isEqualTo(1),
                () -> Assertions.assertThat(coins.count(Coin.COIN_50)).isEqualTo(0),
                () -> Assertions.assertThat(coins.count(Coin.COIN_10)).isEqualTo(0)
        );
    }
}
