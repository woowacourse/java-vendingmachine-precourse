package vendingmachine.domain.vendingMachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

class ChangeAccountantTest {

    @Test
    void 거스름돈을_가장_적은_개수로_반환() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_100, 4);
        coins.add(Coin.COIN_50, 10);

        ChangeAccountant changeAccountant = new ChangeAccountant();
        Coins change = changeAccountant.change(400, coins);

        assertThat(change.count(Coin.COIN_500)).isEqualTo(0);
        assertThat(change.count(Coin.COIN_100)).isEqualTo(4);
        assertThat(change.count(Coin.COIN_50)).isEqualTo(0);
        assertThat(change.count(Coin.COIN_10)).isEqualTo(0);
    }

    @Test
    void 잔돈으로_반환할_금액만_반환() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_500, 1);

        ChangeAccountant changeAccountant = new ChangeAccountant();
        Coins change = changeAccountant.change(400, coins);

        assertThat(change.getAmount()).isEqualTo(0);
    }

    @Test
    void 거슬러_주려는_금액이_동전_총액보다_많으면_동전을_전부_돌려준다() {
        ChangeAccountant changeAccountant = new ChangeAccountant();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_50);

        int amountToChange = 1000;
        Coins change = changeAccountant.change(amountToChange, coins);

        assertThat(amountToChange).isGreaterThan(coins.getAmount());
        for (Coin coinUnit : Coin.getAlCoinUnitsFromLargestToSmallest()) {
            assertThat(change.count(coinUnit)).isEqualTo(coins.count(coinUnit));
        }
    }

    @Test
    void 거슬러주지_못한_금액을_반환() {
        ChangeAccountant changeAccountant = new ChangeAccountant();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        int amountToChange = 1050;

        Coins change = changeAccountant.change(amountToChange, coins);

        assertThat(changeAccountant.getRestAfterCalculation()).isEqualTo(amountToChange - change.getAmount());
    }
}
