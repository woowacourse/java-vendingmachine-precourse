package vendingmachine.domain.possessionmoney;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PossessionMoneyTest {

    @DisplayName("문자열 보유 금액이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"450", "1000", "10", "2500"})
    void constructor_PossessionMoneyThenString_Create(String inputPossessionMoney) {
        // given & when & then
        assertThatCode(() -> {
            new PossessionMoney(inputPossessionMoney);
        }).doesNotThrowAnyException();
    }

    @DisplayName("숫자가 아닌 보유 금액이 주어지면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"450a", "10a00", "a10", " 2500", " "})
    void constructor_PossessionMoneyNotNumberFormat_ExceptionThrown(String inputPossessionMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new PossessionMoney(inputPossessionMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보유 금액이 음수로 주어지면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-450"})
    void constructor_PossessionMoneyNegativeNumber_ExceptionThrown(String inputPossessionMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new PossessionMoney(inputPossessionMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보유 금액이 10으로 나누어 떨어지지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"11", "455", "123", "2501"})
    void constructor_PossessionMoneyNotDivide_ExceptionThrown(String inputPossessionMoney) {
        // given & when & then
        assertThatThrownBy(() -> {
            new PossessionMoney(inputPossessionMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보유 금액이 0원 이상이면 true를 반환한다.")
    @Test
    void isExist_PossessionMoneyGraterThan0_True() {
        // given
        PossessionMoney possessionMoney = new PossessionMoney("100");

        // when
        boolean result = possessionMoney.isExist();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("보유 금액이 0원 이하이면 False를 반환한다.")
    @Test
    void isExist_PossessionMoneyNotMoreThan0_False() {
        // given
        PossessionMoney possessionMoney = new PossessionMoney("0");

        // when
        boolean result = possessionMoney.isExist();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("보유 금액이 amount보다 크거나 같으면 true를 반환한다.")
    @Test
    void isCalculate_PossessionMoneyMoreThanAmount_True() {
        // given
        PossessionMoney possessionMoney = new PossessionMoney("1000");

        // when
        boolean result = possessionMoney.isCalculate(500);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("보유 금액이 amount보다 작은 경우 False를 반환한다.")
    @Test
    void isCalculate_PossessionMoneyLessThanAmount_False() {
        // given
        PossessionMoney possessionMoney = new PossessionMoney("400");

        // when
        boolean result = possessionMoney.isCalculate(500);

        // then
        assertThat(result).isFalse();
    }
}