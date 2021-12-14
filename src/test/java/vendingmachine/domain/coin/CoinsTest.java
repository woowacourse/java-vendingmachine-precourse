package vendingmachine.domain.coin;

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
    void Coin_개수로_동전_추가_가능() {
        Coins coins = new Coins();
        Coin coinUnit = Coin.COIN_50;
        int numberOfCoin = 2;
        coins.add(coinUnit, numberOfCoin);

        assertThat(coins.count(coinUnit)).isEqualTo(numberOfCoin);
    }

    @Test
    void Coins끼리의_뺄셈_가능() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100, 2);
        Coins coinsToTake = new Coins();
        coinsToTake.add(Coin.COIN_100, 1);

        coins.take(coinsToTake);

        assertThat(coins.count(Coin.COIN_100)).isEqualTo(1);
    }

    @Test
    void 빼는_동전이_더_많은_경우_동전의_수를_0으로_변경() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100, 2);
        Coins coinsToTake = new Coins();
        coinsToTake.add(Coin.COIN_100, 3);

        coins.take(coinsToTake);

        assertThat(coins.count(Coin.COIN_100)).isEqualTo(0);
    }

    @Test
    void 총액_구하기() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_50);
        int expectedResult = Coin.COIN_500.getAmount() + Coin.COIN_50.getAmount();

        assertThat(coins.getAmount()).isEqualTo(expectedResult);
    }
}
