package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.strategy.CoinCreateStrategy;
import vendingmachine.strategy.RandomCoinCreateStrategy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "+100", "money"})
    @DisplayName("입력받은 금액이 숫자가 아닌 경우 exception이 발생되어야 한다.")
    void createExceptionByStringMoney(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.valueOf(input))
            .withMessage("[ERROR] 금액은 양의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "1001", "100003"})
    @DisplayName("입력받은 금액이 10으로 나누어떨어지지 않는 경우 exception이 발생되어야 한다.")
    void createExceptionByShareLeastMoneyTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.valueOf(input))
            .withMessage("[ERROR] 금액은 10원으로 나누어떨어지는 금액만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("차감하려는 동전이 현재 금액보다 큰 경우 exception이 발생되어야 한다.")
    void cutOffByCoinExceptionByLargerThanRemainMoneyTest() {
        // given
        CoinCreateStrategy strategy = new RandomCoinCreateStrategy();
        Coin coin = strategy.createCoin();
        Money money = Money.valueOf("0");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> money.cutOffByCoin(coin))
            .withMessage("[ERROR] 차감하려는 동전이 현재 남아있는 금액보다 클 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "+100", "money"})
    @DisplayName("사용자 Money 충전 시 숫자가 입력되지 않는 경우 exception이 발생되어야 한다.")
    void chargeMoneyExceptionByStringMoneyTest(String input) {
        // given
        Money money = Money.init();

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> money.chargeMoney(input))
            .withMessage("[ERROR] 금액은 양의 숫자여야 합니다.");
    }
}