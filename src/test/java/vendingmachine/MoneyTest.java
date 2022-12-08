package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Money;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    private static final String EXCEPTION_MESSAGE_MONEY_RANGE = "[ERROR] 돈은 0 원 이상, 1000000000 원 이하 이어야 합니다.";

    @DisplayName("돈 클래스를 정상적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 99999999, 1000000000})
    void createMoneySuccess(int input) {
        boolean result = true;
        try {
            Money.from(input);
        } catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("잘못된 범위의 금액이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, 1000000001})
    void createMoneyFail(int input) {
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_MONEY_RANGE);
    }

    @DisplayName("지불 가능한 돈이면 true 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 50, 100, 499, 500})
    void isUseMoneyTrue(int input) {
        Money money = Money.from(500);
        assertThat(money.isUseMoney(input)).isEqualTo(true);
    }

    @DisplayName("돈을 정상적으로 지불한다.")
    @Test
    void useMoneySuccess() {
        Money money = Money.from(500);
        money.useMoney(1);
        money.useMoney(50);
        money.useMoney(122);
        money.useMoney(27);
        assertThat(money).extracting("money").isEqualTo(300);
    }
}
