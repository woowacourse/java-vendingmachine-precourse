package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {
    @Test
    void 상품구매_테스트_정상() {
        // given
        Product product = new Product("콜라", 1500, 20);
        // when
        Product newProduct = product.buyOne();
        // then
        assertThat(newProduct.getCount()).isEqualTo(product.getCount() - 1);
    }

    @Test
    void 상품구매_테스트_소진된상품() {
        //given
        Product product = new Product("콜라", 1500, 0);
        // when, then
        assertThrows(IllegalArgumentException.class, product::buyOne);
    }
}