package vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoodsTest {
    @Test
    void 상품명_가격_수량으로_이루어져_있다() {
        Goods goods = new Goods("콜라,1500,20");

        assertThat(goods.getName()).isEqualTo("콜라");
        assertThat(goods.getPrice()).isEqualTo(1500);
        assertThat(goods.getQuantity()).isEqualTo(20);
    }
}
