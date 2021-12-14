package vendingmachine.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {
    @Test
    void 상품명_가격_수량으로_이루어져_있다() {
        Product goods = new Product("콜라,1500,20");

        assertThat(goods.getName()).isEqualTo("콜라");
        assertThat(goods.getPrice()).isEqualTo(1500);
        assertThat(goods.getQuantity()).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(strings = {"콜라,90,20", "콜라,105,20", "콜라,문자,20", "콜라,,20"})
    void 상품가격_예외테스트(String wrongInput) {
        assertThatThrownBy(() -> new Product(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
