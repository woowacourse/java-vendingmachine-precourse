package vendingmachine.coin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoinsTest {

    @Test
    void Coin객체로_동전_추가_가능() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);

        assertThat(coins.count(Coin.COIN_100)).isEqualTo(2);
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
                () -> assertThat(coins.count(Coin.COIN_500)).isEqualTo(1),
                () -> assertThat(coins.count(Coin.COIN_100)).isEqualTo(1),
                () -> assertThat(coins.count(Coin.COIN_50)).isEqualTo(0),
                () -> assertThat(coins.count(Coin.COIN_10)).isEqualTo(0)
        );
    }
}
