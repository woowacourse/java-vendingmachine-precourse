package vendingmachine.coin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinExchangeMachineTest {

    @Test
    void 입력과_같은_금액을_동전으로_반환() {
        int amountToChange = 1000;
        CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
        Coins change = coinExchangeMachine.changeIntoCoins(amountToChange);

        int resultAmount = 0;
        for (Coin unit : Coin.getAllKindsOfCoinFromLargestToSmallest()) {
            resultAmount += unit.getAmount(change.count(unit));
        }
        Assertions.assertThat(resultAmount).isEqualTo(amountToChange);
    }
}
