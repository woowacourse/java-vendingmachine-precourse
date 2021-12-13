package vendingmachine.domain.investmentmoney;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.product.Product;

class InvestmentMoneyTest {

    @DisplayName("투입 금액이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"3000", "1000", "150"})
    void constructor_InputInvestmentMoneyThenString_Create(String inputInvestmentMoney) {
        // given & when & then
        assertThatCode(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).doesNotThrowAnyException();
    }

    @DisplayName("투입 금액이 정수가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3000a", "10a00", "a150"})
    void constructor_InputInvestmentMoneyThenNotNumberFormat_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액이 음수이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-3000", "-100", "-1000"})
    void constructor_InputInvestmentMoneyThenNegativeNumber_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액이 10으로 나누어 떨어지지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3333", "111"})
    void constructor_InputInvestmentMoneyThenNotDivided10_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액보다 상품의 가격이 큰 경우 예외를 던진다.")
    @Test
    void calculate_ProductPriceLessThenInvestmentMoney_ExceptionThrown() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("1000");
        Product product = new Product("[콜라,1500,10]");

        // when
        int price = product.getPrice();

        // then
        assertThatThrownBy(() -> {
            investmentMoney.calculate(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}