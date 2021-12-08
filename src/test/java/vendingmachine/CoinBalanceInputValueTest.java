package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinBalanceInputValueTest {

    @Test
    void 입력된_문자열을_금액으로_변환() {
        String input = "10000";
        int expectedCoinBalance = 10000;
        CoinBalanceInputValue coinBalanceInputValue = new CoinBalanceInputValue(input);

        Assertions.assertThat(coinBalanceInputValue.toCoinBalance()).isEqualTo(expectedCoinBalance);
    }
}
