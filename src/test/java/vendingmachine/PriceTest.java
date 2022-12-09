package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Money;
import vendingmachine.domain.products.Price;

import static org.assertj.core.api.Assertions.*;

public class PriceTest {

    private static final String EXCEPTION_MESSAGE_PRICE_RANGE =
            "[ERROR] 가격은 100 원 이상, 1000000000 원 이하 이어야 합니다.";
    private static final String EXCEPTION_MESSAGE_PRICE_DIVIDING = "[ERROR] 가격은 10 원으로 나누어 떨어져야 합니다.";
    private static final String EXCEPTION_MESSAGE_PRICE_NOT_PURCHASE = "[ERROR] 소지금액으로 해당 제품을 구매할 수 없습니다";

    @DisplayName("Price 클래스를 정상적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 1510, 1000000000})
    void createPriceSuccess(int input) {
        boolean result = true;
        try {
            Price.from(input);
        } catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("잘못된 범위의 금액이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 1, 99, 1000000001})
    void createPriceFailByRange(int input) {
        assertThatThrownBy(() -> Price.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PRICE_RANGE);
    }

    @DisplayName("10원으로 나눠지지 않는 금액이 들어올시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {101, 4999})
    void createPriceFailByDividing(int input) {
        assertThatThrownBy(() -> Price.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PRICE_DIVIDING);
    }

    @DisplayName("구매가 가능하면 true 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 490, 500})
    void isCheaperMoneySuccess(int input) {
        Money money = Money.from(500);
        Price price = Price.from(input);
        assertThat(price.validateMoney(money)).isEqualTo(true);
    }

    @DisplayName("구매가 불가능하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {510, 5000})
    void isCheaperMoneyFail(int input) {
        Money money = Money.from(500);
        Price price = Price.from(input);
        assertThatThrownBy(() -> price.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PRICE_NOT_PURCHASE);
    }
}
