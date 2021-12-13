package vendingmachine.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CoinBalanceRequestTest {

    @Test
    void 입력된_문자열을_금액으로_변환() {
        String input = "10000";
        int expectedCoinBalance = 10000;
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(input);

        assertThat(coinBalanceRequest.toCoinBalance()).isEqualTo(expectedCoinBalance);
    }

    @Test
    void 숫자가_아닌_입력시_예외_발생() {
        String notDigitInput = "!";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(notDigitInput);

        assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건인_10원으로_나누어_떨어지지_않는_금액_입력시_예외_발생() {
        String notDigitInput = "123";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(notDigitInput);

        assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건인_10원보다_적은_금액_입력시_예외_발생() {
        String lessThanTenWonInput = "9";
        CoinBalanceRequest coinBalanceRequest = new CoinBalanceRequest(lessThanTenWonInput);

        assertThatThrownBy(coinBalanceRequest::toCoinBalance).isInstanceOf(IllegalArgumentException.class);
    }
}
