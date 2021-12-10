package vendingmachine.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.dto.request.CoinBalanceRequest;

class CoinBalanceRequestTest {

    @Test
    void 입력된_문자열을_금액으로_변환() {
        String input = "10000";
        int expectedCoinBalance = 10000;
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(input);

        Assertions.assertThat(coinBalanceRequest.toCoinBalance()).isEqualTo(expectedCoinBalance);
    }

    @Test
    void 숫자가_아닌_입력시_예외_발생() {
        String notDigitInput = "!";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(notDigitInput);

        Assertions.assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건인_10원으로_나누어_떨어지지_않는_금액_입력시_예외_발생() {
        String notDigitInput = "123";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(notDigitInput);

        Assertions.assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건인_10원보다_적은_금액_입력시_예외_발생() {
        String lessThanTenWonInput = "9";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(lessThanTenWonInput);

        Assertions.assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }
}
