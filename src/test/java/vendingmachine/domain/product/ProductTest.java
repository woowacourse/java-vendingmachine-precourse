package vendingmachine.domain.product;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.consumer.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1500;
    private final int COLA_AMOUNT = 20;
    private final int CONSUMER_BALANCE_POSSIBLE = 3000;
    private final int CONSUMER_BALANCE_IMPOSSIBLE = 1000;

    @Test
    void 상품_생성() {
        Product product = Product.of(COLA_NAME, COLA_PRICE, COLA_AMOUNT);
        assertThat(product.verifyName(COLA_NAME)).isTrue();
    }

    @Test
    void 구매자가_구매_가능한_상품() {
        Consumer consumer = Consumer.from(CONSUMER_BALANCE_POSSIBLE);
        Product product = Product.of(COLA_NAME, COLA_PRICE, COLA_AMOUNT);

        assertThat(consumer.possibleToBuy(product)).isTrue();
    }

    @Test
    void 구매자가_구매_불가능한_상품() {
        Consumer consumer = Consumer.from(CONSUMER_BALANCE_IMPOSSIBLE);
        Product product = Product.of(COLA_NAME, COLA_PRICE, COLA_AMOUNT);

        assertThat(consumer.possibleToBuy(product)).isFalse();
    }
}
