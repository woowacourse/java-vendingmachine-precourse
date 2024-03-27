package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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

    @Test
    void 반환할_잔돈_계산_테스트_정확히_반환할_수_있는_경우() {
        // given
        Map<Coin, Integer> coinMap = new HashMap<>();
        coinMap.put(Coin.COIN_500, 0);
        coinMap.put(Coin.COIN_100, 10);
        coinMap.put(Coin.COIN_50, 0);
        coinMap.put(Coin.COIN_10, 10);
        Coins coins = new Coins(coinMap);
        // when
        Coins change = coins.calculateChange(450);
        // then
        assertThat(change.getSumOfCoins()).isEqualTo(450);
    }

    @Test
    void 반환할_잔돈_계산_테스트_잔돈의_총합이_반환금액_이상이지만_정확히_반환할_수_없는_경우() {
        // given
        Map<Coin, Integer> coinMap = new HashMap<>();
        coinMap.put(Coin.COIN_500, 10);
        coinMap.put(Coin.COIN_100, 0);
        coinMap.put(Coin.COIN_50, 0);
        coinMap.put(Coin.COIN_10, 0);
        Coins coins = new Coins(coinMap);
        // when
        Coins change = coins.calculateChange(800);
        // then
        assertThat(change.getSumOfCoins()).isEqualTo(500);
    }

    @Test
    void 반환할_잔돈_계산_테스트_잔돈의_총합이_반환금액_미만인_경우() {
        // given
        Map<Coin, Integer> coinMap = new HashMap<>();
        coinMap.put(Coin.COIN_500, 0);
        coinMap.put(Coin.COIN_100, 1);
        coinMap.put(Coin.COIN_50, 0);
        coinMap.put(Coin.COIN_10, 0);
        Coins coins = new Coins(coinMap);
        // when
        Coins change = coins.calculateChange(1000);
        // then
        assertThat(change.getSumOfCoins()).isEqualTo(100);
    }
}