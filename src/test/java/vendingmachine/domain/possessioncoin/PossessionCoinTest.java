package vendingmachine.domain.possessioncoin;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coin;
import vendingmachine.domain.investmentmoney.InvestmentMoney;

class PossessionCoinTest {

    @DisplayName("수량이 0개 초과이면 true를 반환한다.")
    @Test
    void isExistQuantity_QuantityGraterThan0_True() {
        // given
        PossessionCoin possessionCoin = new PossessionCoin(Coin.COIN_100, 10);

        // when
        boolean result = possessionCoin.isExistQuantity();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("수량이 0개 이하이면 false를 반환한다.")
    @Test
    void isExistQuantity_QuantityNotMoreThan0_False() {
        // given
        PossessionCoin possessionCoin = new PossessionCoin(Coin.COIN_100, 0);

        // when
        boolean result = possessionCoin.isExistQuantity();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("투입 금액이 주어지면 현재 가진 동전의 개수와 교환 가능한 동전 개수를 비교하여 잔돈의 개수를 반환한다.")
    @Test
    void calculate_InvestmentMoneyCompareQuantity_MinCoinQuantity() {
        // given
        String inputInvestmentMoney = "1000";
        InvestmentMoney investmentMoney = new InvestmentMoney(inputInvestmentMoney);

        Coin coin = Coin.COIN_100;
        int quantity = 5;
        PossessionCoin possessionCoin = new PossessionCoin(coin, quantity);

        // when
        int changeQuantity = possessionCoin.calculate(investmentMoney);
        int min = Math.min(Integer.parseInt(inputInvestmentMoney) / coin.getAmount(), quantity);

        // then
        assertThat(changeQuantity).isEqualTo(min);
    }
}