package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

class ChangeAccountantTest {

    @Test
    void 거스름돈을_가장_적은_개수로_반환() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100, 4);
        coins.add(Coin.COIN_50, 1);

        ChangeAccountant changeAccountant = new ChangeAccountant();
        Coins change = changeAccountant.change(500, coins);

        assertThat(change.count(Coin.COIN_500)).isEqualTo(0);
        assertThat(change.count(Coin.COIN_100)).isEqualTo(4);
        assertThat(change.count(Coin.COIN_50)).isEqualTo(1);
        assertThat(change.count(Coin.COIN_10)).isEqualTo(0);
        assertThat(changeAccountant.getRestAfterCalculation()).isEqualTo(50);
    }
}
