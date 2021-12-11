package vendingmachine.domain.product;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.consumer.Consumer;

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

    @Test
    void 구매자의_현재_잔액_확인하여_진행여부_결정_가능() {
        Consumer consumer = Consumer.from(3000);
        ProductStore productStore = ProductStore.getInstance();
        productStore.putProduct("콜라", Product.of("콜라", 1500, 10));

        assertThat(productStore.verifyEnoughConsumerBalance(consumer)).isTrue();
    }

    @Test
    void 구매자의_현재_잔액_확인하여_진행여부_결정_불가능() {
        Consumer consumer = Consumer.from(3000);
        ProductStore productStore = ProductStore.getInstance();
        productStore.putProduct("콜라", Product.of("콜라", 3500, 10));

        assertThat(productStore.verifyEnoughConsumerBalance(consumer)).isFalse();
    }
}
