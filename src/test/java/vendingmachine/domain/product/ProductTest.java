package vendingmachine.domain.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1500;
    private final int COLA_AMOUNT = 20;

    @Test
    void 상품_생성() {
        Product product = Product.from(COLA_NAME, COLA_PRICE, COLA_AMOUNT);
        assertThat(product.verifyName(COLA_NAME)).isTrue();
    }
}
