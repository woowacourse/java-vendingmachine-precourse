package vendingmachine.domain.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStoreTest {
    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1500;
    private final int COLA_AMOUNT = 20;

    @Test
    void 제품_저장소_생성_및_상품_추가() {
        ProductStore productStore = ProductStore.getInstance();
        productStore.putProduct(COLA_NAME, Product.of(COLA_NAME, COLA_PRICE, COLA_AMOUNT));
        assertThat(productStore.hasProduct(COLA_NAME)).isTrue();
    }
}
