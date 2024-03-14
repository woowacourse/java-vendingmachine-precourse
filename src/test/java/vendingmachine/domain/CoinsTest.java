package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    @Test
    void getSumofCoins_테스트() {
        // given
        Map<Coin, Integer> givenCoins = new HashMap<>();
        givenCoins.put(Coin.COIN_10, 2);
        givenCoins.put(Coin.COIN_50, 3);
        givenCoins.put(Coin.COIN_100, 4);
        givenCoins.put(Coin.COIN_500, 5);
        int correctSum = 10*2 + 50*3 + 100*4 + 500*5;
        Coins coins = new Coins(givenCoins);
        // when
        int sumOfCoins = coins.getSumOfCoins();
        // then
        assertThat(sumOfCoins).isEqualTo(correctSum);
    }
}