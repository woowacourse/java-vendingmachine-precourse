package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {

    @DisplayName("상품의 가격이 100원 미만이거나, 10원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 99, 149, 1009})
    @ParameterizedTest
    void makeItemWrongPrice(int price) {
        Assertions.assertThatThrownBy(() -> new Item("콜라", price, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
