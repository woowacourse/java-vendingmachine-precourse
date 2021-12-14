package vendingmachine.domain.coin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoinExchangeMachineTest {

    @Test
    void 입력과_같은_금액을_동전으로_반환() {
        int amountToChange = 1000;
        CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
        Coins coins = coinExchangeMachine.changeIntoCoins(amountToChange);

        assertThat(coins.getAmount()).isEqualTo(amountToChange);
    }
}
