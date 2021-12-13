package vendingmachine.domain.investmentmoney;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.Coin;
import vendingmachine.domain.possessioncoin.PossessionCoin;
import vendingmachine.domain.product.Product;

class InvestmentMoneyTest {

    @DisplayName("투입 금액이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"3000", "1000", "150"})
    void constructor_InputInvestmentMoneyString_Create(String inputInvestmentMoney) {
        // given & when & then
        assertThatCode(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).doesNotThrowAnyException();
    }

    @DisplayName("투입 금액이 정수가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3000a", "10a00", "a150"})
    void constructor_InputInvestmentMoneyNotNumberFormat_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액이 음수이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-3000", "-100", "-1000"})
    void constructor_InputInvestmentMoneyNegativeNumber_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액이 10으로 나누어 떨어지지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3333", "111"})
    void constructor_InputInvestmentMoneyNotDivided10_ExceptionThrown(String inputInvestmentMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new InvestmentMoney(inputInvestmentMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입 금액이 상품의 가격보다 작은 경우 예외를 던진다.")
    @Test
    void calculate_InvestmentMoneyLessThanPrice_ExceptionThrown() {
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

    @DisplayName("투입 금액이 상품 가격보다 크거나 같은 경우 true를 반환한다.")
    @Test
    void isPay_InvestmentMoneyMoreThanPrice_True() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("2000");
        Product product = new Product("[콜라,1500,10]");

        // when
        boolean result = investmentMoney.isPay(product);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("투입 금액이 상품 가격보다 작은 경우 False를 반환한다.")
    @Test
    void isPay_InvestmentMoneyLessThanPrice_False() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("1400");
        Product product = new Product("[콜라,1500,10]");

        // when
        boolean result = investmentMoney.isPay(product);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("투입 금액이 보유 동전보다 크거나 같으면 잔돈 변경 가능하므로 true를 반환한다.")
    @Test
    void isPossibleChange_InvestmentMoneyMoreThanCoinAmount_True() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("100");
        PossessionCoin possessionCoin = new PossessionCoin(Coin.COIN_100, 10);

        // when
        boolean result = investmentMoney.isPossibleChange(possessionCoin);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("투입 금액이 보유 동전보다 작은 경우 잔돈 변경이 불가능 하므로 false를 반환한다.")
    @Test
    void isPossibleChange_InvestmentMoneyLessThanCoinAmount_False() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("60");
        PossessionCoin possessionCoin = new PossessionCoin(Coin.COIN_100, 10);

        // when
        boolean result = investmentMoney.isPossibleChange(possessionCoin);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("동전의 amount와 quantity가 주어지면 가능한 변경 개수와 나눈 몫을 비교하여 차감한 후 가능한 개수를 반환한다.")
    @Test
    void trade_QuotientCompareToQuantity_MinCoinQuantity() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("500");
        int amount = 500;
        int quantity = 10;

        // when
        int minCoinQuantity = investmentMoney.trade(amount, quantity);

        // then
        assertThat(minCoinQuantity).isEqualTo(1);
    }
}