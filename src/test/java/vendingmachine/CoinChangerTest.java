package vendingmachine;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinChangerTest {

    @DisplayName("보유 금액이 10원 단위가 아닐 경우 예외를 발생한다.")
    @Test
    void validateMoney() {
        assertThatThrownBy(() -> new CoinChanger(5757)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("보유 금액으로 동전을 랜덤하게 반환한다.")
    @Test
    void changeToCoins() {
        CoinChanger coinChanger = new CoinChanger(1000);
        AtomicInteger sum = new AtomicInteger();
        coinChanger.changeToCoin().forEach((coin, integer) -> sum.addAndGet(coin.getAmount() * integer));
        assertThat(sum.intValue()).isEqualTo(1000);
    }
}