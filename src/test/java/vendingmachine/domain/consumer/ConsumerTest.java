package vendingmachine.domain.consumer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerTest {
    @Test
    void 사용자_초기_투입금액_설정() {
        Consumer consumer = Consumer.from(3000);
        assertThat(consumer.hasBalance(3000)).isTrue();
    }

    @Test
    void 사용자_잔액_차감() {
        Consumer consumer = Consumer.from(3000);
        consumer.reduceBalance(1500);
        assertThat(consumer.hasBalance(1500)).isTrue();
    }
}
