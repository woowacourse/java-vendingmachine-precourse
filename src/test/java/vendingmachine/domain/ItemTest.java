package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @DisplayName("상품의 가격이 100원 미만이거나, 10원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 99, 149, 1009})
    @ParameterizedTest
    void makeItemWrongPrice(int price) {
        Assertions.assertThatThrownBy(() -> new Item("콜라", price, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품의 이름이 맞는지 확인한다.")
    @CsvSource({"콜라, true", "환타, false"})
    @ParameterizedTest
    void checkItemName(String name, boolean expected) {
        Item item = new Item("콜라", 1000, 10);
        boolean result = item.isSameName(name);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("상품의 수량을 1개 차감한다.")
    @Test
    void reduceQuantity() {
        Item item = new Item("콜라", 1000, 10);
        item.reduceQuantity();
        assertThat(item.getQuantity()).isEqualTo(9);
    }
}
