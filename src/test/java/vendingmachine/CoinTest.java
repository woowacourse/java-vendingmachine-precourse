package vendingmachine;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinBox;

public class CoinTest {
    private CoinBox prepareCoin1000won() {
        CoinBox coinBox = new CoinBox();
        coinBox.generateRandomCoinBox(1000);
        return coinBox;
    }

    @Test
    public void test_random_coins_exact_coins() {
        assertRandomNumberInListTest(
            () -> {
                CoinBox coinBox = prepareCoin1000won();
                assertThat(coinBox.getCoinCount(Coin.COIN_500)).isEqualTo(2);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(1000);
            },
            500, 500
        );
    }

    @Test
    public void test_random_coins_exact_coins2() {
        assertSimpleTest(
            () -> {
                CoinBox coinBox = new CoinBox();
                coinBox.generateRandomCoinBox(1050);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(1050);
            }
        );
    }

    @Test
    public void test_random_coins_not_exact_coins() {
        assertRandomNumberInListTest(
            () -> {
                CoinBox coinBox = prepareCoin1000won();
                assertThat(coinBox.getCoinCount(Coin.COIN_10)).isEqualTo(5);
                assertThat(coinBox.getCoinCount(Coin.COIN_50)).isEqualTo(1);
                assertThat(coinBox.getCoinCount(Coin.COIN_100)).isEqualTo(4);
                assertThat(coinBox.getCoinCount(Coin.COIN_500)).isEqualTo(1);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(1000);
            },
            500, 100, 100, 100, 100, 50, 10
        );
    }

    @Test
    public void test_calculation_of_change_exact() {
        assertRandomNumberInListTest(
            () -> {
                CoinBox coinBox = prepareCoin1000won();
                int change = coinBox.getAvailableChange(350).getValueOfCoinBox();
                assertThat(change).isEqualTo(350);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(650);
                assertThat(coinBox.getCoinCount(500)).isEqualTo(1);
                assertThat(coinBox.getCoinCount(100)).isEqualTo(1);
                assertThat(coinBox.getCoinCount(10)).isEqualTo(5);
            },
            500, 100, 100, 100, 100, 50, 10
        );
    }

    @Test
    public void test_calculation_of_change_no_match_coinCost() {
        assertRandomNumberInListTest(
            () -> {
                CoinBox coinBox = prepareCoin1000won();
                int change = coinBox.getAvailableChange(9).getValueOfCoinBox();
                assertThat(change).isEqualTo(0);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(1000);
            },
            500, 100, 100, 100, 100, 50, 10
        );
    }

    @Test
    public void test_calculation_of_change_over_than_available() {
        assertRandomNumberInListTest(
            () -> {
                CoinBox coinBox = prepareCoin1000won();
                int change = coinBox.getAvailableChange(1234).getValueOfCoinBox();
                assertThat(change).isEqualTo(1000);
                assertThat(coinBox.getValueOfCoinBox()).isEqualTo(0);
            },
            500, 100, 100, 100, 100, 50, 10
        );
    }

    @Test
    public void test_not_included_coin() {
        CoinBox coinBox = new CoinBox();
        for (Coin coin : Coin.values()) {
            assertThat(coinBox.isIncluded(coin.getAmount())).isTrue();
        }
        //70 is not in Coin
        assertThat(coinBox.isIncluded(70)).isFalse();
    }

}
