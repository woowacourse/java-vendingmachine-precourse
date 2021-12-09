package vendingmachine.inputvalue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.inputvalue.CoinBalanceInputValue;

class CoinBalanceInputValueTest {

    @Test
    void 입력된_문자열을_금액으로_변환() {
        String input = "10000";
        int expectedCoinBalance = 10000;
        CoinBalanceInputValue coinBalanceInputValue = new CoinBalanceInputValue(input);

        Assertions.assertThat(coinBalanceInputValue.toCoinBalance()).isEqualTo(expectedCoinBalance);
    }

    @Test
    void 숫자가_아닌_입력시_예외_발생() {
        String notDigitInput = "!";
        CoinBalanceInputValue coinBalanceInputValue = new CoinBalanceInputValue(notDigitInput);

        Assertions.assertThatThrownBy(coinBalanceInputValue::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건인_10원으로_나누어_떨어지지_않는_금액_입력시_예외_발생() {
        String notDigitInput = "123";
        CoinBalanceInputValue coinBalanceInputValue = new CoinBalanceInputValue(notDigitInput);

        Assertions.assertThatThrownBy(coinBalanceInputValue::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }
}
