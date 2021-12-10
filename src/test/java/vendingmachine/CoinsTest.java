package vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinsTest {

    @Test
    void Coin객체로_동전_추가_가능() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        int expectedResult = Coin.COIN_100.getAmount() + Coin.COIN_50.getAmount();

        Assertions.assertThat(coins.getAmount()).isEqualTo(expectedResult);
    }

}
