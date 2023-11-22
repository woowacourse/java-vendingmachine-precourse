package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("상품 가격만큼 투입 금액을 차감한다.")
    @CsvSource({
            "1000, 9000",
            "2000, 8000",
            "3000, 7000",
            "10000, 0"
    })
    @ParameterizedTest
    void reduceAmount(int itemPrice, int expected) {
        Money money = new Money(10000);
        money.reduceAmount(itemPrice);
        assertThat(money.getAmount()).isEqualTo(expected);
    }
}
